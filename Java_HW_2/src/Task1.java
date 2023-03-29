import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task1 {
    public static void main(String[] args) {
        try {
            JSONArray jsonArray = new JSONArray("[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String surname = jsonObject.getString("фамилия");
                String grade = jsonObject.getString("оценка");
                String subject = jsonObject.getString("предмет");
                sb.append("Студент ").append(surname).append(" получил ").append(grade).append(" по предмету ").append(subject).append(".\n");
            }
            System.out.println(sb.toString());
            writeToFile(sb.toString());
        } catch (IOException e) {
            logException(e);
        }
    }

    private static void writeToFile(String result) throws IOException {
        FileWriter writer = null;
        try {
            writer = new FileWriter("result.txt");
            writer.write(result);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    private static void logException(Exception e) {
        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;

        try {
            fh = new FileHandler("log.txt");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            logger.log(Level.SEVERE, e.getMessage(), e);

        } catch (SecurityException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
