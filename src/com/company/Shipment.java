package com.company;

import java.time.LocalDateTime;

public class Shipment {
    private static int idCounter=0;
    private int shipmentNumber;
    private LocalDateTime estimatedArrival;
    private LocalDateTime orderDate;
    private Order orderDetails;

    public Shipment(Order orderDetails) {
        this.orderDetails = orderDetails;
        orderDetails.setOrderStatus(OrderStatus.SHIPPED);
        idCounter += 1;
        this.shipmentNumber = idCounter;
        this.orderDate = LocalDateTime.now();
        this.estimatedArrival = this.orderDate.plusDays(2);
    }

    public int getShipmentNumber() {
        return shipmentNumber;
    }

    public LocalDateTime getEstimatedArrival() {
        return estimatedArrival;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public Order getOrderDetails() {
        return orderDetails;
    }


    @Override
    public String toString() {
        return " Shipment {" +
                " shipmentNumber=" + shipmentNumber +
                " , estimatedArrival=" + estimatedArrival +
                " , orderDate=" + orderDate +
                " , orderDetails=" + orderDetails +
                " }";
    }
}
