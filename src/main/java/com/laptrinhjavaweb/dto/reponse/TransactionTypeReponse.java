package com.laptrinhjavaweb.dto.reponse;

import java.util.ArrayList;
import java.util.List;

public class TransactionTypeReponse { // loại giao dịch trả ra
    private String code;
    private String typeValue;
    private List<TransactionReponse> transaction = new ArrayList<>();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }

    public List<TransactionReponse> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<TransactionReponse> transaction) {
        this.transaction = transaction;
    }
}
