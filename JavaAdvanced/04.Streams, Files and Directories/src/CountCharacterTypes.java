import java.io.*;

/**
 * Created by Zlatimir Ivanov on 31.12.2020 г..
 */

public class CountCharacterTypes {
    public static void main(String[] args) {

        String path = "E:\\JAVA\\SOFTUNI\\SOFTUNI\\JavaAdvanced\\04.Streams, Files and Directories\\src\\input.txt";

        int countVowels = 0;
        int countPunctuation = 0;
        int countConsonants = 0;
        String vowels = "aeiou";
        String punctuation = "!?,.";
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            PrintWriter writer = new PrintWriter("output.txt");

            while (in.ready()) {
                String line = in.readLine();
                for (int i = 0; i < line.length(); i++) {
                    if (vowels.contains(String.valueOf(line.charAt(i)))) {
                        countVowels++;
                    } else if (punctuation.contains(String.valueOf(line.charAt(i)))) {
                        countPunctuation++;
                    } else if (line.charAt(i) != ' '){
                        countConsonants++;
                    }

                }
            }

            writer.println("Vowels: " + countVowels);
            writer.println("Consonants: " + countConsonants);
            writer.println("Punctuation: " + countPunctuation);

            writer.flush();
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
