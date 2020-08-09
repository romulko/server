package io.agileengine.server.repository.impl;

import io.agileengine.server.domain.Transaction;
import io.agileengine.server.domain.enums.TransactionType;
import io.agileengine.server.repository.TransactionRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class InMemoryTransactionRepository implements TransactionRepository {
    private final Map<String, Transaction> transactions = new LinkedHashMap<>();

    @Override
    public List<Transaction> getAll() {
        List<Transaction> result = new ArrayList<>(transactions.values());
        Collections.reverse(result);
        return result;
    }

    @Override
    public Transaction findById(String id) {
        return transactions.get(id);
    }

    @Override
    public Transaction create(TransactionType type, float amount) {
        Transaction transaction = new Transaction(UUID.randomUUID().toString(),
                type, amount, LocalDateTime.now());

        transactions.put(transaction.getId(), transaction);

        return transaction;
    }
}
