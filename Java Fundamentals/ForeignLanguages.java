import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 24.5.2020 г..
 */
public class ForeignLanguages {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String country = sc.nextLine();
        String language = "unknown";
        if (country.equals("England")||country.equals("USA")){
            language = "English";
        } else if (country.equals("Spain")||country.equals("Argentina")||country.equals("Mexico")){
            language = "Spanish";
        }
        System.out.println(language);
    }
}
