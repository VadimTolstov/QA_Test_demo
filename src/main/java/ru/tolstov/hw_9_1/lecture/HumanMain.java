package ru.tolstov.hw_9_1.lecture;

import java.util.*;

import static java.util.Arrays.asList;

public class HumanMain {

    public static void main(String[] args) {
        String[] hobbies = new String[3];
        hobbies[0] = "Футбол";
        hobbies[1] = "Java";
        hobbies[2] = "Гражданская Оборона";

        String[] hobbiesAnother = new String[] {
                "Футбол", "Java", "Гражданская Оборона"
        };

        int[][][] intArray = new int[][][] {
                new int[][] {
                        new int[] {1, 2, 3}
                },
                new int[][] {
                        new int[] {1, 2, 3}
                }
        };

        int length = hobbiesAnother.length;

        List<String> hobbiesList = new ArrayList<>();
        hobbiesList.add("Футбол");
        hobbiesList.add("Java");
        hobbiesList.add("Гражданская Оборона");

        List<String> hobbiesListAnother = List.of(
                "Футбол", "Java", "Гражданская Оборона"
        );

        Human dima = new Human("Дима", 33, hobbies);
        Human dima1 = new Human("Дима", 33, hobbies);

        Set<Human> hobbiesSet = new HashSet<>();
        hobbiesSet.add(dima);
        hobbiesSet.add(dima1);

        Set<String> hobbiesSetAnother = Set.of(
                "Футбол", "Java", "Гражданская Оборона"
        );

        Map<String, Human> humans = new HashMap<>();
        humans.put("1234545", dima);
        humans.put("1224455", dima1);

        for (int i = 0; i < hobbies.length; i++) {
            System.out.println(hobbies[i]);
        }

        for (String hobby : hobbies) {
            System.out.println(hobby);
        }

        boolean arrayContainJava = true;
        int index = 0;
        while (!arrayContainJava && index < hobbies.length) {
            if (hobbies[index].equals("Java")) {
                arrayContainJava = true;
                return;
            }
            index++;
        }

        do {
            if (hobbies[index].equals("Java")) {
                arrayContainJava = true;
            }
            index++;
        } while (!arrayContainJava && index < hobbies.length);

    }
}
