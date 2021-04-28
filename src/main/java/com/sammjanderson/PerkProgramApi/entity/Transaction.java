package com.sammjanderson.PerkProgramApi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    private Integer transactionId;


    @Column
    private String productName;

    @Column
    private Integer productCost;

    @Column
    private Integer previousBalance;

    @Column
    private Integer newBalance;



}
