package com.sammjanderson.PerkProgramApi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID clientId;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private Integer pointBalance;

    @Column
    private String sha256Password;

    @Column
    String salt;

    @Column
    private Boolean wasActivated = false;


}
