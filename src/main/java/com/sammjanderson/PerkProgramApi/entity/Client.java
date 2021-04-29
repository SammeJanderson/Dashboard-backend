package com.sammjanderson.PerkProgramApi.entity;

import com.sammjanderson.PerkProgramApi.utils.OrderNumberGenerator;
import com.sammjanderson.PerkProgramApi.utils.PasswordCryptography;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
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
    @Type(type = "org.hibernate.type.UUIDCharType")
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
    private Boolean isActive = false;

    @Column
    @OneToMany(cascade = CascadeType.ALL)
    private List<Transaction> transactions;



    {
        try {
            //this is very ugly but i'm using the order number generator to implement yet another ramdomness to the salt
            salt = PasswordCryptography.getSHA(name + email + OrderNumberGenerator.generateOrderId());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


}
