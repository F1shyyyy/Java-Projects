import java.util.Arrays;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    static int[] cisla = new int[0];

    public static void main(String[] args) throws Exception {
        String[] menu = { "Pridat cislo", "Najit nejmensi hodnotu", "Seradit cisla" };

        int volba;
        while (0 != (volba = vyberVolby(menu))) {
            switch (volba) {
                case 1:
                    pridatCislo();
                    break;
                case 2:
                    najitNejmensiHodnotu();
                    break;
                case 3:
                    String[] algoritmy = {"Bubble Sort", "Insertion Sort", "Selection Sort", "Merge Sort"};
                    switch (vyberVolby(algoritmy)) {
                        case 1:
                            bubbleSort();
                            break;
                        case 2:
                            insertionSort();
                            break;
                        case 3:
                            selectionSort();
                            break;
                        case 4:
                            mergeSort();
                            break;
                        default:
                            System.out.println("Nebyl vybrán správný algoritmus.");
                            break;
                    }
                    break;
                default:
                    System.out.println("K této volbě není žádná akce.");
                    break;
            }
        }
    }

    static void mergeSort() {

    }

    static void selectionSort() {

    }

    static void insertionSort() {
        for (int i = 0; i < cisla.length - 2; i++) {
            int j = i + 1;
            int temp = cisla[j];
            while (j > 0 && temp > cisla[j - 1]) {
                cisla[j] = cisla[j - 1];
                j--;
            }
            cisla[j] = temp;
        }
    }

    static void bubbleSort() {
        for (int i = 0; i < cisla.length - 1; i++) {
            for (int j = 0; j < cisla.length - i - 1; j++) {
                if (cisla[j] > cisla[j + 1]) {
                    int temp = cisla[j];
                    cisla[j] = cisla[j + 1];
                    cisla[j + 1] = temp;
                }
            }
        }
    }

    static void najitNejmensiHodnotu() {
        if (cisla.length > 0) {
            int minimum = cisla[0];
            for (int i : cisla) {
                if (i < minimum) {
                    minimum = i;
                }
            }  
        }
    }

    static void pridatCislo() {
        cisla = Arrays.copyOf(cisla, cisla.length + 1);
        cisla[cisla.length - 1] = ziskatCislo("Zadej cislo: ");
    }

    static void vypisMenu(String[] polozky) {
        int cislo = 1;
        for (String polozka : polozky) {
            System.out.printf("%d. %s\n", cislo++, polozka);
        }
        System.out.printf("%d. %s\n", 0, "Konec");

    }

    static int vyberVolby(String[] menu) {
        int volba;
        do {
            vypisMenu(menu);
            volba = ziskatCislo("Zadej volbu: ");
            sc.nextLine();
            if (volba > 0 && volba <= menu.length) {
                return volba;
            }
            System.out.println("Neplatna hodnota, zadej znovu: ");
        } while (true);
    }
    
    static int ziskatCislo(String zprava){
        System.out.print(zprava);
        int cislo = sc.nextInt(); sc.nextLine();
        return cislo;
    }
}
