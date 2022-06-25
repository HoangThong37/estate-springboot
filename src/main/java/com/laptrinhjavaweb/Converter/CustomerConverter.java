package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.reponse.CustomerReponse;
import com.laptrinhjavaweb.dto.reponse.TransactionTypeReponse;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.utils.DateUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerConverter {
    @Autowired
    private ModelMapper modelMapper;

    // convert từ Entity qua Reponse
    public CustomerReponse convertToCustomerReponse(CustomerEntity customerEntity) {
        CustomerReponse customerReponse = modelMapper.map(customerEntity, CustomerReponse.class);
        customerReponse.setCreateDateStr(DateUtils.toDate(Optional.ofNullable(customerEntity.getCreatedDate()).orElse(new Date())));
        // nhân viên qli
        String staffName = customerEntity.getUserEntities().stream()
                .map(item -> item.getFullName()).collect(Collectors.joining(","));
        customerReponse.setStaffNames(staffName);
        return customerReponse;
    }

    // convert từ dto -> entity
    public CustomerEntity convertToEntity(CustomerDTO dto) {
        CustomerEntity result = modelMapper.map(dto, CustomerEntity.class); // đựng kết quả
        return result;
    }

    // convert từ Entity -> dto
    public CustomerDTO convertToDTO(CustomerEntity entity) {
        CustomerDTO result = modelMapper.map(entity, CustomerDTO.class); // đựng kết quả
        List<TransactionTypeReponse> transactionTypeReponseList = new ArrayList<>();
//        for (TransactionEnum item : TransactionEnum.value()) {
//
//        }



        return result;
    }
}