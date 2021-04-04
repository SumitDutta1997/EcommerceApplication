package com.company;

import java.util.ArrayList;

public class Seller extends User{
    private ArrayList<Product> products;

    public Seller(String name, String phoneNumber) {
        super(name, phoneNumber);
        products = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Seller{" +
                "products=" + products +
                '}';
    }

    public void registerProduct(ProductCatalogue productCatalogue, Product product) {
        product.setProductSeller(this);
        productCatalogue.addProduct(product);
        products.add(product);
    }

    public void updateProductQuantity(ProductCatalogue productCatalogue, Product product, int newQuantity) {
        productCatalogue.updateProductQuantity(product,newQuantity);
    }

    public void removeProduct(ProductCatalogue productCatalogue, Product product) {
        productCatalogue.removeProduct(product);
        products.remove(product);
    }
}
