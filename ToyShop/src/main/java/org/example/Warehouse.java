package org.example;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Gift {
    List<Toy> toyWarehouse;
    GiftBasket giftBasket;

    public Warehouse(ArrayList<Toy> toyWarehouse, GiftBasket giftBasket) {
        this.toyWarehouse = toyWarehouse;
        this.giftBasket = giftBasket;
    }

    //Добавление игрушки на склад
    public void addNewToy(Toy newToy) {
        toyWarehouse.add(newToy);
    }

    //Убирает одну игрушку со склада
    public void removeToy(Toy toy) {
        if (toy.quantity > 1) {
            toyWarehouse.get(toyWarehouse.indexOf(toy)).
                    setQuantity(toyWarehouse.get(toyWarehouse.indexOf(toy)).quantity - 1);
        } else {
            toyWarehouse.remove(toy);
        }
    }

    @Override
    public void randomGiftSelection() {
        Toy selectedToy = null;


        removeToy(selectedToy);
        giftBasket.addGift(selectedToy);
    }


}
