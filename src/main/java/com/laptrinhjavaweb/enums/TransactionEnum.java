package com.laptrinhjavaweb.enums;

public enum TransactionEnum {
    QT_CSKH("QUÁ TRÌNH CSKH"),
    DANDIXEM("DẪN ĐI XEM"),
    DUADIXASTRESS("ĐƯA KHÁCH ĐI XẢ STRESS");

    private final String typeValue;

    TransactionEnum(String typeValue) {
        this.typeValue = typeValue;
    }

    public String getTypeValue() {
        return typeValue;
    }
}
