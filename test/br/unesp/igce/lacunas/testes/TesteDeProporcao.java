/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.igce.lacunas.testes;

import br.unesp.igce.lacunas.ExpressaoGeradora;
import br.unesp.igce.lacunas.Gerador;
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
public class TesteDeProporcao {
    private String fixa1 = "Em teste ";
    private String fixa2 = "JUnit 4 ";
    private ParteFixa parte1 = new ParteFixa(fixa1);
    private ParteFixa parte2 = new ParteFixa(fixa2);
    private Gerador g1;
    private Gerador g2;

    
    public TesteDeProporcao() {
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
        ExpressaoGeradora expB = new ExpressaoGeradora(1);
        expA.colar(parte1);
        expB.colar(parte2);
        ExpressaoGeradora[] expsI = {expA,expB};
        g1 = new Gerador(expsI);
        ExpressaoGeradora expC = new ExpressaoGeradora(3);
        expC.colar(parte2);
        ExpressaoGeradora[] expsII = {expA,expC};
        g2 = new Gerador(expsII);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testarEquilibrio(){
        int conta1 = 0;
        int conta2 = 0;
        String res;
        for (int i = 0; i < 1000; i++) {
            res = g1.prox();
            if (res.equals(fixa1)) conta1++;
            if (res.equals(fixa2)) conta2++;
        }
        float prop = (float) (conta1*1.0/(conta1 + conta2));
        assertTrue("Gerador equilibrado funciona", prop > 0.45 && prop < 0.55);
    }

    @Test
    public void testarVies(){
        int conta1 = 0;
        int conta2 = 0;
        String res;
        for (int i = 0; i < 1000; i++) {
            res = g2.prox();
            if (res.equals(fixa1)) conta1++;
            if (res.equals(fixa2)) conta2++;
        }
        float prop = (float) (conta1*1.0/(conta1 + conta2));
        assertTrue("Gerador enviesado funciona", prop > 0.15 && prop < 0.35);
    }

}