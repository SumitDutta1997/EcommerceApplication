package com.company;

import java.util.Date;

public class OrderLog {
    private Date creationTimeStamp;
    private OrderStatus status;

    public OrderLog(Date creationTimeStamp, OrderStatus status) {
        this.creationTimeStamp = creationTimeStamp;
        this.status = status;
    }

    public Date getCreationTimeStamp() {
        return creationTimeStamp;
    }

    public OrderStatus getStatus() {
        return status;
    }

}
