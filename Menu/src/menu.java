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
                    String[] algoritmy = { "Bubble Sort", "Insertion Sort", "Selection Sort", "Merge Sort" };
                    switch (vyberVolby(algoritmy)) {
                        case 1:
                            bubbleSort();
                            vypisPole(cisla);
                            break;
                        case 2:
                            insertionSort();
                            vypisPole(cisla);
                            break;
                        case 3:
                            selectionSort();
                            vypisPole(cisla);
                            break;
                        case 4:
                            vypisPole(mergeSort(cisla));
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

    static int[] mergeSort(int[] pole) {
        if (pole.length <= 1) {
            return pole; // Stop vetev
        }
        // Rekurzni vetev
        int stred = pole.length / 2;
        int[] levaStrana = Arrays.copyOfRange(pole, 0, stred),
                pravaStrana = Arrays.copyOfRange(pole, stred, pole.length);

        levaStrana = mergeSort(levaStrana);
        pravaStrana = mergeSort(pravaStrana);

        return merge(levaStrana, pravaStrana);
    }

    static int[] merge(int[] levaStrana, int[] pravaStrana) {
        int[] vysledne = new int[levaStrana.length + pravaStrana.length];

        for (int indexVysledne = 0, indexLeve = 0, indexPrave = 0; indexVysledne < vysledne.length; indexVysledne++) {
            if (indexPrave >= pravaStrana.length
                    || indexLeve < levaStrana.length && levaStrana[indexLeve] < pravaStrana[indexPrave]) {
                vysledne[indexVysledne] = levaStrana[indexLeve++];
            } else {
                vysledne[indexVysledne] = pravaStrana[indexPrave++];
            }
        }
        return vysledne;
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

    static int ziskatCislo(String zprava) {
        System.out.print(zprava);
        int cislo = sc.nextInt();
        sc.nextLine();
        return cislo;
    }

    static void vypisPole(int[] cisla) {
        System.out.println(Arrays.toString(cisla));
        System.out.println();
    }
}
