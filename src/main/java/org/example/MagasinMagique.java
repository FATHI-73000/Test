package org.example;

import java.util.List;

public class MagasinMagique {

    // Classe Item publique et statique pour être accessible depuis Main et tests
    public static class Item {
        public String name;
        public int sellIn;
        public int quality;

        public Item(String name, int sellIn, int quality) {
            this.name = name;
            this.sellIn = sellIn;
            this.quality = quality;
        }

        @Override
        public String toString() {
            return this.name + ", " + this.sellIn + ", " + this.quality;
        }
    }

    private final List<Item> items;

    public MagasinMagique(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Comté":
                    updateComte(item);
                    break;
                case "Kryptonite":
                    // légendaire : rien ne change
                    break;
                case "Pass VIP Concert":
                    updatePass(item);
                    break;
                case "Pouvoirs magiques":
                    updatePouvoirsMagiques(item);
                    break;
                default:
                    updateNormal(item);
            }
        }
    }

    private void updateNormal(Item item) {
        decreaseQuality(item, 1);
        item.sellIn--;
        if (item.sellIn < 0) decreaseQuality(item, 1);
    }

    private void updateComte(Item item) {
        increaseQuality(item, 1);
        item.sellIn--;
        if (item.sellIn < 0) increaseQuality(item, 1);
    }

    private void updatePass(Item item) {
        increaseQuality(item, 1);
        if (item.sellIn <= 10) increaseQuality(item, 1);
        if (item.sellIn <= 5) increaseQuality(item, 1);
        item.sellIn--;
        if (item.sellIn < 0) item.quality = 0;
    }

    private void updatePouvoirsMagiques(Item item) {
        decreaseQuality(item, 2);
        item.sellIn--;
        if (item.sellIn < 0) decreaseQuality(item, 2);
    }

    private void decreaseQuality(Item item, int amount) {
        item.quality = Math.max(0, item.quality - amount);
    }

    private void increaseQuality(Item item, int amount) {
        item.quality = Math.min(50, item.quality + amount);
    }
}
