package org.example.Model;

import org.example.Model.AbstractToy;

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

    public Toy(Integer id, String textName, Integer quantity, Double probability) {
        super(id, textName);
        this.quantity = quantity;
        this.probability = probability;
        countID = id + 1;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append("\t| ID: ").append(this.id)
                .append("\t |Название: ").append(this.textName)
                .append("\t| Кол-во: ").append(this.quantity).append(" шт")
                .append("\t| Шанс: ").append(this.probability).append("% |");
        return sb.toString();
    }
    public String toSaveFormat(){
        StringBuilder sb = new StringBuilder().append(this.id).append(" ")
                .append(this.textName).append(" ")
                .append(this.quantity).append(" ")
                .append(this.probability);
        return sb.toString();
    }
    public String toGiftFormat(String name){
        StringBuilder sb = new StringBuilder().append("Поздравляем ").append(name)
                .append("! Вы теперь являетесь обладателем данной игрушки: ").append(this.textName)
                .append(" шанс ее выпадения равнялся ").append(this.probability)
                .append("%!!!");
        return sb.toString();
    }
}
