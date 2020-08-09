package io.agileengine.server.service;

import io.agileengine.server.domain.Transaction;
import io.agileengine.server.domain.enums.TransactionType;
import io.agileengine.server.repository.TransactionRepository;
import io.agileengine.server.service.exceptions.NegativeBalanceException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Service
public class UserAccountService {
    private final TransactionRepository transactionRepository;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private BigDecimal amount = BigDecimal.ZERO;

    public UserAccountService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction handleNewTransaction(TransactionType txType, float txAmount) {
        try {
            lock.writeLock().lock();

            BigDecimal newAmount = new BigDecimal(txAmount);

            if (txType == TransactionType.credit) {
                if (amount.compareTo(newAmount) < 0) {
                    throw new NegativeBalanceException();
                }

                amount = amount.subtract(newAmount);
            } else {
                amount = amount.add(newAmount);
            }

            return transactionRepository.create(txType, txAmount);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public float getAmount() {
        try {
            lock.readLock().lock();
            return amount.floatValue();
        } finally {
            lock.readLock().unlock();
        }
    }

    public List<Transaction> getTransactions() {
        try {
            lock.readLock().lock();
            return transactionRepository.getAll();
        } finally {
            lock.readLock().unlock();
        }
    }

    public Transaction findById(String txId) {
        try {
            lock.readLock().lock();
            return transactionRepository.findById(txId);
        } finally {
            lock.readLock().unlock();
        }
    }
}
