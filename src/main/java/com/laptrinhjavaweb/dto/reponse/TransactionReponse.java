package com.laptrinhjavaweb.dto.reponse;

public class TransactionReponse {
    private String createDateStr;
    private String note;

    public TransactionReponse() {
    }

    public TransactionReponse(String createDateStr, String note) {
        this.createDateStr = createDateStr;
        this.note = note;
    }

    public String getCreateDateStr() {
        return createDateStr;
    }

    public void setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
