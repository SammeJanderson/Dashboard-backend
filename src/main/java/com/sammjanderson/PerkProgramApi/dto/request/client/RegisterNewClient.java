package com.sammjanderson.PerkProgramApi.dto.request.client;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.security.MessageDigest;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterNewClient {
    private String name;

    private String email;

    private Integer pointBalance;

    private String sha256Password ;
}
