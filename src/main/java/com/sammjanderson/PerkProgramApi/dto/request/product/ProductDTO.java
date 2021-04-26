package com.sammjanderson.PerkProgramApi.dto.request.product;


import com.sammjanderson.PerkProgramApi.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID productId;

    private String name;

    private String description;

    private Integer points;

    private String[] images;

    private Company company;

}
