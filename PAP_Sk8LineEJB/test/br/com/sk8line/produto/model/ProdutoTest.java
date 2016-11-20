/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.produto.model;

import br.com.sk8line.garantia.model.TermoGarantia;
import java.util.Date;
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
public class ProdutoTest {
    
    public ProdutoTest() {
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
     * Test of equals method, of class Produto.
     */
    @Test
    public void testaSeEhDiferente() {
        System.out.println("equals");
        Object obj = null;
        
        TermoGarantia termo = new TermoGarantia();
        termo.setId(1);
        termo.setPeriodo(12);
        termo.setTermos("<h1>termo de teste</h1>");
        termo.setTitulo("termo de teste");
        
        
        Produto instance = new Produto();
        instance.setNome("Produto de teste");
        instance.setAltura(10);
        instance.setLargura(15);
        instance.setComprimento(15);
        instance.setDescricao("<p> Descrição de teste </p>");
        instance.setValor(150.00);
        instance.setTermoGarantia(termo);
        
        Estoque estoque = new Estoque();
        estoque.setId(1);
        estoque.setProduto(instance);
        estoque.setQuantidade(5);
        estoque.setUltimaAtualizacao(new Date());
        
        instance.setEstoque(estoque);
        

        
        
        Produto instance2 = new Produto();
        instance2.setNome("Produto de teste 2");
        instance2.setAltura(10);
        instance2.setLargura(15);
        instance2.setComprimento(15);
        instance2.setDescricao("<p> Descrição de teste </p>");
        instance2.setValor(150.00);
        instance2.setTermoGarantia(termo);
        
        Estoque estoque2 = new Estoque();
        estoque2.setId(1);
        estoque2.setProduto(instance);
        estoque2.setQuantidade(10);
        estoque2.setUltimaAtualizacao(new Date());
        
        instance2.setEstoque(estoque2);
        
        
        boolean expResult = false;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testaSeEhIgual() {
        System.out.println("equals");
        Object obj = null;
        
        TermoGarantia termo = new TermoGarantia();
        termo.setId(1);
        termo.setPeriodo(12);
        termo.setTermos("<h1>termo de teste</h1>");
        termo.setTitulo("termo de teste");
        
        
        Produto instance = new Produto();
        instance.setNome("Produto de teste");
        instance.setAltura(10);
        instance.setLargura(15);
        instance.setComprimento(15);
        instance.setDescricao("<p> Descrição de teste </p>");
        instance.setValor(150.00);
        instance.setTermoGarantia(termo);
        
        
        Estoque estoque = new Estoque();
        estoque.setId(1);
        estoque.setProduto(instance);
        estoque.setQuantidade(5);
        estoque.setUltimaAtualizacao(new Date());
        instance.setEstoque(estoque);

        
        
        Produto instance2 = new Produto();
        instance2.setNome("Produto de teste");
        instance2.setAltura(10);
        instance2.setLargura(15);
        instance2.setComprimento(15);
        instance2.setDescricao("<p> Descrição de teste </p>");
        instance2.setValor(150.00);
        instance2.setTermoGarantia(termo);
        instance2.setEstoque(estoque);
        
        
        boolean expResult = true;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);

    }
    
}
