package org.example.Model;

import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

class RandomCollection<E> {
    private final NavigableMap<Double, E> map = new TreeMap<Double, E>();
    private final Random random;
    private double total = 0;

    public RandomCollection() {
        this(new Random());
    }

    public RandomCollection(Random random) {
        this.random = random;
    }

    public void getCount(){
        System.out.println(this.map.size());
    }

    public RandomCollection<E> add(double weight, E result) {
        if (weight <= 0) return this;
        total += weight;
        map.put(total, result);
        return this;
    }

    public E next() {
        double value = random.nextDouble() * total;
        E resultValue = map.higherEntry(value).getValue();
        Toy resultValueToy = (Toy) resultValue;
        Double resultKey = map.higherEntry(value).getKey();
        //System.out.println(total);
        this.total -= resultValueToy.getProbability();
        map.remove(resultKey);
        return resultValue;
    }
}

