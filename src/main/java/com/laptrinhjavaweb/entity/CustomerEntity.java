package com.laptrinhjavaweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity {

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "customerEntity",fetch = FetchType.LAZY)
    private List<TransactionEntity> transactions = new ArrayList<>();

    @OneToMany(mappedBy = "customerEntity",fetch = FetchType.LAZY)
    private List<AssignmentCustomerEntity> assignmentCustomers = new ArrayList<>();

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public List<TransactionEntity> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionEntity> transactions) {
        this.transactions = transactions;
    }

    public List<AssignmentCustomerEntity> getAssignmentCustomers() {
        return assignmentCustomers;
    }

    public void setAssignmentCustomers(List<AssignmentCustomerEntity> assignmentCustomers) {
        this.assignmentCustomers = assignmentCustomers;
    }
}
