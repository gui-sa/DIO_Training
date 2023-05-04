public class Basico {
        /**
         * Exercicio para testar Java Doc e Methods
         * 
         * @author Guilherme Salomao Agostini
         * 
         *         Simples para testar metodos
         */
        public static void main(String[] args) {

                double i1 = 10, i2 = 100;
                System.out.println(soma(i1, i2));
                System.out.println(subtrai(i1, i2));
                System.out.println(multiplica(i1, i2));
                System.out.println(divide(i1, i2));

        }

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
}