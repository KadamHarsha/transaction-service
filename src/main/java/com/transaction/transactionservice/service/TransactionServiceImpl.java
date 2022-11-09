package com.transaction.transactionservice.service;

import com.transaction.transactionservice.dto.TransactionDto;
import com.transaction.transactionservice.exception.TransactionNotFoundException;
import com.transaction.transactionservice.model.Transaction;
import com.transaction.transactionservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.transaction.transactionservice.constants.Constants.getCurrentDateTime;
import static com.transaction.transactionservice.util.ModelDtoTransformer.toDto;
import static com.transaction.transactionservice.util.ModelDtoTransformer.toEntity;

@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<TransactionDto> getTransactions() {
        List <Transaction> list= transactionRepository.findAll();
        List<TransactionDto> listDto = new ArrayList<TransactionDto>(list.size());

        for(Transaction transaction:list)
        {
            listDto.add(toDto(transaction));
        }
        return listDto;
    }

    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto) {
        transactionDto.setCreatedAt(getCurrentDateTime());
        Transaction transaction = toEntity(transactionDto);
        Transaction transactionResult = transactionRepository.save(transaction);
        return toDto(transactionResult);
    }

    @Override
    public TransactionDto getTransactionById(String transactionId) {
        Transaction transactionResult=transactionRepository.findById(transactionId).orElseThrow(() -> new TransactionNotFoundException("Transaction not found"));
        return toDto(transactionResult);
    }

    @Override
    public String deleteTransaction(String transactionId) {
        transactionRepository.deleteById(transactionId);
        return "Transaction deleted successfully.";
    }
}
