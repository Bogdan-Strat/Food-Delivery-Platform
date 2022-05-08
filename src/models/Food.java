package models;

public class Food extends Products {
    private int grams;


    public Food(String name, int portions, int grams) {
        super(name, portions);
        this.grams = grams;
    }

    public int getGrams() {
        return grams;
    }

    public void setGrams(int grams) {
        this.grams = grams;
    }
}
