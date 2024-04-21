package com.springserver.server.security;

import com.springserver.server.exception.MissingTokenException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        try {
            final String authorizationHeader = request.getHeader("Authorization");
            if (authorizationHeader == null) {
                throw new MissingTokenException("Missing JWT token");
            }
            final String jwt;
            final String username;
            if(!authorizationHeader.startsWith("Bearer ")){
                filterChain.doFilter(request, response);
                return;
            }
            jwt = authorizationHeader.substring(7);
            username = jwtUtil.extractUsername(jwt);
            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
                final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
                if(jwtUtil.isTokenValid(jwt, userDetails)){
                    final UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
                filterChain.doFilter(request, response);
            }
        } catch (MissingTokenException ex) {
            // Set the response status and body manually
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(ex.getMessage());
        }
    }
}
