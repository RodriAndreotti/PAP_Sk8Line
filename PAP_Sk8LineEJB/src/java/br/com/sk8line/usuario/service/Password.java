/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.usuario.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
public class Password  {
    
    private String salt;
    private String method;
    
    public Password(String salt, String method) {
        if (salt == null) {
            SecureRandom sr = new SecureRandom();
            
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-1");
                
                byte saltByte[] = new byte[20];
                sr.nextBytes(saltByte);
                
                md.digest(saltByte);
                
                this.salt = bytesToHexString(saltByte);

            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Password.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.salt = salt;
        }
        this.method = method;
    }
    
    public Password(String salt) {
        this(salt, "SHA-256");
    }

    public Password() {
        this(null, "SHA-256");
    }
    
    
    
    public String getSalt() {
        return salt;
    }

    /**
     * Criptografa a senha utilizando um hash e um SALT
     *
     * @param senha senha em texto plano
     * @return Hash da senha
     */
    public String encrypt(String senha) {
        try {
            // Cria hash (criptografia) da senha utilizando o método informado no construtor (MD5, SHA-1, SHA-256 etc.)
            MessageDigest md = MessageDigest.getInstance(this.method);

            // Concatena o SALT informado no contrutor a senha informada
            senha = this.salt + senha;

            // o método md.digest faz a criptografia da senha em formato de bytes e armazena o resultado em outro array de bytes
            byte byteHash[] = md.digest(senha.getBytes("UTF-8"));

            // Hash final da senha
            String hash = bytesToHexString(byteHash);
            
            return hash;
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Password.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Password.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    private String bytesToHexString(byte[] bytes) {
        // Constrói uma string hexadecimal a partir do array de bytes acima
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        
        return hexString.toString();
    }
}
