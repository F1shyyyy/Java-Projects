import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class datum {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        LocalDate datumNarozeni = LocalDate.of(2007, 4, 11);
        String zadaneDatum = zadaniData();
        String[] datum = zadaneDatum.split("[. ]+",0 );
        LocalDate datumZadany = LocalDate.of(datum[2], datum[1], datum[0]);
        
        System.out.println(Arrays.toString(datum));


    }
    private static String zadaniData() {
        System.out.print("Zadej datum (den, mesic, rok): ");
        String datum = sc.nextLine();
        sc.nextLine();
        return datum;
    }
}