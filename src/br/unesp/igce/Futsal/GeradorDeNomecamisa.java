/* Copyright 2013 Universidade Estadual Paulista
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.unesp.igce.lacunas;

import java.util.Random;

/**
 * Gerador de valores para criacao aleatoria de objetos e povoamento da base
 * de dados
 * Como sempre há disputas dentro de uma equipe, para a escolha do número de 
 * camisas que os jogadores irão usar, eis aqui uma ferramenta que sorteia
 * o número de camisas para os jogadores.
 * @author Diego
 */
public class GeradorDeNomecamisa {
    
    static private String[] nomes = {
      "Diego",
      "Jefferson",
      "Rafael",
      "Murilo",
      "Lucas",
      "Andre",
      "Felipe",
      "Bruno",
      "Rodolfo",
      "Rodrigo",
      "Tulio",
      "Wilson"
    };
  
    
    static private String[] numerocamisas = {
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10",
        "11",
        "12"
    };
    
    static private String prox() {
        
        ExpressaoGeradora fut = new ExpressaoGeradora(15);
        fut.colar(new ParteSorteada(nomes));
        fut.colar(new ParteSorteada(numerocamisas));
        
        
        ExpressaoGeradora[] opts = {fut};
        Gerador g = new Gerador(opts);
        
        return g.prox();

    }
    
    public static void main(String[] args){
        for (int i = 0; i < 12; i++){
            System.out.println(prox());
        }
    }
}
    
  
