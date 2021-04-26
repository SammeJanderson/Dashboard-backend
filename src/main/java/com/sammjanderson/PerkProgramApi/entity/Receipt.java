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

/** this class has two ids, the first(receipt Id) is exclusive for database management, the second (order id) is for the admin and client convenience*/
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID receiptId;

    @Column
    private String orderId;

    @Column
    @OneToMany
    private List<Product> products;

}
