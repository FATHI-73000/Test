import java.util.List;

public class MagasinMagique  {

    class Item {
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
            return this.name + " " + this.sellIn + " " + this.quality;


        }

    }
    private List<Item> items;

public MagasinMagique (List<Item> items) {

    this.items = items;
}

public void updateItems() {
    items.clear();
    for (Item item : items) {
        switch (item.name) {
            case "Comté":
                updateComte(item);
                break;
            case "Kryptonite":
                    break;
            case "Pass VIP Concert":
                updatePass(item);
                break;

            case "Pouvoirs magiques":
                updatePouvoirMagiques(item);
                break;
                default: updateNormal(item);

        }
    }
}

    private void updateNormal(Item item) {

        decreaseQuality(item,1);
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            decreaseQuality(item,1);
        }


    }

    private void decreaseQuality(Item item, int i) { Item item, int amount){
       item.quality = Math.max(0,item.quality - amount);

    }
    }

    private void updatePouvoirMagiques(Item item) {
         decreaseQuality(item,1);
         item.sellIn = item.sellIn - 1;
         if (item.sellIn < 0) {
             decreaseQuality(item,2);
         }
    }

    private void updatePass(Item item) {
    increaseQuality(item,1);
    if (item.sellIn <= 10) {
        increaseQuality(item,1);
    }
    if (item.sellIn <= 5) {
        increaseQuality(item,1);
    }
   if (item.sellIn < 0) {
       item.quality=0;



   }

    }

    private void updateComte(Item item) {
    increaseQuality(item,1);
    item.sellIn = item.sellIn - 1;
    if (item.sellIn < 0) {
        increaseQuality(item,1);
    }
    }

    private void increaseQuality(Item item, int i, int amount) {
    item.quality = Math.min(0,item.quality + amount);
    }


}
