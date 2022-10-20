import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        //Первая задача
        List<String> listWorld = new ArrayList<>(Arrays.asList("so","cd","ls","cd","enum","no","so"));

        System.out.println(listWorld);

        System.out.println(listWorld.stream()
                .map(s -> s)
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey());

        //Вторая задача
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Николай", 34, 100000));
        persons.add(new Person("Александр", 45, 50000));
        persons.add(new Person("Алексей", 18, 32000));
        persons.add(new Person("Андрей", 25, 75000));
        persons.add(new Person("Роман", 45, 155000));

        Double average = persons.stream().collect(Collectors.averagingInt(Person::getSalary));
        System.out.printf("Средняя зарплата сотрудников: %s \n", average);

        //третья задача
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Введите n первых сотрудников(не более 5)");
        int N = keyboard.nextInt();
        System.out.println(persons.stream().sorted(((o1, o2) -> o2.age - o1.age))
                .map((Function<Person, String>) person->person.name)
                .limit(N)
                .collect(Collectors.joining(" " ,  N+" самых старших сотрудников в компании: " ,  "." )));

    }
}
