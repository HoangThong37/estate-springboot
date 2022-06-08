package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.security.utils.SecurityUtils;

import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.IDistrictService;
import com.laptrinhjavaweb.service.IUserService;

import com.laptrinhjavaweb.service.impl.BuildingTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class BuildingController {
    @Autowired
    private IBuildingService buildingService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IDistrictService districtService;

    @Autowired
    private BuildingTypesService buildingTypesService;

    @Autowired
    private BuildingConverter buildingConverter;

    @GetMapping("/building-list")
    public ModelAndView buildingList(@ModelAttribute("modelSearch") BuildingSearchRequest buildingSearchRequest) {
        ModelAndView modelAndView = new ModelAndView("admin/building/list");

        // check role is Staff
        if (!SecurityUtils.getAuthorities().contains(SystemConstant.ADMIN_ROLE)) { // nếu kp là admin thì -> staff
            Long staffId = SecurityUtils.getPrincipal().getId();
            buildingSearchRequest.setStaffID(staffId);
        }
//        modelAndView.addObject("modelSearch",buildingConverter.convertToBuildingSearchRequest(buildingSearchRequest));
        modelAndView.addObject("modelDistrict",districtService.getAll());
        modelAndView.addObject("modelStaff",userService.getAllStaff());
        modelAndView.addObject("modelBuildingType",buildingTypesService.getAll());
        modelAndView.addObject("modelBuildings",buildingService.findAll(buildingSearchRequest));
        return modelAndView;
    }

    @GetMapping("/building-edit")
    public  ModelAndView buildingEdit(@RequestParam(name = "buildingid",required = false) Long id){

        ModelAndView modelAndView = new ModelAndView("admin/building/edit");
        if(id!=null){
            modelAndView.addObject("modelDistrict",districtService.getDistrictByBuilding(buildingService.findById(id)));
            modelAndView.addObject("modelBuildingType",buildingTypesService.getAllByBuilding(buildingService.findById(id)));
            modelAndView.addObject("modelBuilding",buildingService.findById(id));
        }else{
            modelAndView.addObject("modelDistrict",districtService.getAll());
            modelAndView.addObject("modelBuildingType",buildingTypesService.getAll());
            modelAndView.addObject("modelBuilding", new BuildingDTO());
        }
        return modelAndView;
    }


   /* @GetMapping("/building-list")
    public ModelAndView buildingList(@ModelAttribute("modelSearch") BuildingSearchRequest buildingSearchRequest) {
        ModelAndView mav = new ModelAndView("admin/building/list");

        // check role is Staff
        if (!SecurityUtils.getAuthorities().contains(SystemConstant.ADMIN_ROLE)) { // nếu kp là admin thì -> staff
            Long staffId = SecurityUtils.getPrincipal().getId();
            buildingSearchRequest.setStaffID(staffId);
        }

        mav.addObject("modelDistrict",districtService.getAll());
        mav.addObject("modelStaff",userService.getAllStaff());
        mav.addObject("modelBuildingType",buildingTypesService.getAll());
        mav.addObject("modelBuildings",buildingService.findAll(buildingSearchRequest));
        return mav;
    }

    @GetMapping("/building-edit")
    public  ModelAndView buildingEdit(@RequestParam(name = "buildingid",required = false) Long id){
        ModelAndView modelAndView = new ModelAndView("admin/building/edit");
        if(id != null) {
            modelAndView.addObject("modelDistrict",districtService.getDistrictByBuilding(buildingService.findById(id)));
            modelAndView.addObject("modelBuildingType",buildingTypesService.getAllByBuilding(buildingService.findById(id)));
            modelAndView.addObject("modelBuilding",buildingService.findById(id));
        }
        else {
            modelAndView.addObject("modelDistrict",districtService.getAll());
            modelAndView.addObject("modelBuildingType",buildingTypesService.getAll());
            modelAndView.addObject("modelBuilding",new BuildingDTO());
      }
//
        return modelAndView;
    }*/

//    private void initMessageResponse(ModelAndView mav, HttpServletRequest request) {
//        String message = request.getParameter("message");
//        if (message != null && StringUtils.isNotEmpty(message)) {
//            Map<String, String> messageMap = messageUtil.getMessage(message);
//            mav.addObject(SystemConstant.ALERT, messageMap.get(SystemConstant.ALERT));
//            mav.addObject(SystemConstant.MESSAGE_RESPONSE, messageMap.get(SystemConstant.MESSAGE_RESPONSE));
//        }
//    }
}
