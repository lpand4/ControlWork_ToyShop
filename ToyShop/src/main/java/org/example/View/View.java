package org.example.View;

import org.example.Model.Toy;

import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class View {
    public void start_menu(){
        StringBuilder sb = new StringBuilder()
                .append("Добро пожаловать в магазин игрушек!\n")
                .append("Здесь Вы сможете найти различные игрушки, а некоторые даже получить бесплатно в лотерее!\n")
                .append("Все дальнейшие действия будут производиться выбором действий. Начнем!!!\n");
        System.out.println(sb.toString());
    }

    public void menu(){
        StringBuilder sb = new StringBuilder()
                .append("\n1. Просмотреть список игрушек на складе.\n")
                .append("2. Просмотреть список игрушек в корзине подарков.\n")
                .append("3. Добавить игрушку на склад.\n")
                .append("4. Провести розыгрыш игрушки.\n")
                .append("5. Получить приз.\n")
                .append("6. Заменить кол-во.\n")
                .append("0. Выход.\n");
        System.out.println(sb.toString());
    }

    public void showFullToys(List<Toy> toys){
        for (Toy toy : toys) {
            System.out.println(toy);
        }
    }
    public void showQueueToys(Queue<Toy> toys){
        int count = 1;
        for (Toy toy : toys) {
            System.out.printf("\t%d. \t%s \t- \t%.1f\n",count,toy.textName,toy.probability);
            count++;
        }
    }
    public void showPrize(Toy toy){
        System.out.printf("%s с шансом выпадения %.1f",toy.textName, toy.probability);
    }


}
