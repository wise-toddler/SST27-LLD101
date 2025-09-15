package com.example.orders;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Immutable Order with Builder pattern
 */
public final class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderLine> lines; // immutable view
    private final Integer discountPercent;
    private final boolean expedited;
    private final String notes;

    private Order(Builder b) {
        this.id = b.id;
        this.customerEmail = b.customerEmail;
        this.discountPercent = b.discountPercent;
        this.expedited = b.expedited;
        this.notes = b.notes;
        // Defensive copy to prevent mutability leaks
        List<OrderLine> copy = new ArrayList<>();
        for (OrderLine l : b.lines) {
            copy.add(new OrderLine(l.getSku(), l.getQuantity(), l.getUnitPriceCents()));
        }
        this.lines = List.copyOf(copy);
    }

    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public List<OrderLine> getLines() { return lines; }
    public Integer getDiscountPercent() { return discountPercent; }
    public boolean isExpedited() { return expedited; }
    public String getNotes() { return notes; }

    public int totalBeforeDiscount() {
        int sum = 0;
        for (OrderLine l : lines) sum += l.getQuantity() * l.getUnitPriceCents();
        return sum;
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null) return base;
        return base - (base * discountPercent / 100);
    }

    public static final class Builder {
        private String id;
        private String customerEmail;
        private final List<OrderLine> lines = new ArrayList<>();
        private Integer discountPercent;
        private boolean expedited;
        private String notes;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder customerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
            return this;
        }

        public Builder addLine(OrderLine line) {
            this.lines.add(line);
            return this;
        }

        public Builder discountPercent(Integer discountPercent) {
            this.discountPercent = discountPercent;
            return this;
        }

        public Builder expedited(boolean expedited) {
            this.expedited = expedited;
            return this;
        }

        public Builder notes(String notes) {
            this.notes = notes;
            return this;
        }

        public Order build() {
            // Validation
            Objects.requireNonNull(id, "id required");
            Objects.requireNonNull(customerEmail, "email required");
            if (!PricingRules.isValidEmail(customerEmail)) {
                throw new IllegalArgumentException("invalid email");
            }
            if (!PricingRules.isValidDiscount(discountPercent)) {
                throw new IllegalArgumentException("invalid discount");
            }
            if (lines.isEmpty()) {
                throw new IllegalArgumentException("need at least one line");
            }
            return new Order(this);
        }
    }
}