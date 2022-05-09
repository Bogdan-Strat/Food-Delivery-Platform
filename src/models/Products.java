package models;

public class Products {
    protected String name;
    protected Integer portions;
    protected Integer price;

    public Products(String name,int portions, int price) {
        this.name = name;
        this.portions =portions;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                ", portions=" + portions +
                ", price=" + price +
                '}';
    }
}
