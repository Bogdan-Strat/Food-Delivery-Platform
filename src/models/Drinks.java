package models;

import models.Products;

public class Drinks extends Products {
    private int ml;

    public Drinks(String name, int portions, int price,  int ml) {
        super(name, portions, price);
        this.ml = ml;
    }

    public int getMl() {
        return ml;
    }

    public void setMl(int ml) {
        this.ml = ml;
    }

    @Override
    public String toString() {
        return "Drinks{" +
                super.toString() +
                "ml=" + ml +
                '}';
    }
}
