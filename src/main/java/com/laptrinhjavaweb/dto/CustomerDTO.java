package com.laptrinhjavaweb.dto;

import com.laptrinhjavaweb.dto.reponse.TransactionTypeReponse;

import java.util.List;

public class CustomerDTO extends AbstractDTO  {
    private String fullName; // coi lại
    private String phone;
    private String email;
    private String companyName; // tên công ty
    private String needs; // nhu cầu
    private String note; // ghi chú

    private List<TransactionTypeReponse> transactionTypeReponseList;

    public List<TransactionTypeReponse> getTransactionTypeReponseList() {
        return transactionTypeReponseList;
    }

    public void setTransactionTypeReponseList(List<TransactionTypeReponse> transactionTypeReponseList) {
        this.transactionTypeReponseList = transactionTypeReponseList;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getNeeds() {
        return needs;
    }

    public void setNeeds(String needs) {
        this.needs = needs;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
