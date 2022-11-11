package com.transaction.transactionservice.util;

import com.transaction.transactionservice.dto.TransactionDto;
import com.transaction.transactionservice.model.Transaction;


public class ModelDtoTransformer {

    public static Transaction toEntity(TransactionDto dto) {
        return new Transaction(
                dto.get_id(),
                dto.getAccountId(),
                dto.getType(),
                dto.getAmount(),
                dto.getCreatedAt()
        );
    }

    public static TransactionDto toDto(Transaction model) {
        return new TransactionDto(
                model.get_id(),
                model.getAccountId(),
                model.getType(),
                model.getAmount(),
                model.getCreatedAt()
        );
    }
}
