package com.sammjanderson.PerkProgramApi.configuration;


import com.sammjanderson.PerkProgramApi.dto.request.client.ClientDTO;
import com.sammjanderson.PerkProgramApi.entity.Transaction;
import com.sammjanderson.PerkProgramApi.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DataLoader implements ApplicationRunner {

    private final ClientService clientService;


    @Override
    public void run(ApplicationArguments args) throws Exception {
    this.clientService.createNewClient(new ClientDTO("Samme janderson","Samme.san@gmail.com",10));

    }
}
