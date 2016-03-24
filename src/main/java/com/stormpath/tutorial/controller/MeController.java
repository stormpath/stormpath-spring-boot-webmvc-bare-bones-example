package com.stormpath.tutorial.controller;

import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.servlet.account.AccountResolver;
import com.stormpath.tutorial.model.AccountInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MeController {

    @RequestMapping(value = "/auth/me", produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountInfo info(HttpServletRequest req) throws NotLoggedInException {
        Account account = AccountResolver.INSTANCE.getAccount(req);
        if (account == null) {
            throw new NotLoggedInException("You must be logged in to access /auth/me");
        }
        return new AccountInfo(account.getHref(), account.getEmail(),
            account.getGivenName(), account.getMiddleName(),
            account.getSurname(), account.getFullName(),
            account.getStatus(), account.getCustomData()
        );
    }

    @ExceptionHandler(NotLoggedInException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public AccountInfo unauthorized(NotLoggedInException e) {
        return new AccountInfo(e);
    }
}

class NotLoggedInException extends RuntimeException {

    public NotLoggedInException(String message) {
        super(message);
    }
}
