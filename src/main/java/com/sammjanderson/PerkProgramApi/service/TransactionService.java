package com.sammjanderson.PerkProgramApi.service;

import com.sammjanderson.PerkProgramApi.dto.request.trasaction.OrderDTO;
import com.sammjanderson.PerkProgramApi.dto.request.trasaction.TransactionDTO;
import com.sammjanderson.PerkProgramApi.dto.response.MessageDTO;
import com.sammjanderson.PerkProgramApi.entity.Client;
import com.sammjanderson.PerkProgramApi.entity.Product;
import com.sammjanderson.PerkProgramApi.entity.Transaction;
import com.sammjanderson.PerkProgramApi.exception.ClientNotFoundException;
import com.sammjanderson.PerkProgramApi.exception.ProductNotFoundException;
import com.sammjanderson.PerkProgramApi.mapping.TransactionMapper;
import com.sammjanderson.PerkProgramApi.repository.ClientRepository;
import com.sammjanderson.PerkProgramApi.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TransactionService {

    private final TransactionMapper transactionMapper = TransactionMapper.INSTANCE;

    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
    private final ProductService productService;
    private final ClientService clientService;


    //create new transaction

    public MessageDTO placeOrder(OrderDTO dto) throws ClientNotFoundException, ProductNotFoundException {
        Client clientMakingOrder = clientService.verifyIfClientExists(dto.getClientId());
        Product productOrder = productService.verifyIfProductExists(dto.getProductId());

        //create new transaction
        Transaction transaction = transactionMapper.toModel(new TransactionDTO(
                clientMakingOrder.getClientId(),
                productOrder.getName(),
                productOrder.getProductId(),
                productOrder.getPoints(),
                clientMakingOrder.getPointBalance(),
                clientMakingOrder.getPointBalance() - productOrder.getPoints()
        ));

        //subtract product point from client balance
        clientMakingOrder.setPointBalance(transaction.getNewBalance());

        clientMakingOrder.getTransactions().add(transaction);
        clientRepository.save(clientMakingOrder);


        return CreateMessageDTO("New Order placed. Order Number", transaction.getOrderNumber());

    }


    //USe authentication service to authenticate all transactions

    //The service gets the user and the product info to make the transaction


    private MessageDTO CreateMessageDTO(String message, String id) {
        return MessageDTO.builder().message(message + id).build();
    }
}
