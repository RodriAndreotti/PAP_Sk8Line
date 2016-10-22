/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.usuario.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
public class PasswordTest {
    
    public PasswordTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSalt method, of class Password.
     */
    @Test
    public void testGetSalt() {
        Password instance = new Password("asdjkfhwoiqu187823489713");
        String expResult = "asdjkfhwoiqu187823489713";
        String result = instance.getSalt();
        assertEquals(expResult, result);

    }

    /**
     * Test of encrypt method, of class Password.
     */
    @Test
    public void testEncrypt() {
        Password instance = new Password("asdjkfhwoiqu187823489713");
        String expResult = "DE04760EDB705AE98C5BEAA9EBB4A721F221EE276B4C1508D500E665EB20571C";
        String result = instance.encrypt("123mudar");
        assertEquals(expResult, result);

    }
    
    @Test
    public void testConstrutor(){
        Password instance = new Password();
    }
    
}
