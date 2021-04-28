package com.sammjanderson.PerkProgramApi;

import com.sammjanderson.PerkProgramApi.utils.OrderNumberGenerator;
import com.sammjanderson.PerkProgramApi.utils.PasswordCryptography;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class PerkProgramApiApplication {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        SpringApplication.run(PerkProgramApiApplication.class, args);


        }

    }



