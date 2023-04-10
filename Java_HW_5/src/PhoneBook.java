import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private final Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void addPhoneNumber(String name, String phoneNumber) {
        Set<String> phoneNumbers = phoneBook.get(name);
        if (phoneNumbers == null) {
            phoneNumbers = new HashSet<>();
            phoneBook.put(name, phoneNumbers);
        }
        phoneNumbers.add(phoneNumber);
    }

    public Set<String> getPhoneNumbers(String name) {
        Set<String> phoneNumbers = phoneBook.get(name);
        return (phoneNumbers == null) ? new HashSet<>() : new HashSet<>(phoneNumbers);
    }

    public boolean removePhoneNumber(String name, String phoneNumber) {
        Set<String> phoneNumbers = phoneBook.get(name);
        if (phoneNumbers != null) {
            return phoneNumbers.remove(phoneNumber);
        }
        return false;
    }

    public boolean removeEntry(String name) {
        return phoneBook.remove(name) != null;
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPhoneNumber("Алиса", "+123456789");
        phoneBook.addPhoneNumber("Алиса", "+987654321");
        phoneBook.addPhoneNumber("Макс", "+123456789");

        System.out.println("Алиса: " + phoneBook.getPhoneNumbers("Алиса"));
        System.out.println("Макс: " + phoneBook.getPhoneNumbers("Макс"));

        phoneBook.removePhoneNumber("Алиса", "+123456789");
        System.out.println("Алиса: " + phoneBook.getPhoneNumbers("Алиса"));
    }
}
