package com.sammjanderson.PerkProgramApi.dto.request.client;


import com.sammjanderson.PerkProgramApi.entity.Receipt;
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

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID clientId;

    private String name;

    private String email;

    private String sha256Password;

    String salt;

    private Boolean wasActivated = false;

    List<Receipt> receipts;
}
