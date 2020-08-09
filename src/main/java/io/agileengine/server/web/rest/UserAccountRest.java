package io.agileengine.server.web.rest;

import io.agileengine.server.service.UserAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAccountRest {

    private final UserAccountService userAccountService;

    public UserAccountRest(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping
    public float getAmount() {
        return userAccountService.getAmount();
    }
}
