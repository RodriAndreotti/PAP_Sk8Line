/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.usuario.dao;

import br.com.sk8line.common.dao.DAO;
import br.com.sk8line.usuario.model.Usuario;
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
public class UsuarioDAOTest {
    
    private UsuarioDAO instance;
    
 
    
    @Before
    public void setUp() {
        this.instance = new UsuarioDAO();
    }
    /**
     * Test of doLogin method, of class UsuarioDAO.
     */
    @Test
    public void testDoLogin() {
        /*System.out.println("doLogin");
        String email = "";
        String senha = "";
        UsuarioDAO instance = null;
        Usuario expResult = null;
        Usuario result = instance.doLogin(email, senha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of existeUsuario method, of class UsuarioDAO.
     */
    @Test
    public void testExisteUsuario() {
        System.out.println("existeUsuario");
        String email = "teste@teste.com.br";
        
        boolean result = instance.existeUsuario(email);
        assertTrue(result);
        
    }
    
}
