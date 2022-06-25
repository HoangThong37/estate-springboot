package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.request.TransactionRequest;
import com.laptrinhjavaweb.service.ITransactionService;
import javassist.NotFoundException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction")
public class TransactionAPI {
    private Logger LOGGER = Logger.getLogger(UserAPI.class);

    @Autowired
    private ITransactionService transactionService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody TransactionRequest transactionRequest) throws NotFoundException {
        transactionService.save(transactionRequest);
        return ResponseEntity.noContent().build();
    }
}
