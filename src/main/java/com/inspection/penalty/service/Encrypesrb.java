package com.inspection.penalty.service;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.inspection.penalty.repository.Tokenreposr;

@Service
public class Encrypesrb {

    @Autowired
    Tokenreposr tokenreposr;
    private static final String ALGORITHM = "AES/CBC/PKCS5PADDING";
    private static final String UTF_FORMATE = "UTF-8";
    private static final String ENCRYPTION_ALGO_TYPE = "AES";

    public String encrypt(String value, String initVector, String encryptionKey) {

        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(UTF_FORMATE));
            SecretKeySpec skeySpec = new SecretKeySpec(encryptionKey.getBytes(UTF_FORMATE), ENCRYPTION_ALGO_TYPE);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
            byte[] encrypted = cipher.doFinal(value.getBytes());
            return Base64.encodeBase64String(encrypted);
        } catch (Exception ex) {
            System.out.println("MasterCrypto encrypt "+ ex);
        }
        return null;
    }

    public String decrypt(String encrypted, String initVector, String encryptionKey) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(UTF_FORMATE));
            SecretKeySpec skeySpec = new SecretKeySpec(encryptionKey.getBytes(UTF_FORMATE), ENCRYPTION_ALGO_TYPE);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));
            return new String(original);
        } catch (Exception ex) {
            System.out.println("MasterCrypto decrypt "+ ex);
        }
        return null;
    }
    public String generateRandomIV() {
        int length = 16;
        SecureRandom ranGen = new SecureRandom();
        byte[] aesKey = new byte[16];
        ranGen.nextBytes(aesKey);
        StringBuffer result = new StringBuffer();
        for (byte b : aesKey) {
            result.append(String.format("%02x", b)); // convert to hex
        }
        if (length > result.toString().length()) {
            return result.toString();
        } else {
            return result.toString().substring(0, length);
        }

    }



    public int gettoken(int accessTokenExpiryTime,String jwtokken,String message,int refreshTokenExpiryTime,boolean t_status,String refreshToken){
       return tokenreposr.gettoken(accessTokenExpiryTime, jwtokken, message, refreshTokenExpiryTime, t_status, refreshToken);
    }
    
}
