package com.autogroup.AutoService.controller;

import com.autogroup.AutoService.model.ApplicationP;
import com.autogroup.AutoService.service.ApplicationPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApplicationPController {

    private final ApplicationPService applicationPService;

    @Autowired
    public ApplicationPController(ApplicationPService applicationPService) {
        this.applicationPService = applicationPService;
    }

    @RequestMapping(value = {"/applicationPList"},method = RequestMethod.GET)
    public String applicationPList(Model model){
        Iterable<ApplicationP> applicationPS = applicationPService.getAllApplicationP();
        model.addAttribute("applicationP", applicationPS);

        return "applicationPList";
    }

    @RequestMapping(value = {"/applicationPInfo/{id}"},method = RequestMethod.GET)
    public String applicationPInfo(Model model, @PathVariable Long id){
        try {
            ApplicationP applicationP = applicationPService.getById(id);
            model.addAttribute("applicationP",applicationP);
        }catch (Exception ex){
            model.addAttribute("errorMessage","not found");
        }
        return "applicationPInfo";
    }

    @RequestMapping(value = {"/addApplicationP"},method = RequestMethod.GET)
    public String showAddApplicationPPage(Model model){

        ApplicationP applicationP = new ApplicationP();
        model.addAttribute("applicationP",applicationP);

        return "addApplicationP";
    }


    @RequestMapping(value = {"/addApplicationP"},method = RequestMethod.POST)
    public String saveApplication(Model model, @ModelAttribute("recordRequest") ApplicationP recordRequest){

        try {
            if(recordRequest != null){
                applicationPService.addApplicationP(recordRequest);
            }
            return "redirect:/index";
        }catch (Exception ex){
            model.addAttribute("errorMessage","errorMessage");
            return "addApplicationP";
        }
    }



    @RequestMapping(value = {"applicationPInfo/{id}/delete"},method = RequestMethod.GET)
    public String showDeleteApplicationById(Model model,@PathVariable Long id){
        try {
            ApplicationP applicationP = applicationPService.getById(id);
            model.addAttribute("allowDelete",true);
            model.addAttribute("application",applicationP);
        }catch (Exception ex){
            model.addAttribute("errorMessage","not fount");
        }
        return "applicationPInfo";
    }

    @RequestMapping(value = {"applicationPInfo/{id}/delete"},method = RequestMethod.POST)
    public String deleteApplicationPById(Model model, @PathVariable Long id){
        try {
            applicationPService.deleteApplicationP(id);
            return "redirect:/applicationPList";
        }catch (Exception ex){
            model.addAttribute("errorMessage","errorMessage");
            return "applicationPInfo";
        }
    }
}
