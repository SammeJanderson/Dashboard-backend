package com.sammjanderson.PerkProgramApi.dto.request.product;


import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.sammjanderson.PerkProgramApi.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private String name;

    private String description;

    private Integer points;

    private List<String> images;

    private Company company;

}
