import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    // Метод для добавления имени и номера телефона в телефонную книгу
    public void add(String name, String phoneNum) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNum);
        } else {
            ArrayList<String> phoneNums = new ArrayList<>();
            phoneNums.add(phoneNum);
            phoneBook.put(name, phoneNums);
        }
    }

    // Метод для вывода телефонной книги, отсортированной по убыванию числа телефонов
    public void showSortedPhoneBook() {
        List<Map.Entry<String, ArrayList<String>>> sortedEntries = phoneBook.entrySet()
                .stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()))
                .collect(Collectors.toList());

        for (Map.Entry<String, ArrayList<String>> entry : sortedEntries) {
            System.out.println(entry.getKey() + " - " + entry.getValue().size() + " телефонов: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Анна", "+7911123456");
        phoneBook.add("Анна", "+7911789012");
        phoneBook.add("Борис", "+7911789012");
        phoneBook.add("Катя", "+7911345678");
        phoneBook.add("Катя", "+7911987654");
        phoneBook.add("Катя", "+7911123123");

        System.out.println("Телефонная книга, отсортированная по убыванию числа телефонов:");
        phoneBook.showSortedPhoneBook();
    }
}
