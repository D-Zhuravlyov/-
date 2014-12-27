package model;

public class Product implements IProduct {
    private int id;
    private String name;
    private double price;
    private int amount;


    public Product() {

    }
    public Product(int id){

        this.id = id;
    }

    public Product(String name, int count, double price, int id) {
        this.name = name;
        this.amount = count;
        this.price = price;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        System.out.println("SetPrice");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;

    }



    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", id=" + id + "," +
                '}';
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = 31 * hash + id;
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        Product product = (Product) o;
        return (this.id == product.id);
    }
}
