package org.example;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class MagasinMagiqueTests {

    // --- ITEMS NORMAUX ---
    @Test
    public void testUpdateNormalItem() {
        Item normal = new Item("Normal", 5, 10);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(normal));

        magasin.updateItems();

        assertEquals(4, normal.sellIn);
        assertEquals(9, normal.quality);
    }

    @Test
    public void testNormalItemDegradesTwiceAfterSellIn() {
        Item normal = new Item("Normal", 0, 10);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(normal));

        magasin.updateItems();

        assertEquals(-1, normal.sellIn);
        assertEquals(8, normal.quality); // -2 car date dépassée
    }

    @Test
    public void testQualityNeverNegative() {
        Item normal = new Item("Normal", 0, 0);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(normal));

        magasin.updateItems();

        assertEquals(0, normal.quality);
    }

    // --- COMTÉ ---
    @Test
    public void testUpdateComteItem() {
        Item comte = new Item("Comté", 2, 10);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(comte));

        magasin.updateItems();

        assertEquals(1, comte.sellIn);
        assertEquals(11, comte.quality);
    }

    @Test
    public void testComteIncreasesTwiceAfterSellIn() {
        Item comte = new Item("Comté", 0, 10);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(comte));

        magasin.updateItems();

        assertEquals(-1, comte.sellIn);
        assertEquals(12, comte.quality);
    }

    @Test
    public void testComteQualityMax50() {
        Item comte = new Item("Comté", 5, 50);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(comte));

        magasin.updateItems();

        assertEquals(50, comte.quality);
    }

    // --- KRYPTONITE ---
    @Test
    public void testKryptoniteNeverChanges() {
        Item kryptonite = new Item("Kryptonite", 5, 80);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(kryptonite));

        magasin.updateItems();

        assertEquals(5, kryptonite.sellIn);
        assertEquals(80, kryptonite.quality);
    }

    // --- PASS VIP CONCERT ---
    @Test
    public void testPassVIPIncreasesBy1() {
        Item pass = new Item("Pass VIP Concert", 15, 20);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(pass));

        magasin.updateItems();

        assertEquals(14, pass.sellIn);
        assertEquals(21, pass.quality);
    }

    @Test
    public void testPassVIPIncreasesBy2When10DaysOrLess() {
        Item pass = new Item("Pass VIP Concert", 10, 20);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(pass));

        magasin.updateItems();

        assertEquals(9, pass.sellIn);
        assertEquals(22, pass.quality);
    }

    @Test
    public void testPassVIPIncreasesBy3When5DaysOrLess() {
        Item pass = new Item("Pass VIP Concert", 5, 20);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(pass));

        magasin.updateItems();

        assertEquals(4, pass.sellIn);
        assertEquals(23, pass.quality);
    }

    @Test
    public void testPassVIPQualityDropsTo0AfterConcert() {
        Item pass = new Item("Pass VIP Concert", 0, 20);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(pass));

        magasin.updateItems();

        assertEquals(-1, pass.sellIn);
        assertEquals(0, pass.quality);
    }

    // --- POUVOIRS MAGIQUES ---
    @Test
    public void testPouvoirsMagiquesDegradeTwiceAsFast() {
        Item pouvoirs = new Item("Pouvoirs magiques", 3, 6);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(pouvoirs));

        magasin.updateItems();

        assertEquals(2, pouvoirs.sellIn);
        assertEquals(4, pouvoirs.quality); // -2
    }

    @Test
    public void testPouvoirsMagiquesAfterSellInDegradeEvenFaster() {
        Item pouvoirs = new Item("Pouvoirs magiques", 0, 6);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(pouvoirs));

        magasin.updateItems();

        assertEquals(-1, pouvoirs.sellIn);
        assertEquals(2, pouvoirs.quality); // -2 encore après expiration
    }
}
