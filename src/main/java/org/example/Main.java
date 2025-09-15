package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Golden Master ===");

        // Création des items
        MagasinMagique.Item[] items = {
                new MagasinMagique.Item("Normal", 10, 20),
                new MagasinMagique.Item("Normal", 1, 20),
                new MagasinMagique.Item("Normal", 0, 20),
                new MagasinMagique.Item("Normal", -1, 20),
                new MagasinMagique.Item("Comté", 2, 0),
                new MagasinMagique.Item("Pass VIP Concert", 15, 20),
                new MagasinMagique.Item("Pouvoirs magiques", 3, 6),
                new MagasinMagique.Item("Kryptonite", 0, 80)
        };

        // Création du magasin
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(items));

        // Simulation sur 5 jours
        for (int day = 0; day < 5; day++) {
            System.out.println("-------- jour " + day + " --------");
            for (MagasinMagique.Item item : items) {
                System.out.println(item);
            }

            // Mise à jour quotidienne de la qualité
            magasin.updateQuality();
        }
    }
}

