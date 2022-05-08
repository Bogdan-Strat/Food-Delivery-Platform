package models;

public class Products {
    protected String name;
    protected int price;

    public Products(String name,int portions) {
        this.name = name;
        this.price =portions;
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
}
