package com.company;

public class Product {
    private String productName;
    private String productDescription;
    private double productRatings;
    private double productPrice;
    private static int idCounter=0;
    private int productID;
    private int productAvailableCount;
    private Category productCategory;
    private Seller productSeller;

    public Product(String productName, String productDescription, double productPrice, int productAvailableCount, Category productCategory) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productAvailableCount = productAvailableCount;
        this.productCategory = productCategory;
        idCounter += 1;
        this.productID=idCounter;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductRatings() {
        return productRatings;
    }

    public void setProductRatings(double productRatings) {
        this.productRatings = productRatings;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductID() {
        return productID;
    }

    public int getProductAvailableCount() {
        return productAvailableCount;
    }

    public void setProductAvailableCount(int productAvailableCount) {
        this.productAvailableCount = productAvailableCount;
    }

    public Category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }

    public Seller getProductSeller() {
        return productSeller;
    }

    public void setProductSeller(Seller productSeller) {
        this.productSeller = productSeller;
    }


    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productRatings=" + productRatings +
                ", productPrice=" + productPrice +
                ", productID=" + productID +
                ", productAvailableCount=" + productAvailableCount +
                ", productCategory=" + productCategory +
                ", productSeller=" + productSeller +
                '}';
    }
}
