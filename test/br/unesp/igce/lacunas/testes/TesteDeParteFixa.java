package br.unesp.igce.lacunas.testes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import br.unesp.igce.lacunas.ExpressaoGeradora;
import br.unesp.igce.lacunas.Gerador;
import br.unesp.igce.lacunas.ParteDeExpressao;
import br.unesp.igce.lacunas.ParteFixa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author orlando
 */
public class TesteDeParteFixa {
    
    private String fixa1 = "Em teste ";
    private String fixa2 = "JUnit 4 ";
    private String fixa3 = "Java World ";
    private ParteFixa parte1 = new ParteFixa(fixa1);
    private ParteFixa parte2 = new ParteFixa(fixa2);
    private ParteFixa parte3 = new ParteFixa(fixa3);
    private Gerador g1;
    private Gerador g2;
    private Gerador g3;
    
    public TesteDeParteFixa() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ExpressaoGeradora expA = new ExpressaoGeradora(1);
        expA.colar(parte1);
        ExpressaoGeradora[] expsI = {expA};
        g1 = new Gerador(expsI);
        ExpressaoGeradora expB = new ExpressaoGeradora(1);
        expB.colar(parte1);
        expB.colar(parte2);
        ExpressaoGeradora[] expsII = {expB};
        g2 = new Gerador(expsII);
        ExpressaoGeradora expC = new ExpressaoGeradora(1);
        expC.colar(parte1);
        expC.colar(parte2);
        expC.colar(parte3);
        ExpressaoGeradora[] expsIII = {expC};
        g3 = new Gerador(expsIII);
         
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testarGeracaoSimples() {
       String resultado = g1.prox();
       assertEquals(fixa1, resultado);
    }
    
    @Test
    public void testarGeracaoDupla() {
       String resultado = g2.prox();
       assertEquals(fixa1 + fixa2, resultado);
       assertNotSame(parte1, resultado);
    }
    
}