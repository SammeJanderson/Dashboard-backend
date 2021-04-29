package com.sammjanderson.PerkProgramApi.entity;

import com.sammjanderson.PerkProgramApi.enums.OrderStatus;
import com.sammjanderson.PerkProgramApi.utils.OrderNumberGenerator;
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
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID transactionId;

    @Column
    private String productName;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID productId;

    @Column
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID clientId;

    @Column
    private Integer productCost;

    @Column
    private Integer previousBalance;

    @Column
    private Integer newBalance;

    @Column
    private String orderNumber = OrderNumberGenerator.generateOrderId();

    @Column
    private OrderStatus orderStatus = OrderStatus.PENDENT;


}
