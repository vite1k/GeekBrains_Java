import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class NamePopularity {
    private final String name;
    private final Integer count;

    public NamePopularity(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public String toString() {
        return name + ": " + count;
    }
}

public class NameRepetitions {
    public static void main(String[] args) {
        String[] employees = {
                "Иван Иванов",
                "Светлана Петрова",
                "Кристина Белова",
                "Анна Мусина",
                "Анна Крутова",
                "Иван Юрин",
                "Петр Лыков",
                "Павел Чернов",
                "Петр Чернышов",
                "Мария Федорова",
                "Марина Светлова",
                "Мария Савина",
                "Мария Рыкова",
                "Марина Лугова",
                "Анна Владимирова",
                "Иван Мечников",
                "Петр Петин",
                "Иван Ежов"
        };

        Map<String, Integer> nameFrequency = new HashMap<>();
        for (String employee : employees) {
            String name = employee.split(" ")[0];
            nameFrequency.put(name, nameFrequency.getOrDefault(name, 0) + 1);
        }

        Comparator<NamePopularity> comparator = (np1, np2) -> {
            int result = Integer.compare(np2.getCount(), np1.getCount());
            if (result == 0) {
                result = np1.getName().compareTo(np2.getName());
            }
            return result;
        };

        TreeMap<NamePopularity, String> sortedNameFrequency = new TreeMap<>(Comparator.comparing(NamePopularity::getCount, Comparator.reverseOrder()).thenComparing(NamePopularity::getName));
        for (Map.Entry<String, Integer> entry : nameFrequency.entrySet()) {
            sortedNameFrequency.put(new NamePopularity(entry.getKey(), entry.getValue()), entry.getKey());
        }

        for (NamePopularity namePopularity : sortedNameFrequency.keySet()) {
            System.out.println(namePopularity);
        }
    }
}
