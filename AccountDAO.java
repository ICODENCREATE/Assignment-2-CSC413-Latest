//Adharsh Thiagarajan

package com.company;
import java.sql.SQLException;


public interface AccountDAO<T> {
    AccountDTO getAccountById(int accountID) throws SQLException;

    AccountDTO addAccount (AccountDTO account) throws SQLException;

    int updateAccount(AccountDTO account) throws SQLException;

    int deleteAccount(int accountID) throws SQLException;

    AccountDTO saveAccount(AccountDTO account) throws SQLException;
}
