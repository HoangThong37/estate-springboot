package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.PasswordDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.exception.MyException;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IBuildingService {
    List<BuildingDTO> fillAll();
    void save(BuildingDTO buildingDTO);
}
