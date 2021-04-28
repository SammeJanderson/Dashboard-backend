package com.sammjanderson.PerkProgramApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(UUID id) {
        super("Product With Id: " + id + " Not found");
    }
}
