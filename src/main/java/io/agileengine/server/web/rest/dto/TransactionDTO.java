package io.agileengine.server.web.rest.dto;

import io.agileengine.server.domain.enums.TransactionType;

public final class TransactionDTO {
    private final TransactionType type;
    private final float amount;

    public TransactionDTO(TransactionType type, float amount) {
        this.type = type;
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public float getAmount() {
        return amount;
    }
}
