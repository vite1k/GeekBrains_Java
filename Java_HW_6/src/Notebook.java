import java.util.*;

public class Notebook {
    private String model;
    private int ram;
    private int storage;
    private String os;
    private String color;

    public Notebook(String model, int ram, int storage, String os, String color) {
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public static void main(String[] args) {
        Set<Notebook> notebooks = new HashSet<>(Arrays.asList(
                new Notebook("Lenovo", 8, 256, "Windows", "Black"),
                new Notebook("HP", 16, 512, "Windows", "Silver"),
                new Notebook("Apple", 8, 256, "MacOS", "Space Gray"),
                new Notebook("Dell", 16, 1024, "Windows", "Black")
        ));

        Map<String, Integer> filters = getFiltersFromUser();
        List<Notebook> filteredNotebooks = filterNotebooks(notebooks, filters);

        System.out.println("Список ноутбуков, соответствующих заданным критериям:");
        for (Notebook notebook : filteredNotebooks) {
            System.out.println(notebook.getModel() + ", " + notebook.getRam() + "GB RAM, " + notebook.getStorage() + "GB storage, " + notebook.getOs() + ", " + notebook.getColor());
        }
    }

    private static Map<String, Integer> getFiltersFromUser() {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> filters = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        System.out.println("Введите '0' для окончания ввода");

        while (true) {
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Введите минимальное количество ОЗУ (GB): ");
                    filters.put("ram", scanner.nextInt());
                    break;
                case 2:
                    System.out.print("Введите минимальный объем ЖД (GB): ");
                    filters.put("storage", scanner.nextInt());
                    break;
                case 3:
                    System.out.println("Выберите операционную систему:");
                    System.out.println("1 - Windows");
                    System.out.println("2 - MacOS");
                    System.out.println("3 - Linux");
                    int osChoice = scanner.nextInt();
                    switch (osChoice) {
                        case 1:
                            filters.put("os","Windows".hashCode());
                            break;
                        case 2:
                            filters.put("os", "MacOS".hashCode());
                            break;
                        case 3:
                            filters.put("os", "Linux".hashCode());
                            break;
                    }
                    break;
                case 4:
                    System.out.print("Введите желаемый цвет: ");
                    String color = scanner.next();
                    filters.put("color", color.toLowerCase().hashCode());
                    break;
                default:
                    System.out.println("Некорректный ввод, попробуйте снова.");
            }
        }

        return filters;
    }

    private static List<Notebook> filterNotebooks(Set<Notebook> notebooks, Map<String, Integer> filters) {
        List<Notebook> filteredNotebooks = new ArrayList<>();

        for (Notebook notebook : notebooks) {
            boolean matches = true;

            for (Map.Entry<String, Integer> filter : filters.entrySet()) {
                switch (filter.getKey()) {
                    case "ram":
                        if (notebook.getRam() < filter.getValue()) {
                            matches = false;
                        }
                        break;
                    case "storage":
                        if (notebook.getStorage() < filter.getValue()) {
                            matches = false;
                        }
                        break;
                    case "os":
                        if (notebook.getOs().hashCode() != filter.getValue()) {
                            matches = false;
                        }
                        break;
                    case "color":
                        if (notebook.getColor().toLowerCase().hashCode() != filter.getValue()) {
                            matches = false;
                        }
                        break;
                }

                if (!matches) {
                    break;
                }
            }

            if (matches) {
                filteredNotebooks.add(notebook);
            }
        }

        return filteredNotebooks;
    }
}

