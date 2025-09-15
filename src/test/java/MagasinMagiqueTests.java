package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class MagasinMagiqueTests {

    @Test
    public void testUpdateNormalItem() {
        Item normal = new Item("Normal", 5, 10);  // <-- Item séparé
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(normal));

        magasin.updateItems();

        assertEquals(4, normal.sellIn);
        assertEquals(9, normal.quality);
    }

    @Test
    public void testUpdateComteItem() {
        Item comte = new Item("Comté", 0, 10);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(comte));

        magasin.updateItems();

        assertEquals(-1, comte.sellIn);
        assertEquals(12, comte.quality);
    }

    @Test
    public void testQualityNeverNegative() {
        Item normal = new Item("Normal", 0, 0);
        MagasinMagique magasin = new MagasinMagique(Arrays.asList(normal));

        magasin.updateItems();

        assertEquals(0, normal.quality);
    }
}
