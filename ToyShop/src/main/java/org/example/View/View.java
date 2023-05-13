package org.example.View;

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
                .append("1. Просмотреть список игрушек на складе.\n")
                .append("2. Просмотреть список игрушек в корзине подарков.\n")
                .append("3. Добавить игрушку на склад.\n")
                .append("4. Провести розыгрыш игрушки.\n")
                .append("5. Получить приз.\n")
                .append("6. Выход.\n");
        System.out.println(sb.toString());
    }

}
