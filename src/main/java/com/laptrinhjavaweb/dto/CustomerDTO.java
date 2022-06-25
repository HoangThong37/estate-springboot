package com.laptrinhjavaweb.dto;

import com.laptrinhjavaweb.dto.reponse.TransactionTypeReponse;

import java.util.List;

public class CustomerDTO extends AbstractDTO  {
    private String name;
    private String phone;
    private String email;
    private List<TransactionTypeReponse> transactionTypeReponseList;

    public List<TransactionTypeReponse> getTransactionTypeReponseList() {
        return transactionTypeReponseList;
    }

    public void setTransactionTypeReponseList(List<TransactionTypeReponse> transactionTypeReponseList) {
        this.transactionTypeReponseList = transactionTypeReponseList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
