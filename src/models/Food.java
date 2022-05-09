package models;

public class Food extends Products {
    private int grams;


    public Food(String name, int portions, int price, int grams) {
        super(name, portions, price);
        this.grams = grams;
    }

    public int getGrams() {
        return grams;
    }

    public void setGrams(int grams) {
        this.grams = grams;
    }

    @Override
    public String toString() {
        return "Food{" +
                super.toString() +
                "grams=" + grams +
                '}';
    }
}
