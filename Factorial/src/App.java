public class App {
    public static void main(String[] args) throws Exception {

        factorial(5);

        System.out.println("Hello, World!");
        for (int i = 0; i <= 20; i++) {
            System.out.printf("%3d %20d %20d\n", i, factorial(i), factorialBezRekurze(i));
            
        }
    }
    static long factorialBezRekurze(int n){
        long vysledek = 1;
        for (int i = n; i > 0; i--) {
            vysledek *= i;
        }
        return vysledek;
    }
    static long factorial(int n) {
        if (n > 0) {
            return n * factorial(n - 1); // rekurzni vetev
        } else {
            return 1; // stop vetev
        }
    }
}
