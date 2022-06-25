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
    @Transactional
    // save - cascade
    public CustomerDTO save(CustomerDTO customerDTO) throws NotFoundException {
        CustomerEntity customerEntity = convertCustomer.convertToEntity(customerDTO);
        if (customerDTO.getId() != null) {
            // lấy id
            CustomerEntity customerEntity1 = customerRepository.findOne(customerDTO.getId());
            customerEntity.setUserEntities(customerEntity1.getUserEntities());
            customerEntity.setTransactionEntities(customerEntity1.getTransactionEntities());
         //   customerRepository.delete(customerDTO.getId());
        }
        return convertCustomer.convertToDTO(customerRepository.save(customerEntity));
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

    @Override
    @Transactional
    public void deleteCustomer(List<Long> customerId) throws NotFoundException {
         if (!customerId.isEmpty()) {
             customerRepository.deleteByIdIn(customerId);
         }
    }

    @Override
    public CustomerDTO findById(Long id) {
        return id != null ? convertCustomer.convertToDTO(customerRepository.findOne(id)) : new CustomerDTO();
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
