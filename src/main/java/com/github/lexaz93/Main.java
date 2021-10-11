package com.github.lexaz93;

import com.github.lexaz93.dao.AccountDao;

import static com.github.lexaz93.dao.AccountDaoImpl.getInstance;

public class Main {
    public static void main(String[] args) {
        AccountDao dao = getInstance();

        dao.readAll().stream().filter((account -> account.getAge() < 20)).map(account -> account.getFirstName()).forEach(System.out::println);
        System.out.println(dao.readAll().stream().filter(account -> account.getLastName().endsWith("ов")).count());
    }
}
