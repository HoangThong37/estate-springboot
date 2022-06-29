package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.reponse.CustomerReponse;
import com.laptrinhjavaweb.dto.request.CustomerSearchRequest;
import javassist.NotFoundException;

import java.util.List;

public interface ICustomerService {
//    void assignmentCustomer(List<Long> staffIds, Long customerId) throws NotFoundException;
    void assignmentCustomer(List<Long> staffIds,Long customerId) throws NotFoundException;
    CustomerDTO save(CustomerDTO customerDTO) throws NotFoundException;
    List<CustomerReponse> findAll(CustomerSearchRequest customerSearchRequest);
    void deleteCustomer(List<Long> customerId) throws NotFoundException;
    CustomerDTO findById(Long id);
}
