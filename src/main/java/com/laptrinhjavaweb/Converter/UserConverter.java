package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.dto.reponse.StaffAssignmentReponse;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.custom.UserRepositoryCustom;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepositoryCustom userRepository;

    public UserDTO convertToDto (UserEntity entity){
        UserDTO result = modelMapper.map(entity, UserDTO.class);
        return result;
    }

    public UserEntity convertToEntity (UserDTO dto){
        UserEntity result = modelMapper.map(dto, UserEntity.class);
        return result;
    }


    public List<StaffAssignmentReponse> toStaffAssignmentResponses(List<UserEntity> staffAssignments) {
        List<StaffAssignmentReponse> result = new ArrayList<>();
        for (UserEntity item : userRepository.getAllStaff()) {
            int i = 0;
            for (UserEntity item2 : staffAssignments) {
                if(item.getId()==item2.getId())
                    i++;
            }
            StaffAssignmentReponse staffAssignmentResponse = modelMapper.map(item,StaffAssignmentReponse.class);
            if ( i > 0 ) {
                staffAssignmentResponse.setCheckes("checked");
                result.add(staffAssignmentResponse); }
        }
        return result;
    }
}

