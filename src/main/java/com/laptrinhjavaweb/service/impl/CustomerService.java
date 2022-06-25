package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.converter.CustomerConverter;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.reponse.CustomerReponse;
import com.laptrinhjavaweb.dto.request.CustomerSearchRequest;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.repository.CustomerRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.ICustomerService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerConverter convertCustomer;

    @Override
    @Transactional
    public void assignmentCustomerWithCascade(List<Long> userId, Long customerId) {
        // giao tòa nhà cho nhân viên quản lí
        try {
            CustomerEntity customerEntity = customerRepository.findOne(customerId); // lấy id
            if (customerEntity != null) {
                customerEntity.setUserEntities(new HashSet<>(userRepository.findAll(userId)));
            }
            customerRepository.save(customerEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) throws NotFoundException {

        return null;
    }

    @Override
    public List<CustomerReponse> findAll(CustomerSearchRequest customerSearchRequest) {
        List<CustomerReponse> result = new ArrayList<>();
        CustomerSearchBuilder customerSearchBuilder = convertParamToBuilder(customerSearchRequest);
        List<CustomerEntity> customerEntities = customerRepository.findAll(customerSearchBuilder);
        for (CustomerEntity item : customerEntities) {
            result.add(convertCustomer.convertToCustomerReponse(item));
        }
        return result;
    }

    private CustomerSearchBuilder convertParamToBuilder(CustomerSearchRequest customerSearchRequest) {
        try {
            CustomerSearchBuilder result = new CustomerSearchBuilder.Builder().
                    fullName(customerSearchRequest.getFullName()).
                    phone(customerSearchRequest.getPhone()).
                    email(customerSearchRequest.getEmail()).build();
            return result;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
