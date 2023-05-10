public class App {
    public static void main(String[] args) throws Exception {
        int[] pole= {9, 1, 2, 14, 12, 0, 3, 1};
        int maximum = 0, minimum = 0;
        float soucet = 0;
        for (int number : pole) {
            if (number > maximum) {
                maximum = number;
            }
            if (number < minimum) {
                minimum = number;
            }
            soucet += number;
        }
        float prumer = soucet / pole.length;
        System.out.println("The maximum is: " + maximum);
        System.out.println("The minimum is: " + minimum);
        System.out.println("The average number is: " + prumer);

    }
}
