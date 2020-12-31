import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Zlatimir Ivanov on 31.12.2020 г..
 */

public class WordCount {
    public static void main(String[] args) throws FileNotFoundException {

        String wordsPath = "E:\\JAVA\\SOFTUNI\\SOFTUNI\\JavaAdvanced\\04.Streams, Files and Directories\\04. Java-Advanced-Streams-Files-and-Directories-Resources-Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";

        String textPath = "E:\\JAVA\\SOFTUNI\\SOFTUNI\\JavaAdvanced\\04.Streams, Files and Directories\\04. Java-Advanced-Streams-Files-and-Directories-Resources-Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";

        FileInputStream wordsStream = new FileInputStream(wordsPath);
        FileInputStream textStream = new FileInputStream(textPath);

        Scanner scanWords = new Scanner(wordsStream);
        Scanner scanText = new Scanner(textStream);

        Map<String, Integer> wordsList = new HashMap<>();
        List<String> textList = new ArrayList<>();

        while (scanWords.hasNext()){
            wordsList.put(scanWords.next(), 0);
        }

        while (scanText.hasNext()){
            textList.add(scanText.next());
        }

        for (String str : textList) {
            for (Map.Entry<String, Integer> entry : wordsList.entrySet()) {
                if (entry.getKey().equals(str)){
                    wordsList.put(entry.getKey(), entry.getValue() + 1);
                }
            }
        }

        wordsList.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(s -> System.out.printf("%s - %d%n", s.getKey(), s.getValue()));
    }
}
