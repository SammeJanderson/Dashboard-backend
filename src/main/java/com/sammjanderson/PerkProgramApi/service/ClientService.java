package com.sammjanderson.PerkProgramApi.service;

import com.sammjanderson.PerkProgramApi.dto.request.client.ClientDTO;
import com.sammjanderson.PerkProgramApi.dto.response.MessageDTO;
import com.sammjanderson.PerkProgramApi.entity.Client;
import com.sammjanderson.PerkProgramApi.exception.ClientNotFoundException;
import com.sammjanderson.PerkProgramApi.mapping.ClientMapper;
import com.sammjanderson.PerkProgramApi.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService {

    private final ClientMapper clientMapper = ClientMapper.INSTANCE;
    private ClientRepository clientRepository;

    public MessageDTO createNewClient(ClientDTO clientDTO) {
        Client clientToSave = clientMapper.toModel(clientDTO);

        Client savedClient = clientRepository.save(clientToSave);
        return CreateMessageDTO("Registered new Client", savedClient.getClientId());
    }

    public List<ClientDTO> listAllClients() {
        List<Client> allClients = clientRepository.findAll();
        return allClients.stream().map(clientMapper::toDTO).collect(Collectors.toList());
    }

    public ClientDTO findClientById(UUID id) throws ClientNotFoundException {
        Client client = verifyIfClientExists(id);
        return clientMapper.toDTO(client);
    }

    public MessageDTO updateClientById(UUID id, ClientDTO clientDTO) throws ClientNotFoundException {
        verifyIfClientExists(id);
        Client clientToUpdate = clientMapper.toModel(clientDTO);

        Client updatedClient = clientRepository.save(clientToUpdate);
        return CreateMessageDTO("Updated card with Id: ", updatedClient.getClientId());
    }

    public void deleteClientById(UUID id) throws ClientNotFoundException {
        verifyIfClientExists(id);
        clientRepository.deleteById(id);
    }


    private Client verifyIfClientExists(UUID id) throws ClientNotFoundException {
        return clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException((id)));
    }


    private MessageDTO CreateMessageDTO(String message, UUID id) {
        return MessageDTO.builder().message(message + id).build();
    }


}
