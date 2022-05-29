package com.autogroup.AutoService.controller;

import com.autogroup.AutoService.model.ApplicationP;
import com.autogroup.AutoService.model.ApplicationT;
import com.autogroup.AutoService.service.ApplicationPService;
import com.autogroup.AutoService.service.ApplicationTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ApplicationTController {

    private final ApplicationTService applicationTService;

    @Autowired
    public ApplicationTController(ApplicationTService applicationTService) {
        this.applicationTService = applicationTService;
    }

    @RequestMapping(value = {"/applicationTList"},method = RequestMethod.GET)
    public String applicationTList(Model model){
        Iterable<ApplicationT> applicationTS = applicationTService.getAllApplicationT();
        model.addAttribute("applicationT", applicationTS);

        return "applicationPList";
    }

    @RequestMapping(value = {"/applicationTInfo/{id}"},method = RequestMethod.GET)
    public String applicationTInfo(Model model, @PathVariable Long id){
        try {
            ApplicationT applicationT = applicationTService.getById(id);
            model.addAttribute("applicationT",applicationT);
        }catch (Exception ex){
            model.addAttribute("errorMessage","not found");
        }
        return "applicationTInfo";
    }

    @RequestMapping(value = {"/addApplicationT"},method = RequestMethod.GET)
    public String showAddApplicationTPage(Model model){

        ApplicationT applicationT = new ApplicationT();
        model.addAttribute("applicationT",applicationT);

        return "addApplicationT";
    }


    @RequestMapping(value = {"/addApplicationT"},method = RequestMethod.POST)
    public String saveApplication(Model model, @ModelAttribute("applicationT") ApplicationT applicationT){

        try {
            if(applicationT != null){
                applicationTService.addApplicationT(applicationT);
            }
            return "redirect:/index";
        }catch (Exception ex){
            model.addAttribute("errorMessage","errorMessage");
            return "addApplicationT";
        }
    }



    @RequestMapping(value = {"applicationTInfo/{id}/delete"},method = RequestMethod.GET)
    public String showDeleteApplicationById(Model model,@PathVariable Long id){
        try {
            ApplicationT applicationT = applicationTService.getById(id);
            model.addAttribute("allowDelete",true);
            model.addAttribute("application",applicationT);
        }catch (Exception ex){
            model.addAttribute("errorMessage","not fount");
        }
        return "applicationTInfo";
    }

    @RequestMapping(value = {"applicationTInfo/{id}/delete"},method = RequestMethod.POST)
    public String deleteApplicationTById(Model model, @PathVariable Long id){
        try {
            applicationTService.deleteApplicationT(id);
            return "redirect:/applicationPList";
        }catch (Exception ex){
            model.addAttribute("errorMessage","errorMessage");
            return "applicationPInfo";
        }
    }
}
