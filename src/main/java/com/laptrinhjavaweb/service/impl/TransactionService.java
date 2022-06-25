package com.laptrinhjavaweb.service.impl;


import com.laptrinhjavaweb.converter.TransactionConverter;
import com.laptrinhjavaweb.dto.request.TransactionRequest;
import com.laptrinhjavaweb.entity.TransactionEntity;
import com.laptrinhjavaweb.repository.TransactionRepository;
import com.laptrinhjavaweb.service.ITransactionService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private TransactionConverter transactionConverter;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    @Transactional
    public void save(TransactionRequest transactionRequest) throws NotFoundException {
        TransactionEntity transactionEntity = transactionConverter.toTransactionEntity(transactionRequest);
        if (transactionEntity != null) {
            transactionRepository.save(transactionEntity);
        }
    }
}
