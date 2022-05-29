package com.autogroup.AutoService.controller;

import com.autogroup.AutoService.model.ApplicationP;
import com.autogroup.AutoService.model.Driver;
import com.autogroup.AutoService.model.Type;
import com.autogroup.AutoService.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DriverController {

    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @RequestMapping(value = {"/driverList"},method = RequestMethod.GET)
    public String driverList(Model model){
        Iterable<Driver> drivers = driverService.getAllDriver();
        model.addAttribute("drivers", drivers);

        return "driverList";
    }

    @RequestMapping(value = {"/driverInfo/{id}"},method = RequestMethod.GET)
    public String driverInfo(Model model, @PathVariable Long id){
        try {
            Driver driver = driverService.getById(id);
            model.addAttribute("driver",driver);
        }catch (Exception ex){
            model.addAttribute("errorMessage","not found");
        }
        return "driverInfo";
    }

    @RequestMapping(value = {"/addDriver"},method = RequestMethod.GET)
    public String showAddDriverPage(Model model){

        Driver driver = new Driver();
        model.addAttribute("driver",driver);

        return "addDriver";
    }

    @RequestMapping(value = {"/addDriver"},method = RequestMethod.POST)
    public String saveDriver(Model model, @ModelAttribute("driver") Driver driver){

        try {
            if(driver != null){
                driverService.addDriver(driver);
            }
            return "redirect:/driverList";
        }catch (Exception ex){
            model.addAttribute("errorMessage","errorMessage");
            return "addDriver";
        }
    }

    @RequestMapping(value = {"driverInfo/{id}/delete"},method = RequestMethod.GET)
    public String showDeleteDriverById(Model model,@PathVariable Long id){
        try {
            Driver driver = driverService.getById(id);
            model.addAttribute("allowDelete",true);
            model.addAttribute("driver",driver);
        }catch (Exception ex){
            model.addAttribute("errorMessage","not fount");
        }
        return "driverInfo";
    }

    @RequestMapping(value = {"driverInfo/{id}/delete"},method = RequestMethod.POST)
    public String deleteDriverById(Model model, @PathVariable Long id){
        try {
            driverService.deleteDriver(id);
            return "redirect:/driverList";
        }catch (Exception ex){
            model.addAttribute("errorMessage","errorMessage");
            return "driverInfo";
        }
    }
}
