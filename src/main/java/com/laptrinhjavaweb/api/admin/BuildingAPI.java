package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.reponse.BuildingSearchReponse;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.service.impl.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController(value = "buildingAPIOfAdmin")
public class BuildingAPI {

    @Autowired
    private BuildingService buildingService;

    @GetMapping(value = "/api/building")
    public List<BuildingSearchReponse> showBuilding(@RequestParam(required = false) Map<String, String> params,
                                                    @RequestParam(required = false) List<String> types) {
        return buildingService.buildingSearch(params, types);
    }

    @PostMapping("api/building")
    public BuildingDTO createBuilding(@RequestBody BuildingDTO newBuilding) {
        return buildingService.insert(newBuilding) ;
    }

    @PutMapping("api/building/{id}")
    public BuildingDTO updateBuilding(@PathVariable("id") Long id, @RequestBody BuildingDTO buildingDTO) {
        return buildingService.update(id, buildingDTO);
    }

    @DeleteMapping(value = "api/building")
    public void deleteBuilding(@RequestBody Long[] ids) {
        buildingService.delete(ids);
    }

    @PostMapping("api/assignment")
    public void assignment(@RequestBody BuildingDTO model) {
        System.out.println("");
    }
}