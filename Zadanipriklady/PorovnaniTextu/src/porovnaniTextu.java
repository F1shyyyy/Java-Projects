import java.util.Arrays;

public class porovnaniTextu {
    public static void main(String[] args) throws Exception {
        String scifiText = "Dej mi darek budem bratri pripadne sourozenci vzdyt to dobre znas budem k sobe navzdy patrit na chvili neumru a mozna naporad. Zlej vitr nezacne vat my prani nerozmeta Dej mi darek budem bratri pripadne sourozenci vzdyt to dobre znas mam chut jeste nekdy spatrit uplne vsedni veci ty mi je muzes dat. Zlej vitr nezacne vat my prani nerozmeta. Tahleta nabidka je sci-fi povidka ktera ma sanci ze se muze stat tahleta nabidka zazracna vyhybka a moje telo zas bude muj hrad.Tahleta nabidka je sci-fi povidka ktera ma sanci ze se muze stat tahleta nabidka zazracna vyhybka pojedu domu a nebude tma.";
        String aiText = "Byla jednou mala vesnicka uprostred lesu. Jeji obyvatele byli znami svou laskou k prirode a magii. Mezi nimi zila mala divka jmenem Alice. Jednoho dne objevila v housti lesa ztraceny kouzelny kamen. Jakmile ho vzala do ruky, dostala schopnost mluvit se zviraty. Alice se rozhodla vyuzit svuj dar k dobrym ucelum. Pomahala zviratkum v lese, poslouchala jejich starosti a radila jim. Rychle se stala znamou po celem kraji. Lide zacali verit v jeji schopnosti a chodili za ni s prosbami o pomoc. Alice se stala hrdinkou vesnicky a rozsirila povest o lasce k prirode mezi jejimi spoluobcany. Vsichni se zacali starat o les a zvirata s ohledem na jejich potreby.";
        char[] znakyChar = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r','s', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ', '.', ',', '-' };
        char[] scifiTextZnaky = scifiTextZnaky(scifiText);
        char[] aiTextZnaky = aiTextZnaky(aiText);
        int[] cetnostZnakuScifi = cetnostZnaku(znakyChar, scifiTextZnaky);
        int[] cetnostZnakuAI = cetnostZnaku(znakyChar, aiTextZnaky);

        cetnost(znakyChar, cetnostZnakuScifi, cetnostZnakuAI);


    }

    private static void cetnost(char[] znakyChar, int[] cetnostZnakuAI, int[] cetnostZnakuScifi) {
        int i = 0;
        int j = 0;
        for (int znak : znakyChar) {
            if (znak == ' ') {
                System.out.printf("Cetnost mezer v Scifi textu: %d\n", cetnostZnakuScifi[i++]);
                System.out.printf("Cetnost mezer v Scifi textu: %d\n", cetnostZnakuAI[j++]);
            } else {
                System.out.printf("Cetnost %c v Scifi textu: %d\n", znak, cetnostZnakuScifi[i++]);
                System.out.printf("Cetnost %c v AI textu: %d\n", znak, cetnostZnakuAI[j++]);
            }

        }
    }

    private static char[] aiTextZnaky(String aiText) {
        char[] pole = new char[0];
        for (int i = 0; i < aiText.length(); i++) {
            pole = Arrays.copyOf(pole, pole.length + 1);
            pole[i] = Character.toLowerCase(aiText.charAt(i));
        }
        return pole;
    }

    private static char[] scifiTextZnaky(String scifiText) {
        char[] pole = new char[0];
        for (int i = 0; i < scifiText.length(); i++) {
            pole = Arrays.copyOf(pole, pole.length + 1);
            pole[i] = Character.toLowerCase(scifiText.charAt(i));
        }
        return pole;
    }

    private static int[] cetnostZnaku(char[] znakyChar, char[] textZnaky) {
        
        int[] cetnostZnaku = new int[znakyChar.length];
        for (int i = 0; i < textZnaky.length; i++) {
            for (int j = 0; j < znakyChar.length; j++) {
                if (textZnaky[i] == znakyChar[j]) {
                    cetnostZnaku[j]++;
                    break;
                }
            }
        }
        return cetnostZnaku;
    }
}
