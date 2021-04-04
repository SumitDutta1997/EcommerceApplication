package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Customer extends User{
    private Cart cart;
    private Order currentOrder;
    private ArrayList<Order> orderHistory;

    public Customer(String name, String phoneNumber) {
        super(name, phoneNumber);
        cart = new Cart();
        orderHistory = new ArrayList<>();
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(ArrayList<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public void addItemToCart(Item item) {
        this.cart.addItem(item);
    }

    public void removeItemFromCart(Item item) {
        this.cart.removeItem(item);
    }

    public void printCartItems(){
        System.out.println(this.cart.getItemList());
    }

    public void updateCount(Item item, int newCount) {
        this.cart.updateItemCount(item,newCount);
    }

    public void placeOrder() {
        currentOrder = new Order();
        currentOrder.setOrderStatus(OrderStatus.UNSHIPPED);
        currentOrder.setOrderDate(new Date());
        ArrayList<Item> orderedItems = this.cart.getItemList();
        double orderAmount = 0;
        for(Item item : orderedItems)
            orderAmount += item.getPrice();
        currentOrder.setOrderItems(orderedItems);
        currentOrder.setOrderAmount(orderAmount);
        currentOrder.setShippingAddress(this.getCurrentOrder().getShippingAddress());
        this.cart.checkout();
        this.orderHistory.add(currentOrder);
    }
}
