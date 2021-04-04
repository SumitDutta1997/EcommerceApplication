package com.company;

public class Item {
    private int productID;
    private Product product;
    private int count;
    private double price;

    public Item(Product product, int count) {
        this.productID = product.getProductID();
        this.count = count;
        this.price = product.getProductPrice() * count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return " Item {" +
                " productID=" + productID +
                " , product=" + product +
                " , count=" + count +
                " , price=" + price +
                " } ";
    }

    public void updateCount(int newCount) {
        price = (price/count)*newCount;
        count = newCount;
    }
}
