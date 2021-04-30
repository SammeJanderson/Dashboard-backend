package com.sammjanderson.PerkProgramApi.controller;

import com.sammjanderson.PerkProgramApi.dto.request.client.AccountCredentialsDTO;
import com.sammjanderson.PerkProgramApi.dto.request.client.ClientDTO;
import com.sammjanderson.PerkProgramApi.dto.request.client.NewClientDTO;
import com.sammjanderson.PerkProgramApi.dto.response.MessageDTO;
import com.sammjanderson.PerkProgramApi.entity.Client;
import com.sammjanderson.PerkProgramApi.exception.ClientNotFoundException;
import com.sammjanderson.PerkProgramApi.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/client")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientController {

    private ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageDTO registerNewClient(@RequestBody NewClientDTO clientDTO) {
        return clientService.registerNewClient(clientDTO);
    }


    @PostMapping("/activate")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public MessageDTO activateAccount(@RequestBody AccountCredentialsDTO dto) throws ClientNotFoundException, NoSuchAlgorithmException {
        return clientService.activateAccount(dto);
    }

    @GetMapping
    public List<ClientDTO> all() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public ClientDTO findClientById(@PathVariable UUID id) throws ClientNotFoundException {
        return clientService.findClientById(id);
    }

    @GetMapping("/authenticate")
    public String authenticate(@RequestBody AccountCredentialsDTO dto) throws ClientNotFoundException, NoSuchAlgorithmException {
        return clientService.verifyId(dto);
    }
}
