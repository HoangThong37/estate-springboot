package com.laptrinhjavaweb.api.admin;


import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.reponse.BuildingSearchReponse;
import com.laptrinhjavaweb.dto.reponse.StaffAssignmentReponse;
import com.laptrinhjavaweb.dto.request.AssignmentBuildingRequest;
import com.laptrinhjavaweb.exception.FieldRequireException;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.service.impl.BuildingService;
import com.laptrinhjavaweb.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {

   @Autowired
   private BuildingService buildingService;

   @Autowired
   private UserService userService;

   @GetMapping
   public List<BuildingSearchReponse> findAll(@RequestParam(required = false) Map<String, Object> params,
                                              @RequestParam(required = false) List<String> types) {
       return buildingService.findAll(params, types);
   }

   @PostMapping
   public BuildingDTO save(@RequestBody(required = false) BuildingDTO buildingDTO) {
      return buildingService.save(buildingDTO);
   }

   @GetMapping("/{id}/staff")
   public List<StaffAssignmentReponse> getAllStaffByBuilding(@PathVariable("id") Long id) {
      return userService.getAllStaffAssignmentBuilding(id);
   }

   @PostMapping("/{id}/assignment")
   public AssignmentBuildingRequest assignmentBuilding(@RequestBody(required = false) AssignmentBuildingRequest assignmentBuildingRequest
           , @PathVariable("id") Long buildingId) {
      buildingService.assignmentBuilding(assignmentBuildingRequest, buildingId);
      return assignmentBuildingRequest;
   }

   @DeleteMapping("/{id}")
   public Long delete(@PathVariable("id") Long id) {
      buildingService.delete(id);
      return id;
   }

 /*@PostMapping("api/building")
   public BuildingDTO createBuilding(@RequestBody BuildingDTO newBuilding) {
       try {
           return buildingService.insert(newBuilding) ;
       } catch (FieldRequireException ex) {
           throw ex; //  throw ex xong ta ném cái hàm để nó bắt lại thì ta dùng controllerAdvice
       }
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
   }*/
}

