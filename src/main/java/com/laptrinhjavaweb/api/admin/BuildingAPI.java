package com.laptrinhjavaweb.api.admin;


import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.reponse.BuildingSearchReponse;
import com.laptrinhjavaweb.dto.reponse.StaffAssignmentReponse;
import com.laptrinhjavaweb.dto.request.AssignmentBuildingRequest;
import com.laptrinhjavaweb.service.impl.BuildingService;
import com.laptrinhjavaweb.service.impl.UserService;
import org.apache.log4j.Logger;
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

   private Logger LOGGER = Logger.getLogger(BuildingAPI.class);

   @GetMapping
   public List<BuildingSearchReponse> findAll(@RequestParam(required = false) Map<String, Object> params,
                                              @RequestParam(required = false) List<String> types) {
       return buildingService.findAll(params, types);
   }

   @GetMapping("/name")
   public List<BuildingSearchReponse> findFieldName(@RequestParam(required = false, name = "name") String name) {
      return buildingService.findFieldName(name);
   }

   @GetMapping("/{id}/staff")
   public List<StaffAssignmentReponse> getAllStaffByBuilding(@PathVariable("id") Long id) {
      return userService.getAllStaffAssignmentBuilding(id);
   }

   @PostMapping("/{id}/assignment")
   public AssignmentBuildingRequest assignmentBuilding(@RequestBody(required = false) AssignmentBuildingRequest assignmentBuilding
                                                            ,@PathVariable("id") Long buildingId) {
      buildingService.assignmentBuilding(assignmentBuilding, buildingId);
      return assignmentBuilding;
   }


   @PostMapping
   public BuildingDTO save(@RequestBody(required = false) BuildingDTO buildingDTO) {
      return buildingService.save(buildingDTO);
   }

   // DELETE
   @DeleteMapping("/{id}")
   public Long delete(@PathVariable("id") Long id) {
      buildingService.delete(id);
      return id;
   }

}




// INSERT
//   @PostMapping()
//   public ResponseEntity<BuildingDTO> insertBuilding(@RequestBody BuildingDTO buildingDTO) {
//       try {
//           return ResponseEntity.ok(buildingService.insert(buildingDTO));
//       } catch (FieldRequireException ex) {
//           throw ex; //  throw ex xong ta ném cái hàm để nó bắt lại thì ta dùng controllerAdvice
//       }
//   }
//
//   // UPDATE
//   @PutMapping("{id}")
//   public ResponseEntity<BuildingDTO> updateBuilding(@PathVariable("id") Long buildingId, @RequestBody BuildingDTO buildingDTO) {
//       try {
//           return ResponseEntity.ok(buildingService.update(buildingId, buildingDTO));
//       } catch (FieldRequireException ex) {
//           throw ex; //  throw ex xong ta ném cái hàm để nó bắt lại thì ta dùng controllerAdvice
//       }
//   }
//