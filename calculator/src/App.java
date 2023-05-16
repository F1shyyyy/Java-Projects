import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    static Scanner calcscan = new Scanner(System.in);
    static double[] numbers = new double[0];

    public static void main(String[] args) throws Exception {
        String[] menu = { "Zadat cislo", "Zadat operator", "Vypocitat", "Vycistit pole" };
        int volba;
        char operator = '"';
        while (0 != (volba = vyberVolby(menu))) {
            switch (volba) {
                case 1:
                    zadaniCisla();
                    break;
                case 2:
                    operator = zadaniOperatoru();
                    break;
                case 3:
                    vypocetVysledku(operator);
                    break;
                case 4:
                    vycistitPole();
                    break;
                default:
                    System.out.println("K teto volbe neni zadna akce.");
                    break;
            }
        }

        calcscan.close();
    }

    static void vycistitPole() {
        numbers = Arrays.copyOf(numbers, 0);
        System.out.println("Pole vycisteno.");
    }

    static void scitaciOperator() {
        int i = 0;
        numbers[i] = numbers[i] + numbers[i + 1];
        numbers = Arrays.copyOf(numbers, numbers.length - 1);
        System.out.println("Vysledek: " + numbers[i]);
    }

    static void odcitaciOperator() {
        int i = 0;
        numbers[i] = numbers[i] - numbers[i + 1];
        numbers = Arrays.copyOf(numbers, numbers.length - 1);
        System.out.println("Vysledek: " + numbers[i]);
    }

    static void nasobiciOperator() {
        int i = 0;
        numbers[i] = numbers[i] * numbers[i + 1];
        numbers = Arrays.copyOf(numbers, numbers.length - 1);
        System.out.println("Vysledek: " + numbers[i]);
    }

    static void deliciOperator() {
        int i = 0;
        numbers[i] = numbers[i] / numbers[i + 1];
        numbers = Arrays.copyOf(numbers, numbers.length - 1);
        System.out.println("Vysledek: " + numbers[i]);
    }

    static void mocniciOperator() {
        int i = 0;
        numbers[i] = Math.pow(numbers[i], numbers[i + 1]);
        numbers = Arrays.copyOf(numbers, numbers.length - 1);
        System.out.println("Vysledek: " + numbers[i]);
    }

    static void vypocetVysledku(char operator) {
        if (numbers.length > 1) {
            switch (operator) {
                case '+':
                    scitaciOperator();
                    break;
                case '-':
                    odcitaciOperator();
                    break;
                case '*':
                    nasobiciOperator();
                    break;
                case '/':
                    deliciOperator();
                    break;
                case '^':
                    mocniciOperator();
                    break;
                default:
                    System.out.println("Nejdrive zadej operator.");
                    break;
            }
        } else{
            System.out.println("Zadej vice cisel.");
        }

    }

    static void zadaniCisla() {
        numbers = Arrays.copyOf(numbers, numbers.length + 1);
        numbers[numbers.length - 1] = ziskatCislo("Zadej cislo: ");
    }

    static char zadaniOperatoru() {
        do {
            System.out.print("Zadej operator: ");
            char operator = calcscan.next().charAt(0);
            if (operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '^') {
                return operator;
            } else {
                System.out.println("Chybny operator, zadej znovu.\n");
            }
        } while (true);
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
            System.out.println("\n" + Arrays.toString(numbers) + "\n");
            vypisMenu(menu);
            volba = ziskatCislo("Zadej volbu: ");
            calcscan.nextLine();
            if (volba < 0 || volba > menu.length) {

            }
            if (volba >= 0 && volba <= menu.length) {
                return volba;
            }
            System.out.println("Neplatna volba, zadej znovu.\n");
        } while (true);
    }

    static int ziskatCislo(String zprava) {
        int cislo = 0;
        boolean error = false;
        do {
            System.out.print(zprava);
            try {
                cislo = calcscan.nextInt();
                calcscan.nextLine();
                error = false;
            } catch (InputMismatchException e) {
                calcscan.nextLine();
                System.out.println("\nZadavej jenom cisla!\n");
                error = true;
            }
        } while (error == true);
        return cislo;
    }
}
