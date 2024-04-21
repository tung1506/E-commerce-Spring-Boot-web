package com.springserver.server.service.user;

import com.springserver.server.dto.SiteUserDto;
import com.springserver.server.security.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse register(SiteUserDto siteUser);
    AuthenticationResponse login(SiteUserDto siteUser);
}
