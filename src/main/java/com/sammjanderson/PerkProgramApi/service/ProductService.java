package com.sammjanderson.PerkProgramApi.service;

import com.sammjanderson.PerkProgramApi.dto.request.product.ProductDTO;
import com.sammjanderson.PerkProgramApi.dto.response.MessageDTO;
import com.sammjanderson.PerkProgramApi.entity.Product;
import com.sammjanderson.PerkProgramApi.exception.ProductNotFoundException;
import com.sammjanderson.PerkProgramApi.mapping.ProductMapper;
import com.sammjanderson.PerkProgramApi.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

    private final ProductMapper productMapper = ProductMapper.INSTANCE;
    private final ProductRepository productRepository;

    public MessageDTO createNewProduct(ProductDTO ProductDTO) {
        Product ProductToSave = productMapper.toModel(ProductDTO);

        Product savedProduct = productRepository.save(ProductToSave);
        return CreateMessageDTO("Registered new Product", savedProduct.getProductId());
    }

    public List<ProductDTO> listAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        return allProducts.stream().map(productMapper::toDTO).collect(Collectors.toList());
    }

    public ProductDTO findProductById(UUID id) throws  ProductNotFoundException {
        Product product = verifyIfProductExists(id);
        return productMapper.toDTO(product);
    }

    public MessageDTO updateProductById(UUID id, ProductDTO ProductDTO) throws  ProductNotFoundException {
        verifyIfProductExists(id);
        Product ProductToUpdate = productMapper.toModel(ProductDTO);

        Product updatedProduct = productRepository.save(ProductToUpdate);
        return CreateMessageDTO("Updated card with Id: ", updatedProduct.getProductId());
    }

    public void deleteProductById(UUID id) throws  ProductNotFoundException {
        verifyIfProductExists(id);
        productRepository.deleteById(id);
    }


    private Product verifyIfProductExists(UUID id) throws  ProductNotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException((id)));
    }


    private MessageDTO CreateMessageDTO(String message, UUID id) {
        return MessageDTO.builder().message(message + id).build();
    }


}
