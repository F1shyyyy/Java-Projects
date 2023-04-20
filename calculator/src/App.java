import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner calcscan = new Scanner(System.in);
        System.out.print("1st Number: ");
        double number1 = calcscan.nextFloat();
        System.out.print("Operator: ");
        char operator = calcscan.next().charAt(0);
        System.out.print("2nd Number: ");
        double number2 = calcscan.nextFloat();
        double vysledek = 0;
        calcscan.close();
        switch (operator) {
            case '+':
                vysledek = number1 + number2;
                break;
            case '-':
                vysledek = number1 - number2;
                break;
            case '*':
                vysledek = number1 * number2;
                break;
            case '/':
                vysledek = number1 / number2;
                break;
            case '^':
                vysledek = Math.pow(number1, number2);
                break;
            default:
                System.out.println("Chybny operator.");
                break;
        }
        System.out.println("THe result is: " + vysledek);
    }
}
