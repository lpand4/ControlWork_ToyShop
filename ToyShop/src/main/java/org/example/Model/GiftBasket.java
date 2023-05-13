package org.example.Model;

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
