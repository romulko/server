package io.agileengine.server.repository;

import io.agileengine.server.domain.Transaction;
import io.agileengine.server.domain.enums.TransactionType;
import io.agileengine.server.repository.impl.InMemoryTransactionRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InMemoryTransactionRepositoryTest {

    @Test
    void createTransaction() {
        // given
        TransactionRepository repository = new InMemoryTransactionRepository();
        repository.create(TransactionType.credit, 1);
        repository.create(TransactionType.debit, 2);

        // when
        List<Transaction> transactions = repository.getAll();
        Transaction transaction = transactions.get(0);

        // then
        assertEquals(TransactionType.debit, transaction.getType());
        assertEquals(2, transaction.getAmount());
        assertEquals(2, transactions.size());
    }

    @Test
    void shouldReturnUnmodifiedList() {
        // given
        TransactionRepository repository = new InMemoryTransactionRepository();
        repository.create(TransactionType.credit, 1);

        // when
        repository.getAll().add(null);

        // then
        assertEquals(1, repository.getAll().size());
    }
}
