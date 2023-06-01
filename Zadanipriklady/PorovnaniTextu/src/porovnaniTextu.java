import java.util.Arrays;

public class porovnaniTextu {
    public static void main(String[] args){
        String scifiText = "Dej mi darek budem bratri pripadne sourozenci vzdyt to dobre znas budem k sobe navzdy patrit na chvili neumru a mozna naporad. Zlej vitr nezacne vat my prani nerozmeta Dej mi darek budem bratri pripadne sourozenci vzdyt to dobre znas mam chut jeste nekdy spatrit uplne vsedni veci ty mi je muzes dat. Zlej vitr nezacne vat my prani nerozmeta. Tahleta nabidka je sci-fi povidka ktera ma sanci ze se muze stat tahleta nabidka zazracna vyhybka a moje telo zas bude muj hrad. Tahleta nabidka je sci-fi povidka ktera ma sanci ze se muze stat tahleta nabidka zazracna vyhybka pojedu domu a nebude tma.";
        String aiText = "Byla jednou mala vesnicka uprostred lesu. Jeji obyvatele byli znami svou laskou k prirode a magii. Mezi nimi zila mala divka jmenem Alice. Jednoho dne objevila v housti lesa ztraceny kouzelny kamen. Jakmile ho vzala do ruky, dostala schopnost mluvit se zviraty. Alice se rozhodla vyuzit svuj dar k dobrym ucelum. Pomahala zviratkum v lese, poslouchala jejich starosti a radila jim. Rychle se stala znamou po celem kraji. Lide zacali verit v jeji schopnosti a chodili za ni s prosbami o pomoc. Alice se stala hrdinkou vesnicky a rozsirila povest o lasce k prirode mezi jejimi spoluobcany. Vsichni se zacali starat o les a zvirata s ohledem na jejich potreby.";
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
