package org.example.Model;

import org.example.View.View;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Warehouse implements Gift {
    List<Toy> toyWarehouse;
    GiftBasket giftBasket;

    public Warehouse(List<Toy> toyWarehouse, GiftBasket giftBasket) {
        this.toyWarehouse = toyWarehouse;
        this.giftBasket = giftBasket;
    }

    //Добавление игрушки на склад
    public void addNewToy() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название игрушки: ");
        String textName = sc.nextLine();
        Integer quantity;
        Double probability;
        String quantityStr;
        String probabilityStr;
        do {
            try {
                System.out.println("Введите количество: ");
                quantityStr = sc.nextLine();
                if (quantityStr.chars().allMatch(Character::isDigit) && Integer.parseInt(quantityStr) > 0) {
                    quantity = Integer.parseInt(quantityStr);
                    break;
                } else
                    System.out.println("Введите адекватное значение");
            } catch (Exception a) {
                System.out.println("Введено неверное значение");
            }
        } while (true);
        do {
            try {
                System.out.println("Введите шанс выпадения: ");
                probabilityStr = sc.nextLine();
                if (probabilityStr.chars().allMatch(Character::isDigit) && Integer.parseInt(probabilityStr) > 0) {
                    probability = Double.parseDouble(probabilityStr);
                    break;
                } else
                    System.out.println("Введите адекватное значение");
            } catch (Exception a) {
                System.out.println("Введено неверное значение");
            }
        } while (true);

        Toy newToy = new Toy(textName, quantity, probability);
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
        if (toyWarehouse.size() > 0) {
            RandomCollection<Toy> rc = new RandomCollection<Toy>();
            for (Toy toy : toyWarehouse)
                for (int i = 0; i < toy.quantity; i++) {
                    rc.add(toy.probability, toy);
                }
            Toy selectedToy = rc.next();
            removeToy(selectedToy);
            giftBasket.addGift(selectedToy);
            System.out.println("Игрушка добавилась в корзину подарков!");
        } else
            System.out.println("Игрушки на складе закончились :C");

    }


    public List<Toy> getToyWarehouse() {
        return toyWarehouse;
    }

    public GiftBasket getGiftBasket() {
        return giftBasket;
    }

    public void changeQuantity() {
        Scanner sc = new Scanner(System.in);
        String idStr;
        String quantityStr;
        boolean changed = true;
        View v = new View();
        do {
            v.showFullToys(toyWarehouse);
            System.out.println("Напишите ID игрушки, кол-во которой хотите поменять: ");
            idStr = sc.nextLine();

            if (idStr.chars().allMatch(Character::isDigit) && !idStr.isEmpty() ) {
                for (Toy toy : toyWarehouse) {
                    if (toy.id == Integer.parseInt(idStr)) {
                        System.out.println("Напишите желаемое количество: ");
                        quantityStr = sc.nextLine();
                        if (quantityStr.chars().allMatch(Character::isDigit) && !quantityStr.isEmpty() && Integer.parseInt(quantityStr) > 0) {
                            if (Integer.parseInt(quantityStr) > 0) {
                                toy.setQuantity(Integer.parseInt(quantityStr));
                                changed = false;
                            }
                        }
                    }
                }
                if (!changed) {
                    System.out.println("Замена прошла успешно!");
                } else {
                    System.out.println("Введено неверное значение, попробуйте еще раз!");
                }
            } else
                System.out.println("Введите адекватное значение");
        } while (changed);
    }

    public void pickUpPrize() {
        Scanner sc = new Scanner(System.in);
        View v = new View();
        if (giftBasket.basketWithGifts.size() > 0) {
            System.out.println("Назовите Ваше имя: ");
            String name = sc.nextLine();
            Toy prizeToy = giftBasket.basketWithGifts.poll();
            try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("prize.txt"))) {
                    bufferedWriter.write(prizeToy.toGiftFormat(name));
            } catch (IOException e) {
                System.out.println("Неполадки с файлом выдачи приза!");
            }
            //System.out.printf("Приз выдается %s. Он забирает ", name);
            //v.showPrize(prizeToy);
        } else
            System.out.println("Корзина подарков пуста, дождитесь новой лотереи!");

    }
}
