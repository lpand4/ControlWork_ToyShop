package org.example;

public class Toy extends AbstractToy {
    public Integer quantity; // кол-во
    public Double probability; // вероятность выпадения 0 - 100
    private static Integer countID = 0; // счетчик заполняющий ID


    // При создании игрушки без загрузки с файла
    public Toy(String textName, Integer quantity, Double probability) {
        super(countID++, textName);
        this.quantity = quantity;
        this.probability = probability;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }
}
