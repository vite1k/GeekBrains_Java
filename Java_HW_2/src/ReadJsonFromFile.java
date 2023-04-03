import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadJsonFromFile {
    public static void main(String[] args) {
        try {
            File file = new File("Sorry.json");
            Scanner scanner = new Scanner(file);
            StringBuilder jsonString = new StringBuilder();
            while (scanner.hasNextLine()) {
                jsonString.append(scanner.nextLine());
            }
            scanner.close();
            System.out.println("JSON String: " + jsonString.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
