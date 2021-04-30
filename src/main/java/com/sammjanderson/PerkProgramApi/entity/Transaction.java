package com.sammjanderson.PerkProgramApi.entity;

import com.sammjanderson.PerkProgramApi.enums.OrderStatus;
import com.sammjanderson.PerkProgramApi.utils.OrderNumberGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
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
    @Enumerated
    private OrderStatus orderStatus = OrderStatus.PENDENT;

    @Column
    private Date lastUpdated = new Date(System.currentTimeMillis());


}
