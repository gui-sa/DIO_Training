package edu.exercises.list1;

import java.util.*;

public class Main {
        public static void main(String[] args) {
                /**
                 * Faça um programa que receba a temperatura média dos 6
                 * primeiros meses do ano e armazene-as em uma lista.
                 * 
                 * Após isto, calcule a média semestral das temperaturas e
                 * mostre todas as temperaturas acima desta média, e em que
                 * mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2
                 * – Fevereiro e etc).
                 */

                Scanner scanA = new Scanner(System.in);
                int numeroMeses = 6;
                List<Double> tempMeses = new ArrayList<>();
                for (int i = 0; i < numeroMeses; i++) {
                        System.out.print("Por favor Digite a temperatura do mes " + (i + 1) + ": ");
                        tempMeses.add(scanA.nextDouble());
                }

                // Uma maneira de fazer a soma;
                double soma = 0;
                for (Double temp : tempMeses) {
                        soma += temp;
                }
                // System.out.println(soma);

                // Segunda maneira de fazer a soma;
                soma = 0;
                for (int i = 0; i < tempMeses.size(); i++) {
                        soma += tempMeses.get(i);
                }
                // System.out.println(soma);

                // Terceira maneira de fazer a soma;
                soma = 0;
                Iterator<Double> itera = tempMeses.iterator(); // gets a iterator from a list
                while (itera.hasNext()) {
                        soma += itera.next();
                }
                // each itera is the space in memory
                System.out.println(soma);

                // Prosseguindo
                double media = soma / tempMeses.size();
                // System.out.println(media);

                Map<Integer, String> meses = new HashMap<Integer, String>() {
                        {
                                put(1, "Janeiro");
                                put(2, "Fevereiro");
                                put(3, "Março");
                                put(4, "Abril");
                                put(5, "Maio");
                                put(6, "Junho");

                        }
                };

                for (int i = 0; i < numeroMeses; i++) {
                        if (tempMeses.get(i) > media) {
                                System.out.println(tempMeses.get(i) + " - " + meses.get(i + 1));
                        }
                }

                // Se quiser excluir ou modificar algum mes: vamos supor excluir o mes de junho
                tempMeses.remove(5);
                System.out.println(tempMeses);
                tempMeses.remove(2);
                System.out.println(tempMeses);

                // Vale lembrar que o correto seria a gente ter feito uma classe mes que contem
                // temperatura, nome, etc...

                // What is the max value?
                // Max is Static Method... double has comparable defined but be careful when
                // dealing with object
                System.out.println(Collections.max(tempMeses));

                // Can you sort it in crescent way?
                Collections.sort(tempMeses); // It was possible becase double class has comparable interface with
                                             // compareTo method implemented inside
                System.out.println(tempMeses);

                // Can I invert it?

                Collections.sort(tempMeses, (new Comparator<Double>() {
                        @Override
                        public int compare(Double d1, Double d2) {
                                if (d1 < d2)
                                        return 1; // returns 1 to say to first one gets to the right
                                if (d1 > d2)
                                        return -1; // returns -1 to say to the first one gets to the left
                                return 0; // 0 to stays the same
                        }
                })); // To change default way
                System.out.println(tempMeses);

                // Bro, use a class because reasons:
                Collections.sort(tempMeses, new InvertedDouble());
                System.out.println(tempMeses);

                // Bro... dont use a class... Use Lambda Functions... much cleaner
                Collections.sort(tempMeses, (o1, o2) -> o1.compareTo(o2));
                System.out.println(tempMeses);

                // Bro... Please... Get a copy of this list... yoy are getting that one messy!
                List<Double> testezimDouble = new ArrayList<>() {
                        {
                                addAll(tempMeses);
                        }
                };
                System.out.println(testezimDouble);
                testezimDouble.add(10000d);
                System.out.println(testezimDouble);
                System.out.println(tempMeses);

        }

        static class InvertedDouble implements Comparator<Double> {
                @Override
                public int compare(Double o1, Double o2) {
                        if (o1 < o2)
                                return 1; // returns 1 to say to first one gets to the right
                        if (o1 > o2)
                                return -1; // returns -1 to say to the first one gets to the left
                        return 0; // 0 to stays the same
                }
        }
}
