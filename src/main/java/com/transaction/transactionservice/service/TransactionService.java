package com.transaction.transactionservice.service;

import com.transaction.transactionservice.dto.TransactionDto;

import java.util.List;

public interface TransactionService {
    List<TransactionDto> getTransactions();
    public TransactionDto createTransaction(TransactionDto transaction);
    public TransactionDto getTransactionById(String transactionId);
    public String deleteTransaction(String transactionId);


}
