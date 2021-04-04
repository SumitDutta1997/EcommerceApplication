package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ProductCatalogue implements Searchable{
    private HashMap<String, ArrayList<Product>> categoryProductMap;
    private HashMap<String, ArrayList<Seller>> productSellerMap;
    private ConcurrentHashMap<String, ArrayList<Product>> similarProducts;
    private ArrayList<Product> products;
    private ArrayList<Category> categories;

    public ProductCatalogue() {
        categoryProductMap = new HashMap<>();
        productSellerMap = new HashMap<>();
        similarProducts = new ConcurrentHashMap<>();
        similarProducts.put("Dummy products: ", new ArrayList<>());
        products = new ArrayList<>();
        categories = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "ProductCatalogue{" +
                "products=" + products +
                '}';
    }

    public HashMap<String, ArrayList<Product>> getCategoryProductMap() {
        return categoryProductMap;
    }

    public HashMap<String, ArrayList<Seller>> getProductSellerMap() {
        return productSellerMap;
    }

    public ConcurrentHashMap<String, ArrayList<Product>> getSimilarProducts() {
        return similarProducts;
    }

    @Override
    public ArrayList<Product> searchProduct(String productName) {
        return similarProducts.get(productName);
    }

    @Override
    public ArrayList<Product> searchCategory(String categoryName) {
        return categoryProductMap.get(categoryName);
    }

    public void addProduct(Product product) {
        products.add(product);
        updateProductSellerMap(product);
        updateCategoryProductMap(product);
        updateSimilarProductsMap(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void addCategory(Category newCategory) {
        categories.add(newCategory);
        updateCategoryProductMap();
    }

    private void updateSimilarProductsMap(Product newProduct) {
        String productName = newProduct.getProductName();
        Set<String> keySet = similarProducts.keySet();
        boolean isSimilar = false;
        for(String key: keySet) {
            if(key.contains(productName) || productName.contains(key)) {
                isSimilar = true;
                similarProducts.get(key).add(newProduct);
            }
            if(!isSimilar)
                similarProducts.put(newProduct.getProductName(), new ArrayList<Product>(List.of(newProduct)));
        }
    }

    private void updateCategoryProductMap() {
        for(Category category : categories)
            categoryProductMap.put(category.getCategoryName() , new ArrayList<>());
    }

    private void updateCategoryProductMap(Product product) {
        if(categoryProductMap.containsKey(product.getProductCategory().getCategoryName()))
            categoryProductMap.get(product.getProductCategory().getCategoryName()).add(product);
        else
            categoryProductMap.put(product.getProductCategory().getCategoryName() , new ArrayList<>(List.of(product)));
    }

    private void updateProductSellerMap(Product newProduct) {
        if(productSellerMap.containsKey(newProduct.getProductName()))
            productSellerMap.get(newProduct.getProductName()).add(newProduct.getProductSeller());
        else
            productSellerMap.put(newProduct.getProductName() ,new ArrayList<>(List.of(newProduct.getProductSeller())));
    }

    public void updateProductQuantity(Product product, int newQuantity) {
        for(Product prod: products) {
            if(prod.getProductID() == product.getProductID())
                prod.setProductAvailableCount(newQuantity);
        }
    }
}
