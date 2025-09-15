package org.example;

import java.util.List;

public class MagasinMagique {

    private final List<Item> items;

    public MagasinMagique(List<Item> items) {
        this.items = items;
    }

    public void updateItems() {
        for (Item item : items) {
            switch (item.name) {
                case "Comté": updateComte(item); break;
                case "Kryptonite": break; // ne change jamais
                case "Pass VIP Concert": updatePass(item); break;
                case "Pouvoirs magiques": updatePouvoirMagiques(item); break;
                default: updateNormal(item);
            }
        }
    }

    // --- ITEMS NORMAUX ---
    private void updateNormal(Item item) {
        decreaseQuality(item, 1);
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) decreaseQuality(item, 1);
    }

    // --- COMTÉ ---
    private void updateComte(Item item) {
        increaseQuality(item, 1);
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) increaseQuality(item, 1);
    }

    // --- PASS VIP CONCERT ---
    private void updatePass(Item item) {
        increaseQuality(item, 1);
        if (item.sellIn <= 10) increaseQuality(item, 1);
        if (item.sellIn <= 5) increaseQuality(item, 1);
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) item.quality = 0;
    }

    // --- POUVOIRS MAGIQUES ---
    private void updatePouvoirMagiques(Item item) {
        decreaseQuality(item, 2); // deux fois plus vite
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) decreaseQuality(item, 2);
    }

    // --- AIDES ---
    private void decreaseQuality(Item item, int amount) {
        item.quality = Math.max(0, item.quality - amount);
    }

    private void increaseQuality(Item item, int amount) {
        item.quality = Math.min(50, item.quality + amount);
    }

    public List<Item> getItems() {
        return items;
    }
}
