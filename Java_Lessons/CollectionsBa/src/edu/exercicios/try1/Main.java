package edu.exercicios.try1;

import java.util.*;

public class Main {
        public static void main(String[] args) {
                /**
                 * Crie uma classe LinguagemFavorita que possua os atributos
                 * nome, anoDeCriacao e ide. Em seguida, crie um conjunto com
                 * 3 linguagens e faça um programa que ordene esse conjunto
                 * por:
                 * 
                 * Ordem de Inserção
                 * 
                 * Ordem Natural (nome)
                 * 
                 * IDE
                 * 
                 * Ano de criação e nome
                 * 
                 * Nome, ano de criacao e IDE
                 * 
                 * Ao final, exiba as linguagens no console, um abaixo da outra.
                 */

                HashSet<LinguagemFavorita> listaLing = new HashSet<>() {
                        {
                                add(new LinguagemFavorita("VSCODE", "Java", 1999));
                                add(new LinguagemFavorita("VSCODE", "Python", 2010));
                                add(new LinguagemFavorita("VIM", "C", 1900));
                        }
                };

                // Printing it
                for (LinguagemFavorita linguagemFavorita : listaLing) {
                        System.out.println(linguagemFavorita); // It is possible because I have overrided toString
                                                               // Method
                }

                System.out.println(listaLing.contains("VSCODE"));
        }
}
