import java.io.File;

/**
 * Created by Zlatimir Ivanov on 31.12.2020 г..
 */

public class GetFolderSize {
    public static void main(String[] args) {

        String path = "E:\\JAVA\\SOFTUNI\\SOFTUNI\\JavaAdvanced\\04.Streams, Files and Directories\\04. Java-Advanced-Streams-Files-and-Directories-Resources-Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File file = new File(path);
        File[] files = file.listFiles();
        long n = 0;
        for (File file1 : files) {
            if(!file1.isDirectory()){
                n += file1.length();
            }
        }

        System.out.println("Folder size: " + n);
    }
}
