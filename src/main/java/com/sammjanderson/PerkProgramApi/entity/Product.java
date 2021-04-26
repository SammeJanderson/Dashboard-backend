package com.sammjanderson.PerkProgramApi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID productId;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Integer points;

    @Column
    private String[] images;

    @Column
    @Embedded
    private Company company;

}
