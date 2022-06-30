package com.laptrinhjavaweb.controller.admin;


import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.request.CustomerSearchRequest;
import com.laptrinhjavaweb.security.utils.SecurityUtils;
import com.laptrinhjavaweb.service.impl.CustomerService;
import com.laptrinhjavaweb.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;

    @GetMapping("/customer-list")
    public ModelAndView customerList(@ModelAttribute("modelSearch") CustomerSearchRequest customerSearchRequest) {

        // check role is Staff
        if (!SecurityUtils.getAuthorities().contains(SystemConstant.ADMIN_ROLE)) { // nếu kp là admin thì -> staff
            Long staffId = SecurityUtils.getPrincipal().getId();
            customerSearchRequest.setStaffId(staffId);
        }

        ModelAndView modelAndView = new ModelAndView("admin/customer/list");
        modelAndView.addObject("customers",customerService.findAll(customerSearchRequest));
        modelAndView.addObject("modelStaff",userService.getAllStaff());
        return modelAndView;
    }

    @GetMapping("/customer-edit")
    public ModelAndView customerEdit(@RequestParam(required = false) Long id) {
        ModelAndView modelAndView = new ModelAndView("admin/customer/edit");
        modelAndView.addObject("customer",customerService.findById(id));
        return modelAndView;
    }


}
