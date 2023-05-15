package org.example.Model;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.FileHandler;


public class DataBase {
    public static String whFilename = "warehouse.txt";
    public static String gbFilename = "gift_basket.txt";
    GiftBasket giftBasket;
    Warehouse warehouse;

    public DataBase(Warehouse wh) {
        this.warehouse = wh;
    }


    public void saveAll(Warehouse wh) {
        saveWarehouse(wh);
        saveGiftBasket(wh);
    }

    private void saveWarehouse(Warehouse wh){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(whFilename))) {
            for(Toy toy : wh.toyWarehouse){
                bufferedWriter.write(toy.toSaveFormat() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Неполадки с файлом склада!");
        }
    }
    private void saveGiftBasket(Warehouse wh){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(gbFilename))) {
            for(Toy toy : wh.giftBasket.basketWithGifts){
                bufferedWriter.write(toy.toSaveFormat() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Неполадки с файлом корзины подарков!");
        }
    }

    public Warehouse readDataFromFile() {
        Warehouse wh = readWarehouseFromFIle();
        return wh;
    }

    private Warehouse readWarehouseFromFIle(){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(whFilename))) {
            List<Toy> toys = new ArrayList<Toy>();
            GiftBasket gb = readGiftBasketFromFile();
            String line;
            while ((line = bufferedReader.readLine())!=null){
                toys.add(parseToyFromFile(line));
            }
            this.warehouse = new Warehouse(toys,gb);
        } catch (IOException e) {
            System.out.println("Неполадки с файлом склада!");
        }
        return warehouse;
    }

    private GiftBasket readGiftBasketFromFile(){
        GiftBasket gb;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(gbFilename))) {
            Queue<Toy> toys = new LinkedList<Toy>();
            String line;
            while ((line = bufferedReader.readLine())!=null){
                toys.add(parseToyFromFile(line));
            }
            this.giftBasket = new GiftBasket(toys);
        }catch (IOException e) {
            System.out.println("Неполадки с файлом корзины подарков!");
        }
        return giftBasket;
    }

    private Toy parseToyFromFile(String line){
        String[] parts = line.split(" ");
        Integer id = Integer.parseInt(parts[0]);
        String textName = parts[1];
        Integer quantity = Integer.parseInt(parts[2]);
        Double probability = Double.parseDouble(parts[3]);
        return new Toy(id,textName,quantity,probability);
    }
}
