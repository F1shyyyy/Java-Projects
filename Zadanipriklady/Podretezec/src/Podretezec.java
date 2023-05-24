import java.util.Arrays;
import java.util.Scanner;

public class Podretezec {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        String zadanyText = zadaniTextu();
        String hledanyPodretezec = zadaniPodretezce();
        int pocetVyskytu = hledaniVyskytu(zadanyText, hledanyPodretezec);
        System.out.printf("\nZadany text je: %s\n", zadanyText);
        System.out.printf("Hledany podretezec je: %s\n", hledanyPodretezec);
        System.out.printf("Pocet vyskytu: %d\n", pocetVyskytu);
    }
    private static int hledaniVyskytu(String zadanyText, String hledanyPodretezec) {
        char[] textZnaky = new char[0];
        
        for (int i = 0; i < zadanyText.length(); i++) {
            textZnaky = Arrays.copyOf(textZnaky, textZnaky.length + 1);
            textZnaky[i] = Character.toLowerCase(zadanyText.charAt(i));
        }
        System.out.println(Arrays.toString(textZnaky));
        char[] podretezecZnaky = new char[0];
        for (int i = 0; i < hledanyPodretezec.length(); i++) {
            podretezecZnaky = Arrays.copyOf(podretezecZnaky, podretezecZnaky.length + 1);
            podretezecZnaky[i] = Character.toLowerCase(hledanyPodretezec.charAt(i));

        }
        System.out.println(Arrays.toString(podretezecZnaky));
        int vyskyt = 0;
        int vyskytZnaku = 0;
        for (int i = 0; i < textZnaky.length; i++) {
            if (podretezecZnaky[0] == textZnaky[i]) {
                vyskytZnaku = 0;
                for (char hledanyZnak : podretezecZnaky) {
                    if (hledanyZnak != textZnaky[i]) {
                        break;
                    } else{
                        i++;
                        vyskytZnaku++;
                    }
                }
                if (vyskytZnaku == podretezecZnaky.length) {
                    vyskyt++;
                }

            }            
        }

        // for (int i = 0; i < textZnaky.length; i++) {
        //     if (podretezecZnaky[0] == textZnaky[i]) {
        //         if (podretezecZnaky.length > 1 && i < textZnaky.length - 1) {
        //             for (int j = 1; j < podretezecZnaky.length; j++) {
        //                 if (podretezecZnaky[j] == textZnaky[i + 1]) {
        //                     i++;
        //                 }
        //             }
        //             vyskyt++;           
        //         } else if (podretezecZnaky.length == 1) {
        //             vyskyt++;
        //         }
        //     }
        // }
        return vyskyt;
    }
    private static String zadaniPodretezce() {
        System.out.print("Zadej hledany podretezec: ");
        String podretezec = sc.nextLine();
        sc.nextLine();
        return podretezec;
    }
    private static String zadaniTextu() {
        System.out.print("Zadej libovolny text: ");
        String zadani = sc.nextLine();
        sc.nextLine();
        return zadani;
    }   
}
