package com.sammjanderson.PerkProgramApi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID productId;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Integer points;

    @Column
    @ElementCollection
    private List<String> images;

    @Column
    @Embedded
    private Company company;



}
