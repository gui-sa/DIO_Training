public class Ex1 {
        public static void main(String[] args) {
                String s1 = "1";
                String s2 = "1";
                String s3 = new String("1");

                int i1 = 1;
                double d1 = 1;
                double d2 = 1.67;

                System.out.println("Is d1== i1? " + (d1 == i1));
                System.out.println("Is d2 >= i1 " + (d2 >= i1));
                System.out.println("Is s1 == s2? " + (s1 == s2));
                System.out.println("Is s1 == s3? " + (s1 == s3));
                System.out.println("Is s1.equals(s2)? " + (s1.equals(s2)));

                if (true) {
                        int i2 = 3;
                        System.out.println("i2 inside block:  " + i2);

                }
                // System.out.println("i2 outside block: " + i2); // i2 out of scope

                // System.out.print(s1 == i1); //They are incompatiple
        }
}
