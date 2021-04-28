package com.sammjanderson.PerkProgramApi.dto.request.client;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private String name;

    private String email;

    private Integer pointBalance;

    private String sha256Password;

    private String salt;

    private Boolean wasActivated = false;


}
