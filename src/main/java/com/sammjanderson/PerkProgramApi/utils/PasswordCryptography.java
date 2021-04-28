/**
 * code extracted from www.geeksforgeeks.org/sha-256-hash-in-java/
 */
package com.sammjanderson.PerkProgramApi.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordCryptography {


    public static String getSHA(String string) throws NoSuchAlgorithmException {

        //instance of sha256 algorithm
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        //convert string to bytes
        byte[] hash = md.digest(string.getBytes(StandardCharsets.UTF_8));

        //convert byte array to signum representation
        BigInteger number = new BigInteger(1, hash);

        //convert signum representation to hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        //pad with leading zeros

        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }
}
