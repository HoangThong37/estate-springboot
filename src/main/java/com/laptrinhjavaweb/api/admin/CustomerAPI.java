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
    public Long assignmentBuilding(@RequestBody(required = false) List<Long> staffIds
            , @PathVariable("id") Long customerId) throws NotFoundException {
        customerService.assignmentCustomer(staffIds, customerId);
        return customerId;
    }
    @PostMapping
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customerDTO) throws NotFoundException {
        return ResponseEntity.ok(customerService.save(customerDTO));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody List<Long> ids) throws NotFoundException {
        customerService.deleteCustomer(ids);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findById(id));
    }
}



