package org.example;

import java.util.List;

public class MagasinMagique {

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
            return name + " " + sellIn + " " + quality;
        }
    }

    private final List<Item> items;

    public MagasinMagique(List<Item> items) {
        this.items = items;
    }

    public void updateItems() {
        for (Item item : items) {
            switch (item.name) {
                case "Comté": updateComte(item); break;
                case "Kryptonite": break;
                case "Pass VIP Concert": updatePass(item); break;
                case "Pouvoirs magiques": updatePouvoirMagiques(item); break;
                default: updateNormal(item);
            }
        }
    }

    private void updateNormal(Item item) {
        decreaseQuality(item);
        item.sellIn--;
        if (item.sellIn < 0) decreaseQuality(item);
    }

    private void decreaseQuality(Item item) {
        item.quality = Math.max(0, item.quality - 1);
    }

    private void updatePouvoirMagiques(Item item) {
        decreaseQuality(item);
        item.sellIn--;
        if (item.sellIn < 0) item.quality = Math.max(0, item.quality - 2);
    }

    private void updatePass(Item item) {
        increaseQuality(item);
        if (item.sellIn <= 10) increaseQuality(item);
        if (item.sellIn <= 5) increaseQuality(item);
        item.sellIn--;
        if (item.sellIn < 0) item.quality = 0;
    }

    private void updateComte(Item item) {
        increaseQuality(item);
        item.sellIn--;
        if (item.sellIn < 0) increaseQuality(item);
    }

    private void increaseQuality(Item item) {
        item.quality = Math.min(50, item.quality + 1);
    }

    public List<Item> getItems() {
        return items;
    }
}
