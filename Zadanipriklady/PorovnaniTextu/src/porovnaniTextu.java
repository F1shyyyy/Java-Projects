import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class porovnaniTextu {
    public static void main(String[] args) throws IOException{
        String scifiText = Files.readString(Path.of(".\\PorovnaniTextu\\src\\scifi.txt"));
        String aiText = Files.readString(Path.of(".\\PorovnaniTextu\\src\\ai.txt"));
        char[] znakyChar = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r','s', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ', '.', ',', '-' };
        String samohlasky = "aeiouy";
        String souhlasky = "hkrdtncjbflmpsvz";
        char[] textZnakyScifi = textZnaky(scifiText);
        char[] textZnakyAI = textZnaky(aiText);
        int[] znakyCetnost = cetnostZnaku(znakyChar, textZnakyScifi, textZnakyAI);

        cetnost(znakyChar, znakyCetnost);
        hlasky(samohlasky, souhlasky, textZnakyAI, textZnakyScifi);
        prumernaDelka(scifiText, aiText);

    }

    private static void prumernaDelka(String scifiText, String aiText) {
        String[] scifiSlova = scifiText.split(" ",0);
        String[] aiSlova = aiText.split(" ",0);
        double pocetPismen = 0;
        double pocetSlov = 0;
        double pocetVet = 0;
        for (String slovo: scifiSlova) {
            for (int i = 0; i < slovo.length(); i++) {
                if (!slovo.contains(".")){
                    pocetPismen++;
                } else{
                    break;
                }
            }
            pocetSlov++;
            if (slovo.contains(".")){
                pocetVet++;
            }
        }
        for (String slovo: aiSlova) {
            for (int i = 0; i < slovo.length(); i++) {
                if (!slovo.contains(".")){
                    pocetPismen++;
                } else{
                    break;
                }
            }
            pocetSlov++;
            if (slovo.contains(".")){
                pocetVet++;
            }
        }
        double prumerSlov = pocetPismen / scifiSlova.length;
        double prumerVet = pocetPismen / pocetVet;
        double prumerVetSlova = pocetSlov / pocetVet;
        System.out.printf("\nPrumerny pocet znaku ve slove je: %.2f\n", prumerSlov);
        System.out.printf("Prumerny pocet znaku ve vete je: %.2f\n", prumerVet);
        System.out.printf("\n Prumerny pocet slov ve vete je: %.2f\n", prumerVetSlova);

    }

    private static void hlasky(String samohlasky, String souhlasky, char[] textZnakyAI, char[] textZnakyScifi) {
        int pocetSamohlasek = 0;
        int pocetSouhlasek = 0;
        for (char znak: textZnakyAI) {
            if (samohlasky.contains(String.valueOf(znak))){
                pocetSamohlasek++;
            } else if (souhlasky.contains(String.valueOf(znak))) {
                pocetSouhlasek++;
            }
        }
        for (char znak: textZnakyScifi) {
            if (samohlasky.contains(String.valueOf(znak))){
                pocetSamohlasek++;
            } else if (souhlasky.contains(String.valueOf(znak))) {
                pocetSouhlasek++;
            }
        }
        System.out.printf("\nPomer samohlasek a souhlasek je: %d a %d\n", pocetSamohlasek, pocetSouhlasek);
    }

    private static void cetnost(char[] znakyChar, int[] cetnostZnaku) {
        int i = 0;
        for (int znak : znakyChar) {
            if (znak == ' ') {
                System.out.printf("Cetnost mezer v textech: %d\n", cetnostZnaku[i++]);
            } else {
                System.out.printf("Cetnost %c v textech: %d\n", znak, cetnostZnaku[i++]);
            }
        }
    }

    private static char[] textZnaky(String Text){
        char[] textZnaky = new char[0];
        for (int i = 0; i < Text.length(); i++) {
            textZnaky = Arrays.copyOf(textZnaky, textZnaky.length + 1);
            textZnaky[i] = Character.toLowerCase(Text.charAt(i));
        }
        return textZnaky;
    }
    private static int[] cetnostZnaku(char[] znakyChar, char[] textZnakyScifi, char[] textZnakyAI) {
        int[] cetnostZnaku = new int[znakyChar.length];
        for (char c : textZnakyScifi) {
            for (int i = 0; i < znakyChar.length; i++) {
                if (c == znakyChar[i]) {
                    cetnostZnaku[i]++;
                    break;
                }
            }
        }
        for (char c : textZnakyAI) {
            for (int i = 0; i < znakyChar.length; i++) {
                if (c == znakyChar[i]) {
                    cetnostZnaku[i]++;
                    break;
                }
            }
        }
        return cetnostZnaku;
    }


}
