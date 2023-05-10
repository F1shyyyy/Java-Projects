import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    static Scanner calcscan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        try {
            double number1 = zadaniCisel();
            char operator = zadaniOperatoru();
            double number2 = zadaniCisel();
            System.out.println("Vysledek je: " + vypocetVysledku(number1, number2, operator));
        } catch (InputMismatchException e) {
            System.out.println("Chyba zadani.");
        }
        calcscan.close();
    }

    static double scitaciOperator(double number1, double number2) {
        double vysledek = number1 + number2;
        return vysledek;
    }

    static double odcitaciOperator(double number1, double number2) {
        double vysledek = number1 - number2;
        return vysledek;
    }

    static double nasobiciOperator(double number1, double number2) {
        double vysledek = number1 * number2;
        return vysledek;
    }

    static double deliciOperator(double number1, double number2) {
        double vysledek = number1 / number2;
        return vysledek;
    }

    static double mocniciOperator(double number1, double number2) {
        double vysledek = Math.pow(number1, number2);
        return vysledek;
    }

    static double vypocetVysledku(double number1, double number2, char operator) {
        double vysledek = 0;
        switch (operator) {
            case '+':
                vysledek = scitaciOperator(number1, number2);
                break;
            case '-':
                vysledek = odcitaciOperator(number1, number2);
                break;
            case '*':
                vysledek = nasobiciOperator(number1, number2);
                break;
            case '/':
                vysledek = deliciOperator(number1, number2);
                break;
            case '^':
                vysledek = mocniciOperator(number1, number2);
                break;
            default:
                System.out.println("Chybny operator.");
                break;
        }
        return vysledek;
    }

    static double zadaniCisel() {
        System.out.print("Operand: ");
        double number = calcscan.nextDouble();
        return number;
    }

    static char zadaniOperatoru() {
        System.out.print("Operator: ");
        char operator = calcscan.next().charAt(0);
        return operator;
    }

}
