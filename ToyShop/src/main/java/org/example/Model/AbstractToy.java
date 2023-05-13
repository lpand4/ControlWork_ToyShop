package org.example.Model;

public abstract class AbstractToy {
    public Integer id;
    public String textName;

    public AbstractToy(Integer id, String textName) {
        this.id = id;
        this.textName = textName;
    }
}
