package com.github.lexaz93.dao;

import com.github.lexaz93.model.Account;

import java.util.List;

public interface AccountDao {
    Account read(String login);
    List<Account> readAll();
    void create(Account account);
    void delete(Account account);
    void updatePassword(Account account);
}
