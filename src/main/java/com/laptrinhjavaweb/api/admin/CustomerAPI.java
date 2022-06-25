package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.reponse.StaffAssignmentReponse;
import com.laptrinhjavaweb.service.ICustomerService;
import com.laptrinhjavaweb.service.IUserService;
import javassist.NotFoundException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerAPI {

    private Logger LOGGER = Logger.getLogger(UserAPI.class);

    @Autowired
    private IUserService userService;

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/{id}/staff")
    public List<StaffAssignmentReponse> getAllStaffByCustomer(@PathVariable("id") Long id) {
        return userService.getAllStaffAssignmentCustomer(id);
    }

    @PostMapping("/{id}/assignment")
    public Long assignmentBuildingCustomer(@RequestBody(required = false) List<Long> userId
            , @PathVariable("id") Long customerId) {
        customerService.assignmentCustomerWithCascade(userId, customerId);
        return customerId;
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customerDTO) throws NotFoundException {
        return ResponseEntity.ok(customerService.save(customerDTO));
    }



//    // save
//    @PostMapping
//    public BuildingDTO save(@RequestBody(required = false) BuildingDTO buildingDTO) {
//        return buildingService.saveWithCascade(buildingDTO);
//    }
//
//    // delete
//    @DeleteMapping
//    public BuildingDeleteRequest delete(@RequestBody BuildingDeleteRequest id) throws NotFoundException {
//        buildingService.deleteWithCascade(id);
//        return id;
//    }

//    @PostMapping
//    public ResponseEntity<UserDTO> createCustomers(@RequestBody CustomerDTO newUser) {
//        return ResponseEntity.ok(customerService.insert(newUser));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<UserDTO> updateUsers(@PathVariable("id") long id, @RequestBody UserDTO userDTO) {
//        return ResponseEntity.ok(customerService.update(id, userDTO));
//    }
}
