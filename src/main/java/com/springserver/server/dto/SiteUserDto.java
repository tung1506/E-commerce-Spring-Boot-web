package com.springserver.server.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteUserDto {
    String email;
    String username;
    String password;
}