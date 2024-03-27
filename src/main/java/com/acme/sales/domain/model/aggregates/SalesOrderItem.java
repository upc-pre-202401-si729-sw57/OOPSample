package com.acme.sales.domain.model.aggregates;

import java.util.UUID;

public class SalesOrderItem {

    private UUID salesOrderId;

    private UUID itemId;

    private int quantity;

    private Long productId;

    private double unitPrice;

    private boolean dispatched;

    public SalesOrderItem(UUID salesOrderId, int quantity, Long productId, double unitPrice) {
        this.itemId = UUID.randomUUID();
        this.salesOrderId = salesOrderId;
        this.quantity = quantity;
        this.productId = productId;
        this.unitPrice = unitPrice;
        this.dispatched = false;
    }

    public double calculateItemPrice() {
        return unitPrice * quantity;
    }

    public void dispatch() {
        this.dispatched = true;
    }

    public boolean isDispatched() {
        return dispatched;
    }






}
