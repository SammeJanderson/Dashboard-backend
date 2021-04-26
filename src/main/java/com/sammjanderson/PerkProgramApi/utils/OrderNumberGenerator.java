package com.sammjanderson.PerkProgramApi.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OrderNumberGenerator {
    private static final char[] possibleChars =
            {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                    'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    static Random random = new Random();

    public static String generateOrderId() {
        String orderID = "";

        for (int i = 0; i < 12; i++) {
            int index = random.nextInt(possibleChars.length-1);
            orderID += possibleChars[index];

        }

        return orderID;

    }

}
