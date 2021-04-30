package com.sammjanderson.PerkProgramApi.service;

import com.sammjanderson.PerkProgramApi.dto.request.client.AccountCredentialsDTO;
import com.sammjanderson.PerkProgramApi.dto.request.client.ClientDTO;
import com.sammjanderson.PerkProgramApi.dto.request.client.NewClientDTO;
import com.sammjanderson.PerkProgramApi.dto.response.MessageDTO;
import com.sammjanderson.PerkProgramApi.entity.Client;
import com.sammjanderson.PerkProgramApi.exception.ClientNotFoundException;
import com.sammjanderson.PerkProgramApi.mapping.ClientMapper;
import com.sammjanderson.PerkProgramApi.repository.ClientRepository;
import com.sammjanderson.PerkProgramApi.utils.PasswordCryptography;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService {

    private final ClientMapper clientMapper = ClientMapper.INSTANCE;
    private ClientRepository clientRepository;


    public List<ClientDTO> getAll() {
        List<Client> allClients = clientRepository.findAll();
        return allClients.stream().map(clientMapper::toDTO).collect(Collectors.toList());
    }


    public MessageDTO registerNewClient(NewClientDTO clientDTO) {
        Client clientToRegister = clientMapper.newClientDataToModel(clientDTO);

        Client savedClient = clientRepository.save(clientToRegister);
        return CreateMessageDTO("New client registered with id", savedClient.getClientId());
    }

    public ClientDTO findClientById(UUID id) throws ClientNotFoundException {
        Client client = verifyIfClientExists(id);
        return clientMapper.toDTO(client);
    }

    public MessageDTO activateAccount(AccountCredentialsDTO dto) throws ClientNotFoundException, NoSuchAlgorithmException {
        Client clientToActivate = verifyIfClientExists(dto.getId());
        String newPassword = PasswordCryptography.getSHA(dto.getPassword() + clientToActivate.getSalt());

        clientToActivate.setSha256Password(newPassword);
        clientToActivate.setIsActive(true);
        clientRepository.save(clientToActivate);


        return CreateMessageDTO("The account password was changed and is now activated id:", dto.getId());
    }


    //TODO: create a different service for the authentication
    public String verifyId(AccountCredentialsDTO dto) throws ClientNotFoundException, NoSuchAlgorithmException {
        Client clientToVerify = verifyIfClientExists(dto.getId());
        String password = PasswordCryptography.getSHA(dto.getPassword()+ clientToVerify.getSalt());

        if (clientToVerify.getSha256Password().equals(password))
            return "The password is correct" + clientToVerify.getSha256Password()+ " " + password;

        return "WRONGGG!!"  + clientToVerify.getSha256Password()+ " " + password;
    }



    public Client verifyIfClientExists(UUID id) throws ClientNotFoundException {
        return clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException((id)));
    }


    private MessageDTO CreateMessageDTO(String message, UUID id) {
        return MessageDTO.builder().message(message + id).build();
    }


}
