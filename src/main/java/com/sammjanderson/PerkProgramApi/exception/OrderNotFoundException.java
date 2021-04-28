package com.sammjanderson.PerkProgramApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class OrderNotFoundException extends Exception {
    public OrderNotFoundException(UUID id) {
        super("Order With Id: " + id + " Not found");
    }

}
