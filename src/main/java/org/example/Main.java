package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Mon golden master");

        MagasinMagique.Item[] items = {
                new MagasinMagique.Item("Normal", 10, 20),
                new MagasinMagique.Item("Normal", 1, 20),
                new MagasinMagique.Item("Normal", 0, 20),
                new MagasinMagique.Item("Normal", -1, 20)
        };

        MagasinMagique magasin = new MagasinMagique(Arrays.asList(items));

        for (int day = 0; day < 5; day++) {
            System.out.println("-------- jour " + day + " --------");
            for (MagasinMagique.Item item : items) {
                System.out.println(item);
            }
            magasin.updateItems();
        }
    }
}
