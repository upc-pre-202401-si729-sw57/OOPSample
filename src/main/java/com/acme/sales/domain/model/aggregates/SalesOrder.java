package com.acme.sales.domain.model.aggregates;

import com.acme.shared.domain.model.valueobjects.Address;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SalesOrder {
    private final UUID internalId;

    private SalesOrderStatus status;

    private Address shippingAddress;

    private double payedAmount;

    private List<SalesOrderItem> items;

    public SalesOrder() {
        internalId = UUID.randomUUID();
        status = SalesOrderStatus.CREATED;
        payedAmount = 0;
    }

    public void addItem(Long productId, int quantity, double unitPrice) {
        verifyItemAddingIsAllowed();
        items.add(new SalesOrderItem(this.internalId, quantity, productId, unitPrice));
    }

    public double calculateTotalPrice() {
        return items.stream().mapToDouble(SalesOrderItem::calculateItemPrice).sum();
    }

    public void addPayment(double amount) {
        payedAmount += amount;
    }

    private void verifyItemAddingIsAllowed() {
        if (status == SalesOrderStatus.APPROVED)
            throw new IllegalStateException("Cannot add items to an approved order.");
    }
}
