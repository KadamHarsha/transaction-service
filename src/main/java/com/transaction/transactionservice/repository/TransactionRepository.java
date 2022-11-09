package com.transaction.transactionservice.repository;

import com.transaction.transactionservice.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction,String> {

    Page<Transaction> findAByAccountId(Pageable page, String accountId);
    String deleteByAccountId(String accountId);
}
