package io.sanchopansa.lesson10;

import java.util.*;

public class HomeworkClass {
    public static void main(String[] args) {
        task01();
        task02();
    }

    public static void task01() {
        String[] wordArray = {
                "Москва",
                "Санкт-Петербург",
                "Волгоград",
                "Самара",
                "Казань",
                "Москва",
                "Казань",
                "Новосибирск",
                "Краснодар",
                "Кемерово",
                "Хабаровск",
                "Новосибирск",
                "Самара",
                "Магадан",
                "Владивосток",
                "Пятигорск",
                "Мурманск",
                "Казань",
                "Кранодар",
                "Пятигорск"
        };
        System.out.println("Task 1");

        List<String> nameList = new ArrayList<>(Arrays.asList(wordArray));
        // nameList.stream().distinct().forEach(System.out::println);
        Set<String> nameSet = new HashSet<>(nameList);
        for(String x: nameSet)
            System.out.println(x);
        System.out.println("\nArrayList: " + nameList.size());
        System.out.println("Set: " + nameSet.size());

        // Подсчитать, сколько раз встречается каждое слово
        HashMap<String, Integer> nameMap = new HashMap<>();
        for(String x: nameSet) {
            nameMap.put(x, countRepeats(nameList, x));
            System.out.printf("%s : %d\n", x, nameMap.get(x));
        }
    }

    private static int countRepeats(List<String> list, String value) {
        if(!list.contains(value))
            return 0;
        int counter = 0;
        for(String x: list) {
            if(x.equals(value))
                counter++;
        }
        return counter;
    }

    public static void task02() {
        System.out.println("\nTask 2");
        Phonebook<String, String> phonebook = new Phonebook<>();
        phonebook.add("1001", "Иванов");
        phonebook.add("1002", "Петров");
        phonebook.add("1003", "Иванов");
        phonebook.add("1004", "Кузнецов");

        System.out.println("Петров:");
        phonebook.get("Петров");
        System.out.println("\nИванов:");
        phonebook.get("Иванов");
    }
}
