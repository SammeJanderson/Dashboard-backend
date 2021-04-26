package com.sammjanderson.PerkProgramApi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID clientId;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String sha256Password;

    @Column
    String salt;

    @Column
    private Boolean wasActivated = false;

    @OneToMany
    List<Receipt> receipts;
}
