package com.sammjanderson.PerkProgramApi.mapping;

import com.sammjanderson.PerkProgramApi.dto.request.product.ProductDTO;
import com.sammjanderson.PerkProgramApi.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toModel(ProductDTO productDTO);

    ProductDTO toDTO(Product product);
}
