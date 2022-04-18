/*
package com.laptrinhjavaweb.converter;
import com.laptrinhjavaweb.dto.RentAreaDTO;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.service.impl.RentAreaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RentAreaConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RentAreaService rentAreaService;

    public RentAreaDTO convertToDto(RentAreaEntity entity) {
        RentAreaDTO result = modelMapper.map(entity, RentAreaDTO.class);
        return result;
    }

    public RentAreaEntity convertToEntity(RentAreaDTO dto) {
        RentAreaEntity result = modelMapper.map(dto, RentAreaEntity.class);
        return result;
    }
}
*/
