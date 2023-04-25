import java.util.Arrays;
import java.util.Scanner;

public class menu {
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
                            mergeSort(cisla);
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

    static void mergeSort(int[] cisla) {
        if (cisla.length > 1) {
            int stred = cisla.length / 2;
            int[] levaStrana = new int[stred];
            int[] pravaStrana = new int[cisla.length - stred];
            for (int i = 0; i < stred; i++) {
                levaStrana[i] = cisla[i];
            }
            for (int i = stred; i < cisla.length; i++) {
                pravaStrana[i - stred] = cisla[i];
            }
            mergeSort(levaStrana);
            mergeSort(pravaStrana);
            merge(cisla, levaStrana, pravaStrana);
            vypisPole();
        }
    }

    static void merge(int[] cisla, int[] levaStrana, int[] pravaStrana){
        int delkaLeva = levaStrana.length;
        int delkaPrava = pravaStrana.length;
        int i = 0, j = 0, k = 0;
        while (i < delkaLeva && j < delkaPrava) {
            if(levaStrana[i] <= pravaStrana[j]){
                cisla[k] = levaStrana[i];
                i++;
            }
            else{
                cisla[k] = pravaStrana[j];
                j++;
            }
            k++;
        }
        while (i < delkaLeva) {
            cisla[k] = levaStrana[i];
            i++;
            k++;
        }
        while (j < delkaPrava) {
            cisla[k] = pravaStrana[j];
            j++;
            k++;
        }
    }

    static void selectionSort() {
        for (int i = 0; i < cisla.length; i++) {
            int index = i;
            for (int j = i + 1; j < cisla.length; j++) {
                if (cisla[j] < cisla[index]) {
                    index = j;
                }
            }
            int mensiCislo = cisla[index];
            cisla[index] = cisla[i];
            cisla[i] = mensiCislo;
        }
        vypisPole();
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
        vypisPole();
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
        vypisPole();
    }

    static void najitNejmensiHodnotu() {
        if (cisla.length > 0) {
            int minimum = cisla[0];
            for (int i : cisla) {
                if (i < minimum) {
                    minimum = i;
                }
            }
            System.out.println("Nejmensi cislo je: " + minimum + "\n");
        }
    }

    static void pridatCislo() {
        cisla = Arrays.copyOf(cisla, cisla.length + 1);
        cisla[cisla.length - 1] = ziskatCislo("Zadej cislo: ");
        System.out.println(Arrays.toString(cisla));
        System.out.println();
    }

    static void vypisMenu(String[] polozky) {
        int cislo = 1;
        for (String polozka : polozky) {
            System.out.printf("%d. %s\n", cislo++, polozka);
        }
        System.out.printf("%d. %s\n", 0, "Konec \n");

    }

    static int vyberVolby(String[] menu) {
        int volba;
        do {
            vypisMenu(menu);
            volba = ziskatCislo("Zadej volbu: ");
            sc.nextLine();
            if (volba >= 0 && volba <= menu.length) {
                return volba;
            }
            System.out.println("Neplatna hodnota, zadej znovu: \n");
        } while (true);
    }
    
    static int ziskatCislo(String zprava){
        System.out.print(zprava);
        int cislo = sc.nextInt(); sc.nextLine();
        return cislo;
    }
    
    static void vypisPole(){
        System.out.println(Arrays.toString(cisla));
        System.out.println();
    }
}
