package com.sammjanderson.PerkProgramApi.controller;

import com.sammjanderson.PerkProgramApi.dto.request.order.OrderDTO;
import com.sammjanderson.PerkProgramApi.dto.response.orders.TransactionStatusDTO;
import com.sammjanderson.PerkProgramApi.dto.response.MessageDTO;
import com.sammjanderson.PerkProgramApi.enums.OrderStatus;
import com.sammjanderson.PerkProgramApi.exception.ClientNotFoundException;
import com.sammjanderson.PerkProgramApi.exception.OrderNotFoundException;
import com.sammjanderson.PerkProgramApi.exception.ProductNotFoundException;
import com.sammjanderson.PerkProgramApi.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OrderController {

    TransactionService transactionService;

    @GetMapping
    public List<TransactionStatusDTO> getAllOrders(){
        return transactionService.getALlTransactions();
    }

    @PatchMapping("/{id}")
    public MessageDTO changeOrderStatus(@PathVariable UUID id, @RequestParam OrderStatus orderStatus) throws OrderNotFoundException {
        return transactionService.changeOrderStatus(id, orderStatus);
    }

    @PostMapping
    public MessageDTO placeOrder(@RequestBody  OrderDTO dto) throws ClientNotFoundException, ProductNotFoundException {
        return transactionService.placeOrder(dto);
    }




}
