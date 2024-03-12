//Adharsh Thiagarjan


package com.company;

import java.util.List;

public interface TransactionDAO<T> {
    TransactionDTO getTransactionById(String transactionID);

    List<TransactionDTO> getTransactionsByAccountID(String accountID);

    boolean addTransaction (TransactionDTO transaction);

    int updateTransaction (TransactionDTO transaction);

    boolean deleteTransaction (String transactionID);
}
