package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Golden Master ===");

        Item[] items = {
                new Item("Normal", 10, 20),
                new Item("Normal", 1, 20),
                new Item("Normal", 0, 20),
                new Item("Normal", -1, 20),
                new Item("Comté", 2, 0),
                new Item("Pass VIP Concert", 15, 20),
                new Item("Pouvoirs magiques", 3, 6),
                new Item("Kryptonite", 5, 50)
        };

        MagasinMagique magasin = new MagasinMagique(Arrays.asList(items));

        for (int day = 0; day < 5; day++) {
            System.out.println("-------- jour " + day + " --------");
            for (Item item : items) {
                System.out.println(item);
            }
            magasin.updateItems();
        }
    }
}
