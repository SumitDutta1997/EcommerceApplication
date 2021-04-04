package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    private static int idCounter=0;
    private int OrderId;
    private OrderStatus orderStatus;
    private Date OrderDate;
    private double OrderAmount;
    private String shippingAddress = "HNo. 1999, ABC Colony";
    private ArrayList<OrderLog> orderLogs;
    private ArrayList<Item> orderItems;

    public Order() {
        idCounter += 1;
        this.OrderId = idCounter;
        orderLogs = new ArrayList<>();
        addOrderLog(new OrderLog(new Date(),OrderStatus.CREATED));
    }

    public void addOrderLog(OrderLog orderLog) {
        orderLogs.add(orderLog);
    }

    public int getOrderId() {
        return OrderId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        addOrderLog(new OrderLog(new Date(),orderStatus));
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.OrderDate = orderDate;
    }

    public double getOrderAmount() {
        return OrderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        OrderAmount = orderAmount;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public ArrayList<OrderLog> getOrderLogs() {
        return orderLogs;
    }

    public void setOrderLogs(ArrayList<OrderLog> orderLogs) {
        this.orderLogs = orderLogs;
    }

    public ArrayList<Item> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<Item> orderItems) {
        this.orderItems = new ArrayList<>(orderItems);
    }

    @Override
    public String toString() {
        return " Order {" +
                " OrderId=" + OrderId +
                " , orderStatus=" + orderStatus +
                " , OrderDate=" + OrderDate +
                " , OrderAmount=" + OrderAmount +
                " , shippingAddress=" + shippingAddress +
                " , orderLogs=" + orderLogs +
                " , orderItems=" + orderItems +
                " }";
    }

    public Shipment moveToShipment(){
        Shipment shipment = new Shipment(this);
        return shipment;
    }
}
