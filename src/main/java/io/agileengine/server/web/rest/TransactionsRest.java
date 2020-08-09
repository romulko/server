package io.agileengine.server.web.rest;

import io.agileengine.server.domain.Transaction;
import io.agileengine.server.service.UserAccountService;
import io.agileengine.server.web.rest.dto.TransactionDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/transactions")
public class TransactionsRest {
    private final UserAccountService userAccountService;

    public TransactionsRest(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping
    public Collection<Transaction> getTransactions() {
        return userAccountService.getTransactions();
    }

    @GetMapping(path = "/{txId}")
    public Transaction findById(@PathVariable("txId") String txId) {
        return userAccountService.findById(txId);
    }

    @PostMapping
    public Transaction create(@RequestBody TransactionDTO transactionBody) {
        return userAccountService.handleNewTransaction(transactionBody.getType(), transactionBody.getAmount());
    }
}
