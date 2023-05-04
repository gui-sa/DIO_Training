package edu.exercise.methoods;

public class Calculadora {
        /**
         * Soma dois valores
         * 
         * @param i1 : double
         * @param i2 : double
         * @return double type
         */
        public static double soma(double i1, double i2) {

                return (i1 + i2);
        }

        /**
         * Multiplica dois valores
         * 
         * @param i1 : double
         * @param i2 : double
         * @return double type
         */
        public static double multiplica(double i1, double i2) {
                return (i1 * i2);
        }

        /**
         * Subtrai i2 de i1 dois valores
         * 
         * @param i1 : double
         * @param i2 : double
         * @return double type
         */
        public static double subtrai(double i1, double i2) {
                return (i1 - i2);
        }

        /**
         * Divide o numerador pelo denominador
         * 
         * @param numerador   : double
         * @param denominador : double
         * @return double type
         */
        public static double divide(double numerador, double denominador) {
                return (numerador / denominador);
        }

        public static double divide(int num, double den) {
                return (num / den);
        }

        public static int divide(double num, double den) {
                return (int) (num / den);
        }

}
