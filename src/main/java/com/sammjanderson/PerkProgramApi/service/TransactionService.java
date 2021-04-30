package com.sammjanderson.PerkProgramApi.service;

import com.sammjanderson.PerkProgramApi.dto.request.order.OrderDTO;
import com.sammjanderson.PerkProgramApi.dto.request.order.TransactionDTO;
import com.sammjanderson.PerkProgramApi.dto.response.orders.TransactionStatusDTO;
import com.sammjanderson.PerkProgramApi.dto.response.MessageDTO;
import com.sammjanderson.PerkProgramApi.entity.Client;
import com.sammjanderson.PerkProgramApi.entity.Product;
import com.sammjanderson.PerkProgramApi.entity.Transaction;
import com.sammjanderson.PerkProgramApi.enums.OrderStatus;
import com.sammjanderson.PerkProgramApi.exception.ClientNotFoundException;
import com.sammjanderson.PerkProgramApi.exception.OrderNotFoundException;
import com.sammjanderson.PerkProgramApi.exception.ProductNotFoundException;
import com.sammjanderson.PerkProgramApi.mapping.TransactionMapper;
import com.sammjanderson.PerkProgramApi.repository.ClientRepository;
import com.sammjanderson.PerkProgramApi.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TransactionService {

    private final TransactionMapper transactionMapper = TransactionMapper.INSTANCE;
    private final TransactionRepository transactionRepository;

    private final ClientRepository clientRepository;
    private final ProductService productService;
    private final ClientService clientService;


    //create new transaction

    public MessageDTO placeOrder(OrderDTO dto) throws ClientNotFoundException, ProductNotFoundException {
        //get client and product
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

        //save transaction to the client history
        clientMakingOrder.getTransactions().add(transaction);
        clientRepository.save(clientMakingOrder);

        return CreateMessageDTO("New Order placed. Order Number", transaction.getOrderNumber());

    }


    //find all orders
    public List<TransactionStatusDTO> getALlTransactions() {
        List<Transaction> allTransactions = transactionRepository.findAll();
        return allTransactions.stream().map(transactionMapper::toDTO2).collect(Collectors.toList());
    }

    //change order status
    public MessageDTO changeOrderStatus(UUID transactionID, OrderStatus orderStatus) throws OrderNotFoundException {
        Transaction transactionToComplete = verifyIfTransactionExists(transactionID);
        if (transactionToComplete.getOrderStatus() == orderStatus) {
            return CreateMessageDTO("Can't change status for Order Number:", transactionToComplete.getOrderNumber());
        }

        transactionToComplete.setOrderStatus(OrderStatus.COMPLETED);
        transactionRepository.save(transactionToComplete);
        return CreateMessageDTO("This order was changed for Order Number:", transactionToComplete.getOrderNumber());
    }


    public Transaction verifyIfTransactionExists(UUID id) throws OrderNotFoundException {
        return transactionRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));

    }


    private MessageDTO CreateMessageDTO(String message, String id) {
        return MessageDTO.builder().message(message + id).build();
    }
}
