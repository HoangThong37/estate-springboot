package com.laptrinhjavaweb.enums;

public enum TransactionEnum {

    QT_CSKH("QUÁ TRÌNH CSKH"),
    DANDIXEM("DẪN ĐI XEM"),
    DUADIXASTRESS("ĐƯA KHÁCH ĐI XẢ STRESS");

    private final String transactionValue;

    TransactionEnum(String transactionValue) {
        this.transactionValue = transactionValue;
    }

    public String getTransactionValue() {
        return transactionValue;
    }
}
