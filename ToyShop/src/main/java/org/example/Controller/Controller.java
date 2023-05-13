package org.example.Controller;

import org.example.Model.GiftBasket;
import org.example.Model.Toy;
import org.example.Model.Warehouse;
import org.example.View.View;

import java.util.*;


public class Controller {
    Scanner sc = new Scanner(System.in);
    View v = new View();
    Warehouse wh;

    public Controller() {
        //Нужно подгружать игрушки для wh и gb
        Queue<Toy> queueToys = new LinkedList<>();
        List<Toy> warehouseToys = new ArrayList<Toy>();

        warehouseToys.add(new Toy("Tiger",3,10.0));
        warehouseToys.add(new Toy("Panda",6,20.0));
        warehouseToys.add(new Toy("Monkey",12,30.0));

        GiftBasket gb = new GiftBasket(queueToys);
        this.wh = new Warehouse(warehouseToys, gb);
    }

    public void start(){
        v.start_menu();
        String choise;
        try {
            do {
                v.menu();
                choise = sc.nextLine();
                switch (choise) {
                    case "1":
                        //Просмотреть список игрушек на складе
                        showToysOnWarehouse();
                        break;
                    case "2":
                        //Просмотреть список игрушек в корзине подарков.
                        showQueueGifts();
                        break;
                    case "3":
                        //Добавить игрушку на склад.
                        addNewToy();
                        break;
                    case "4":
                        //Провести розыгрыш игрушки.
                        conductingLottery();
                        break;
                    case "5":
                        //Получить приз.
                        pickUpPrize();
                        break;
                    case "6":
                        //Замена кол-ва.
                        changeQuantity();
                        break;
                    case "0":
                        //Выход.
                        System.out.println("Всего доброго");
                        break;
                    default:
                        System.out.println("Введенное значение не подходит.");
                        break;
                }
            } while (!choise.equals("0"));
        } catch (InputMismatchException a) {
            System.out.println("Введено неверное значение!");
        }
    }

    private void showToysOnWarehouse(){
        List<Toy> toys = wh.getToyWarehouse();
        v.showFullToys(toys);
    }
    private void showQueueGifts(){
        Queue<Toy> toys = wh.getGiftBasket().getBasketWithGifts();
        v.showQueueToys(toys);
    }

    private void addNewToy(){
        wh.addNewToy();
    }

    private void conductingLottery(){
        wh.randomGiftSelection();
    }

    private void pickUpPrize(){
        wh.pickUpPrize();
    }

    private void changeQuantity(){
        wh.changeQuantity();
    }

}
