package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.request.TransactionRequest;
import com.laptrinhjavaweb.entity.TransactionEntity;
import com.laptrinhjavaweb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionConverter {

    @Autowired
    private CustomerRepository customerRepository;
    // dto -> entity
    public TransactionEntity toTransactionEntity(TransactionRequest transactionRequest) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setCode(transactionRequest.getCode());
        transactionEntity.setNote(transactionRequest.getNote());
        if (!transactionRequest.getCode().isEmpty() || transactionRequest.getCode() != null) {
            transactionEntity.setCustomerEntity(customerRepository.findOne(transactionRequest.getCustomerId()));
        }
        return transactionEntity;
    }

}
