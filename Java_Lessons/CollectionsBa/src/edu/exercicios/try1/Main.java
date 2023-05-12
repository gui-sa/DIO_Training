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
                 * Acabei fazendo um freeStyle para aprender melhor os ganhos e percas
                 */

                System.out.println("\nUsing HashSet and assessing its hashcode:");

                Set<LinguagemFavorita> listaLing = new HashSet<>() {
                        {
                                add(new LinguagemFavorita("VSCODE", "Java", 1999));
                                add(new LinguagemFavorita("VSCODE", "Python", 2010));
                                add(new LinguagemFavorita("Anaconda", "Python", 2000));
                                add(new LinguagemFavorita("Anaconda", "Python", 2190));
                                add(new LinguagemFavorita("VIM", "C", 1900));
                        }
                };

                // Printing it
                for (LinguagemFavorita linguagemFavorita : listaLing) {
                        System.out.println(linguagemFavorita.hashCode()); // It is possible because I have overrided
                        // toString
                        // Method
                }

                System.out.println("\nUsing HashSet:");

                for (LinguagemFavorita linguagemFavorita : listaLing) { // you can see that on hashset list it follows
                        // random order
                        System.out.println(linguagemFavorita);
                }

                System.out.println("\nUsing LinkedHashSet:");
                Set<LinguagemFavorita> listaLing2 = new LinkedHashSet<>() {
                        {
                                add(new LinguagemFavorita("VSCODE", "Java", 1999));
                                add(new LinguagemFavorita("VSCODE", "Python", 2010));
                                add(new LinguagemFavorita("Anaconda", "Python", 2000));
                                add(new LinguagemFavorita("Anaconda", "Python", 2190));
                                add(new LinguagemFavorita("VIM", "C", 1900));
                        }
                };

                for (LinguagemFavorita linguagemFavorita : listaLing2) { // you can see that on Linkedhashset list it
                        // follows
                        // insertion order
                        System.out.println(linguagemFavorita);
                }

                System.out.println("\nUsing Comparable in TreeSet:");
                Set<LinguagemFavorita> listaLing3 = new TreeSet<>() {
                        {
                                add(new LinguagemFavorita("VSCODE", "Java", 1999));
                                add(new LinguagemFavorita("VSCODE", "Python", 2010));
                                add(new LinguagemFavorita("Anaconda", "Python", 2000));
                                add(new LinguagemFavorita("Anaconda", "Python", 2190));
                                add(new LinguagemFavorita("VIM", "C", 1900));
                        }
                };

                for (LinguagemFavorita linguagemFavorita : listaLing3) { // you can see that on Linkedhashset list it
                                                                         // follows
                        // natural ordering, or, comparable or comparator
                        System.out.println(linguagemFavorita);
                }

                System.out.println("\nUsing Comparator in TreeSet:");
                Set<LinguagemFavorita> listaLing4 = new TreeSet<>(new CompareByDate()) {
                        {
                                add(new LinguagemFavorita("VSCODE", "Java", 1999));
                                add(new LinguagemFavorita("VSCODE", "Python", 2010));
                                add(new LinguagemFavorita("Anaconda", "Python", 2000));
                                add(new LinguagemFavorita("Anaconda", "Python", 2190));
                                add(new LinguagemFavorita("VIM", "C", 1900));
                        }
                };
                for (LinguagemFavorita linguagemFavorita : listaLing4) { // you can see that on Linkedhashset list it
                                                                         // follows
                        // natural ordering, or, comparable or comparator
                        System.out.println(linguagemFavorita);
                }

        }

        static public class CompareByDate implements Comparator<LinguagemFavorita> {
                @Override
                public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
                        if (o1.getAnoDeCriacao() < o2.getAnoDeCriacao())
                                return 1; // returns 1 to say to first one gets to the right
                        if (o1.getAnoDeCriacao() > o2.getAnoDeCriacao())
                                return -1; // returns -1 to say to the first one gets to the left
                        return 0; // 0 to stays the same
                }
        }
}
