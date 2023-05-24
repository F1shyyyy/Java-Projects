import java.time.LocalDate;

public class idk {
    public static void main(String[] args) throws Exception {
        String a = "sdaads";
        String b = "aaa";
        
        if (a.compareToIgnoreCase(b) < 0) {
            System.out.println(String.format("%s je driv nez %s", a, b));
        } else{
            System.out.println(String.format("%s je pozdeji nez %s", a, b));
        }
        System.out.println(a.compareTo(b));

        StringBuilder sb = new StringBuilder();
        

        LocalDate date = LocalDate.of(2023, 5, 17);
        date = date.plusDays(65000);
        System.out.println(LocalDate.of(2007, 4, 11).until(date).getYears());    
    
    }
}
