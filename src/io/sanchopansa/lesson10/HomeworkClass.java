package io.sanchopansa.lesson10;

import java.util.*;

public class HomeworkClass {
    public static void main(String[] args) {
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

    public static int countRepeats(List<String> list, String value) {
        if(!list.contains(value))
            return 0;
        int counter = 0;
        for(String x: list) {
            if(x.equals(value))
                counter++;
        }
        return counter;
    }
}
