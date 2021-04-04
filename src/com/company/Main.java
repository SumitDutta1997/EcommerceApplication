package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    // write your code here

        //created a customer named sumit
        Customer Sumit = new Customer("Sumit Dutta", "9654123123");

        //System.out.println(Sumit.getOrderHistory());
        //System.out.println(Sumit.getCurrentOrder());
        //Sumit.setAddress("HNo. 1999, ABC Colony");
        //System.out.println(Sumit.getAddress());
        //Sumit.setId(1);
        //System.out.println(Sumit.getId());
        //System.out.println(Sumit.getName());
        //System.out.println(Sumit.getCart());
        //System.out.println(Sumit.getPhoneNumber());
        //System.out.println(Sumit.getClass());

        //created multiple sellers
        Seller sngSports = new Seller("SnG Sports" , "9988112233");
        Seller decathlon = new Seller("Decathlon" , "9988554433");
        Seller myProtein = new Seller("MyProtein" , "9898112200");
        Seller appleElectronics = new Seller("Apple Electronics" , "9876543210");
        Seller grofersGroceries = new Seller("Grofers Groceries" , "9654998877");
        Seller nykaaFashion = new Seller("Nykaa Fashion" , "9911223344");

        //created multiple categories
        Category sports = new Category("Sports");
        Category fitness = new Category("Fitness");
        Category nutrition = new Category("Nutrition");
        Category cosmetics = new Category("Cosmetics");
        Category electronics = new Category("Electronics");
        Category groceries = new Category("Groceries");

        EcommerceApp ecommerceApp = new EcommerceApp();

        //adding all the categories in the product catalogue of the ecommerce application
        ecommerceApp.productCatalogue.addCategory(sports);
        ecommerceApp.productCatalogue.addCategory(fitness);
        ecommerceApp.productCatalogue.addCategory(nutrition);
        ecommerceApp.productCatalogue.addCategory(cosmetics);
        ecommerceApp.productCatalogue.addCategory(electronics);
        ecommerceApp.productCatalogue.addCategory(groceries);

        //creating multiple products
        Product football =  new Product("Football","Outdoor Sports",800.00,3,sports);
        Product dumbbells =  new Product("Dumbbells","Gym Weights",1999.00,4,fitness);
        Product proteinShake =  new Product("Protein Shake","Health Drinks",3000.00,5,nutrition);
        Product lipstick =  new Product("Makeup","Multicolour",200.00,6,cosmetics);
        Product laptop =  new Product("laptop","Technology",45000.00,7,electronics);
        Product milkPacket =  new Product("Milk Packets","Daily Necessity",50.00,20,groceries);

        //System.out.println(football.getProductID());
        //System.out.println(football.getProductName());
        //football.setProductCategory(sports);
        //System.out.println(football.getProductCategory());
        //football.setProductSeller(sngSports);
        //System.out.println(football.getProductSeller());
        //System.out.println(football.getProductPrice());
        //System.out.println(football.getProductAvailableCount());
        //System.out.println(football.getProductDescription());
        //System.out.println(football.getProductRatings());


        //seller is registering multiple products in the product catalogue
        sngSports.registerProduct(ecommerceApp.productCatalogue , football);
        decathlon.registerProduct(ecommerceApp.productCatalogue , dumbbells);
        myProtein.registerProduct(ecommerceApp.productCatalogue , proteinShake);
        nykaaFashion.registerProduct(ecommerceApp.productCatalogue , lipstick);
        appleElectronics.registerProduct(ecommerceApp.productCatalogue , laptop);
        grofersGroceries.registerProduct(ecommerceApp.productCatalogue , milkPacket);

        /*
        // customer searching for products
        ArrayList<Product> footballResult = ecommerceApp.productCatalogue.searchProduct("football");
        System.out.println(footballResult);
        ArrayList<Product> dumbbellsResult = ecommerceApp.productCatalogue.searchProduct("dumbbells");
        System.out.println(dumbbellsResult);
        ArrayList<Product> laptopResult = ecommerceApp.productCatalogue.searchProduct("laptop");
        System.out.println(laptopResult);
        ArrayList<Product> lipstickResult = ecommerceApp.productCatalogue.searchProduct("lipstick");
        System.out.println(lipstickResult);
         */


        //customer (Sumit) is adding 5 milk packets to the shopping cart
        Item milkFivePackets = new Item(milkPacket,5);
        Sumit.addItemToCart(milkFivePackets);

        //customer (Sumit) is adding 4 laptops to the shopping cart
        Item laptopFour = new Item(laptop,4);
        Sumit.addItemToCart(laptopFour);

        //customer (Sumit) is adding 3 footballs to the shopping cart
        Item footballThree = new Item(football,3);
        Sumit.addItemToCart(footballThree);

        //printing whats inside the cart
        Sumit.printCartItems();

        //customer is updating quantity of milk packets from 5 to 10
        Sumit.updateCount(milkFivePackets,10);

        //checking the cart if the quantity of milk packets are updated successfully
        Sumit.printCartItems();

        //customer (sumit) is placing an order
        Sumit.placeOrder();
        //cart should be empty after placing the order
        Sumit.printCartItems();

        //checking order history
        System.out.println(Sumit.getOrderHistory());
        //printing the current order of the customer
        System.out.println(Sumit.getCurrentOrder());

        //customers order is moved to shipment i.e. from order status UNSHIPPED to SHIPPED
        Shipment s = Sumit.getCurrentOrder().moveToShipment();
        System.out.println(s);
    }
}
