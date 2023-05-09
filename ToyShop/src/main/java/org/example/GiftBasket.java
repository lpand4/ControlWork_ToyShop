package org.example;

import java.util.List;
import java.util.Queue;

public class GiftBasket {
    Queue<Toy> basketWithGifts;

    public GiftBasket(Queue<Toy> basketWithGifts) {
        this.basketWithGifts = basketWithGifts;
    }

    public void addGift(Toy giftToy){
        basketWithGifts.add(giftToy);
    }
}
