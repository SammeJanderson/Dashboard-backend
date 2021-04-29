package com.sammjanderson.PerkProgramApi.configuration;

import com.sammjanderson.PerkProgramApi.dto.request.client.NewClientDTO;
import com.sammjanderson.PerkProgramApi.dto.request.product.ProductDTO;
import com.sammjanderson.PerkProgramApi.entity.Company;
import com.sammjanderson.PerkProgramApi.service.ClientService;
import com.sammjanderson.PerkProgramApi.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DataLoader implements CommandLineRunner {
    ProductService productService;
    ClientService clientService;


    @Override
    public void run(String... args) throws Exception {
        this.clientService.registerNewClient(new NewClientDTO("Samme", "Janderson", 200));
        this.productService.createNewProduct(new ProductDTO("Product 01", "Bla bla bla", 100,
                List.of("imageURl01", "ImageUrl2", "ImageURL03"), new Company("Company name", "company Logo url")));

    }
}
