package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.constant.SystemConstant;
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
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerConverter convertCustomer;

    @Override
    public void assignmentCustomer(List<Long> staffIds, Long customerId) throws NotFoundException {
        // test cách 2 java 8
        CustomerEntity customerEntity = Optional.ofNullable(customerRepository.findOne(customerId)).orElseThrow(() -> new NotFoundException(SystemConstant.NF_CUSTOMER));
        customerEntity.setUserEntities(Optional.ofNullable(userRepository.findAll(staffIds)).orElseThrow(() -> new NotFoundException(SystemConstant.NF_CUSTOMER)));
        customerRepository.save(customerEntity);
    }

//  --- CÁCH 1 DÙNG JAVA 7 <GIAO TÒA NHÀ CHO NHÂN VIÊN QUẢN LÍ>
/*    @Override
    public void assignmentCustomer(List<Long> staffIds, Long customerId) throws NotFoundException {
        // giao tòa nhà cho nhân viên quản lí
        try {
            CustomerEntity customerEntity = customerRepository.findOne(customerId); // lấy id
            if (customerEntity != null) {
                customerEntity.setUserEntities(new ArrayList<>(userRepository.findAll(staffIds)));
            }
            customerRepository.save(customerEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

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

    private CustomerSearchBuilder convertParamToBuilder(CustomerSearchRequest customerSearchRequest) {
        try {
            CustomerSearchBuilder result = new CustomerSearchBuilder.Builder().
                    setFullName(customerSearchRequest.getFullName()).
                    setPhone(customerSearchRequest.getPhone()).
                    setEmail(customerSearchRequest.getEmail()).
                    setStaffId(customerSearchRequest.getStaffId()).build();
            return result;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional
    public List<Long> deleteCustomer(List<Long> customerId) throws NotFoundException {
         if (customerRepository.findAll(customerId).size() != customerId.size()) {
             throw new NotFoundException(SystemConstant.NF_CUSTOMER);
         }
        return customerRepository.deleteByIdIn(customerId);
    }

    @Override
    public CustomerDTO findById(Long id) {
        return id != null ? convertCustomer.convertToDTO(customerRepository.findOne(id)) : new CustomerDTO();
    }




}
