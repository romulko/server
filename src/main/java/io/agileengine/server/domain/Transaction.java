package io.agileengine.server.domain;

import io.agileengine.server.domain.enums.TransactionType;

import java.time.LocalDateTime;

public final class Transaction {
    private final String id;

    private final TransactionType type;

    private final float amount;

    private final LocalDateTime effectiveDate;

    public Transaction(String id, TransactionType type, float amount, LocalDateTime effectiveDate) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.effectiveDate = effectiveDate;
    }

    public String getId() {
        return id;
    }

    public TransactionType getType() {
        return type;
    }

    public float getAmount() {
        return amount;
    }

    public LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }
}
