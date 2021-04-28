package com.sammjanderson.PerkProgramApi.controller;

import com.sammjanderson.PerkProgramApi.dto.request.product.ProductDTO;
import com.sammjanderson.PerkProgramApi.dto.response.MessageDTO;
import com.sammjanderson.PerkProgramApi.exception.ProductNotFoundException;
import com.sammjanderson.PerkProgramApi.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/client")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {

    private final ProductService  productService;

    @GetMapping("/all")
    public List<ProductDTO> listAllProducts() {
        return productService.listAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable UUID id) throws ProductNotFoundException {
        return productService.findProductById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageDTO registerNewProduct(@RequestBody ProductDTO clientDTO) {
        return productService.createNewProduct(clientDTO);

    }

    @DeleteMapping("/{id}")
    public void deleteProductByID(@PathVariable UUID id) throws ProductNotFoundException {
        productService.deleteProductById(id);

    }

}
