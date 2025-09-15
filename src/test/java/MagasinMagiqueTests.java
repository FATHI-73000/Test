package org.example;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class MagasinMagiqueTests {

    // --- TESTS POUR LES ITEMS NORMAUX ---
    @Test
    public void testUpdateNormalItem() {
        MagasinMagique.Item normal = new MagasinMagique.Item("Normal", 5, 10);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(normal));

        magasin.updateQuality();

        assertEquals(4, normal.sellIn);  // sellIn diminue de 1
        assertEquals(9, normal.quality); // quality diminue de 1
    }

    @Test
    public void testNormalItemDegradesTwiceAfterSellIn() {
        MagasinMagique.Item normal = new MagasinMagique.Item("Normal", 0, 10);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(normal));

        magasin.updateQuality();

        assertEquals(-1, normal.sellIn);
        assertEquals(8, normal.quality); // -2 car date dépassée
    }

    @Test
    public void testQualityNeverNegative() {
        MagasinMagique.Item normal = new MagasinMagique.Item("Normal", 0, 0);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(normal));

        magasin.updateQuality();

        assertEquals(0, normal.quality); // quality ne peut pas être négative
    }

    // --- TESTS POUR COMTÉ ---
    @Test
    public void testUpdateComteItem() {
        MagasinMagique.Item comte = new MagasinMagique.Item("Comté", 2, 10);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(comte));

        magasin.updateQuality();

        assertEquals(1, comte.sellIn);
        assertEquals(11, comte.quality); // quality augmente de 1
    }

    @Test
    public void testComteIncreasesTwiceAfterSellIn() {
        MagasinMagique.Item comte = new MagasinMagique.Item("Comté", 0, 10);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(comte));

        magasin.updateQuality();

        assertEquals(-1, comte.sellIn);
        assertEquals(12, comte.quality); // augmente de 2 car date dépassée
    }

    @Test
    public void testQualityNeverAbove50() {
        MagasinMagique.Item comte = new MagasinMagique.Item("Comté", 5, 50);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(comte));

        magasin.updateQuality();

        assertEquals(50, comte.quality); // reste bloqué à 50
    }

    // --- TESTS POUR KRYPTONITE ---
    @Test
    public void testKryptoniteNeverChanges() {
        MagasinMagique.Item kryptonite = new MagasinMagique.Item("Kryptonite", 5, 80);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(kryptonite));

        magasin.updateQuality();

        assertEquals(5, kryptonite.sellIn);  // ne change pas
        assertEquals(80, kryptonite.quality); // ne change pas
    }

    // --- TESTS POUR PASS VIP CONCERT ---
    @Test
    public void testPassVIPIncreasesBy1() {
        MagasinMagique.Item pass = new MagasinMagique.Item("Pass VIP Concert", 15, 20);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(pass));

        magasin.updateQuality();

        assertEquals(14, pass.sellIn);
        assertEquals(21, pass.quality);
    }

    @Test
    public void testPassVIPIncreasesBy2When10DaysOrLess() {
        MagasinMagique.Item pass = new MagasinMagique.Item("Pass VIP Concert", 10, 20);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(pass));

        magasin.updateQuality();

        assertEquals(9, pass.sellIn);
        assertEquals(22, pass.quality);
    }

    @Test
    public void testPassVIPIncreasesBy3When5DaysOrLess() {
        MagasinMagique.Item pass = new MagasinMagique.Item("Pass VIP Concert", 5, 20);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(pass));

        magasin.updateQuality();

        assertEquals(4, pass.sellIn);
        assertEquals(23, pass.quality);
    }

    @Test
    public void testPassVIPQualityDropsTo0AfterConcert() {
        MagasinMagique.Item pass = new MagasinMagique.Item("Pass VIP Concert", 0, 20);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(pass));

        magasin.updateQuality();

        assertEquals(-1, pass.sellIn);
        assertEquals(0, pass.quality);
    }

    // --- TESTS POUR POUVOIRS MAGIQUES ---
    @Test
    public void testPouvoirsMagiquesDegradeTwiceAsFast() {
        MagasinMagique.Item pouvoirs = new MagasinMagique.Item("Pouvoirs magiques", 3, 6);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(pouvoirs));

        magasin.updateQuality();

        assertEquals(2, pouvoirs.sellIn);
        assertEquals(4, pouvoirs.quality); // -2 car dégradation double
    }

    @Test
    public void testPouvoirsMagiquesAfterSellInDegradeEvenFaster() {
        MagasinMagique.Item pouvoirs = new MagasinMagique.Item("Pouvoirs magiques", 0, 6);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(pouvoirs));

        magasin.updateQuality();

        assertEquals(-1, pouvoirs.sellIn);
        assertEquals(2, pouvoirs.quality); // -4 après date dépassée
    }
}
