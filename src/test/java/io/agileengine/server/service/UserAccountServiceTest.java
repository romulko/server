package io.agileengine.server.service;

import io.agileengine.server.domain.enums.TransactionType;
import io.agileengine.server.repository.TransactionRepository;
import io.agileengine.server.service.exceptions.NegativeBalanceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class UserAccountServiceTest {

    @Test
    void negativeAmount() {
        // given
        UserAccountService service = new UserAccountService(null);

        // when
        Assertions.assertThrows(
                NegativeBalanceException.class,
                () -> service.handleNewTransaction(TransactionType.credit, 1)
        );
    }

    @Test
    void credit() {
        // given
        TransactionRepository repository = mock(TransactionRepository.class);
        UserAccountService service = new UserAccountService(repository);

        // when
        service.handleNewTransaction(TransactionType.debit, 5);
        service.handleNewTransaction(TransactionType.credit, 1);

        // then
        assertEquals(4, service.getAmount());
    }

    @Test
    void debit() {
        // given
        TransactionRepository repository = mock(TransactionRepository.class);
        UserAccountService service = new UserAccountService(repository);

        // when
        service.handleNewTransaction(TransactionType.debit, 5);

        // then
        assertEquals(5, service.getAmount());
    }

    @Test
    public void concurrentAccess() {
        // given

        // when

        // then
    }
}
