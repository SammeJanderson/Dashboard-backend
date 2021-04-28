package com.sammjanderson.PerkProgramApi.controller;

import com.sammjanderson.PerkProgramApi.dto.request.client.ClientDTO;
import com.sammjanderson.PerkProgramApi.dto.response.MessageDTO;
import com.sammjanderson.PerkProgramApi.exception.ClientNotFoundException;
import com.sammjanderson.PerkProgramApi.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/client")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/all")
    public List<ClientDTO> listAllClients() {
        return clientService.listAllClients();
    }

    //TODO: create dto to client without sensitive information
    @GetMapping("/{id}")
    public ClientDTO getClientById(@PathVariable UUID id) throws ClientNotFoundException {
        return clientService.findClientById(id);
    }

    //TODO: fix this client should be registered with only the email info
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageDTO registerNewClient(@RequestBody ClientDTO clientDTO) {
        return clientService.createNewClient(clientDTO);

    }

    @DeleteMapping("/{id}")
    public void deleteClientByID(@PathVariable UUID id) throws ClientNotFoundException {
        clientService.deleteClientById(id);

    }

}
