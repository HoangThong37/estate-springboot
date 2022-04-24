package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.reponse.BuildingTypeReponse;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.service.IBuildingService;

import com.laptrinhjavaweb.service.IDistrictService;
import com.laptrinhjavaweb.service.IUserService;

import com.laptrinhjavaweb.service.impl.BuildingTypesService;
import com.laptrinhjavaweb.utils.MessageUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class BuildingController {
    @Autowired
    private IBuildingService buildingService;

    @Autowired
    private IUserService userService;

    @Autowired
    private MessageUtils messageUtil;

    @Autowired
    private IDistrictService districtService;

    @Autowired
    private BuildingTypesService buildingTypesService;

   @Autowired
   private BuildingConverter buildingConverter;


    @GetMapping("/building-list")
    public ModelAndView buildingList(@ModelAttribute("modelSearch") BuildingSearchRequest buildingSearchRequest,
                                     @RequestParam(required = false) Map<String, Object> params,
                                     @RequestParam(required = false) List<String> types) {
        ModelAndView mav = new ModelAndView("admin/building/list");
        mav.addObject("modelSearch", buildingConverter.convertToBuildingSearchRequest(buildingSearchRequest));
        mav.addObject("modelDistrict",districtService.getAll());
        mav.addObject("modelStaff",userService.getAllStaff());
        mav.addObject("modelBuildingType",buildingTypesService.getAll());
        mav.addObject("modelBuildings",buildingService.findAll(params,types));
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
    }

//    private void initMessageResponse(ModelAndView mav, HttpServletRequest request) {
//        String message = request.getParameter("message");
//        if (message != null && StringUtils.isNotEmpty(message)) {
//            Map<String, String> messageMap = messageUtil.getMessage(message);
//            mav.addObject(SystemConstant.ALERT, messageMap.get(SystemConstant.ALERT));
//            mav.addObject(SystemConstant.MESSAGE_RESPONSE, messageMap.get(SystemConstant.MESSAGE_RESPONSE));
//        }
//    }
}
