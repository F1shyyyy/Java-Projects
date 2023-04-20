import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int[] pole = new int[0];
        int hodnota;
        float soucet = 0;
        int maximum = 0;
        Scanner hodnotascan = new Scanner(System.in);
        do {
            System.out.print("Zadej hodnotu: ");
            hodnota = hodnotascan.nextInt();
            if (hodnota == 0) {
                break;                
            }
            if (hodnota > 0) {
                pole = Arrays.copyOf(pole, pole.length + 1);
                pole[pole.length - 1] = hodnota;
                System.out.println(Arrays.toString(pole));
            }
        } while (true);
        hodnotascan.close();
        int minimum = pole[0];
        for (int number : pole){
            soucet += number;
            if (number > maximum) {
                maximum = number;
            }
            if (number < minimum) {
                minimum = number;
            }
        }
        float prumer = (soucet / pole.length);
        System.out.println("Maximalni cislo je: " + maximum);
        System.out.println("Minimalni cislo je: " + minimum);
        System.out.println("Prumer cisel je: " + prumer);
    }
}
