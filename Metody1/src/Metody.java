public class Metody{
    public static void main(String[] args) throws Exception {
        // int[] cisla = { 5, 1, 5, 2, 78, 3, 2, 1, 6, 3, 6, 9, 0, 1, 2, 4, 7, 9 };
        int[] rada = {12,4,3,34,5,23,2,1,4,2,-12,12,12,4,4,4,7,9,4,};

        int minimum = najitIndexMinima(rada);
        System.out.printf("Nejmensi cislo je na pozidic %d.", minimum);
    }

    static int najitIndexMinima(int[] cisla) {
        if (cisla == null || cisla.length == 0)
            return -1;

        int minIndex = 0;

        for (int i = 1; i < cisla.length; i++) {
            if (cisla[i] < cisla[minIndex]) {
                minIndex = i;
            }
        }

        return minIndex;
    }
}
