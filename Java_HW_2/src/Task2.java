public class Task2 {
    public static void main(String[] args) {
        String jsonString = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
                "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        parseAndPrintJson(jsonString);
    }

    public static void parseAndPrintJson(String jsonString) {
        StringBuilder result = new StringBuilder();
        jsonString = jsonString.substring(1, jsonString.length() - 1);
        String[] objects = jsonString.split("},");

        for (String object : objects) {
            object = object.replace("{", "").replace("}", "");
            String[] properties = object.split(",");

            String surname = properties[0].split(":")[1].replace("\"", "");
            String grade = properties[1].split(":")[1].replace("\"", "");
            String subject = properties[2].split(":")[1].replace("\"", "");

            result.append("Студент ").append(surname).append(" получил ").append(grade).append(" по предмету ").append(subject).append(".\n");
        }

        System.out.println(result);
    }
}
