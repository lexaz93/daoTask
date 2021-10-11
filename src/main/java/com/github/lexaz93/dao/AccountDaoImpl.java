package com.github.lexaz93.dao;

import com.github.lexaz93.model.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private Connection connection;

    public Account read(String login) {
        try (ResultSet rs = connection.createStatement().executeQuery("select login, password, firstName, lastName, age from accounts")) {
            while (rs.next()) {
                if (login.equalsIgnoreCase(rs.getString(1))) {
                    return new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Account> readAll() {
        try (ResultSet rs = connection.createStatement().executeQuery("select login, password, firstName, lastName, age from accounts")) {
            List<Account> accounts = new ArrayList<>();
            while (rs.next()) {
                accounts.add(new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }
            return accounts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void create(Account account) {
        try {
            connection.createStatement().executeUpdate("insert into accounts (login, password, firstName, lastName, age) values ('" + account.getLogin() + "','" + account.getPassword() + "','" + account.getFirstName() + "','" + account.getLastName() + "','" + account.getAge() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Account account) {
        try {
            connection.createStatement().executeUpdate("delete from accounts where login = '" + account.getLogin() + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePassword(Account account) {
        try {
            connection.createStatement().executeUpdate("update accounts set password = '" + account.getPassword() + "', firstName = '" + account.getFirstName() + "', lastName = '" + account.getLastName() + "', age = '" + account.getAge() + "' where login = '" + account.getLogin() + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private AccountDaoImpl() {
        String user = "sa";
        String password = "";
        String url = "jdbc:h2:~/test;" +
                "INIT=RUNSCRIPT FROM 'classpath:initDB.sql';";

        try {
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static AccountDaoImpl getInstance() {
        return new AccountDaoImpl();
    }
}
