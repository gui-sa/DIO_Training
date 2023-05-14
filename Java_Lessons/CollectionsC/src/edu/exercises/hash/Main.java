package edu.exercises.hash;

import com.atores.*;
import java.util.*;

public class Main {
        public static void main(String[] args) {
                /**
                 * Exercicio para praticar (vindo do CLASS quando aprendi C#):
                 * Criar classe aviao com atributos:
                 * Numero de acentos
                 * Nome da nave
                 * ID
                 * Esta classe deve conseguir adicionar e remover passageiros (sem duplicatas)
                 * atraves de metodos proprios que retornem um boolean caso consigam adicionar
                 * Ela deve ter uma funcao que mostra o numero de acentos livres.
                 * Ela deve ter uma funcao que mostra os acentos que estao livres.
                 * Deve conter um metodo que retorna os passageiros por ordem alfabetica
                 * Deve ser capaz de printar um resumo do aviao
                 * 
                 * 
                 * Outra Classe Clientes com atributos:
                 * Nome
                 * CPF
                 * Idade
                 * 
                 * Deve conter uma classe que filtra os Clientes de um aviao por uma faixa de
                 * idade.
                 * 
                 */

                System.out.println("YEAH");

                List<Aviao> comercial = new ArrayList<>() {
                        {
                                add(new Aviao("Queridinho do papai", 60));
                                add(new Aviao("Boing777", 200));
                                add(new Aviao("ANATEL BUS", 110));
                        }
                };

                comercial.get(0)
        }
}
