package io.agileengine.server.repository;

import io.agileengine.server.domain.Transaction;
import io.agileengine.server.domain.enums.TransactionType;

import java.util.List;

public interface TransactionRepository {
    List<Transaction> getAll();

    Transaction findById(String id);

    Transaction create(TransactionType type, float amount);
}
