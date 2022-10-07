package com.fareye.training.util;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class HashPassword {

    public static String hash(String password) {
        SecureRandom sr = new SecureRandom();
        byte[] salt = sr.generateSeed(12);

        PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray(), salt, 10, 512);
        SecretKeyFactory skf;

        {
            try {
                skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

        byte[] hash = new byte[0];
        try {
            hash = skf.generateSecret(pbeKeySpec).getEncoded();
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }

        String base64Hash = Base64.getMimeEncoder().encodeToString(hash);

        return base64Hash;
    }


}
