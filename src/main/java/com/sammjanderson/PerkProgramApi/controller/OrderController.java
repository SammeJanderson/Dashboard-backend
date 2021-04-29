package com.sammjanderson.PerkProgramApi.controller;

import com.sammjanderson.PerkProgramApi.dto.request.trasaction.OrderDTO;
import com.sammjanderson.PerkProgramApi.dto.response.MessageDTO;
import com.sammjanderson.PerkProgramApi.exception.ClientNotFoundException;
import com.sammjanderson.PerkProgramApi.exception.ProductNotFoundException;
import com.sammjanderson.PerkProgramApi.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OrderController {

    TransactionService transactionService;

    @PostMapping
    public MessageDTO placeOrder(@RequestBody  OrderDTO dto) throws ClientNotFoundException, ProductNotFoundException {
        return transactionService.placeOrder(dto);
    }


}
