package com.autogroup.AutoService.controller;

import com.autogroup.AutoService.model.Auto;
import com.autogroup.AutoService.model.Type;
import com.autogroup.AutoService.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AutoController {

    private final AutoService autoService;

    @Autowired
    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @RequestMapping(value = {"/autoList"},method = RequestMethod.GET)
    public String autoList(Model model){
        Iterable<Auto> autos = autoService.getAllAuto();
        model.addAttribute("autos", autos);

        return "autoList";
    }

    @RequestMapping(value = {"/autoInfo/{id}"},method = RequestMethod.GET)
    public String autoInfo(Model model, @PathVariable Long id){
        try {
            Auto auto = autoService.getById(id);
            model.addAttribute("auto",auto);
        }catch (Exception ex){
            model.addAttribute("errorMessage","not found");
        }
        return "autoInfo";
    }

    @RequestMapping(value = {"/addAuto"},method = RequestMethod.GET)
    public String showAddAutoPage(Model model){

        List<String > typeList = Arrays.stream(Type.values()).map(Enum::name).collect(Collectors.toList());
        Auto auto = new Auto();
        model.addAttribute("auto",auto);
        model.addAttribute("typeList",typeList);
        return "addAuto";
    }

    @RequestMapping(value = {"/addAuto"},method = RequestMethod.POST)
    public String saveAuto(Model model, @ModelAttribute("auto") Auto auto){

        try {
            if(auto != null){
                autoService.addAuto(auto);
            }
            return "redirect:/autoList";
        }catch (Exception ex){
            model.addAttribute("errorMessage","errorMessage");
            return "addAuto";
        }
    }

    @RequestMapping(value = {"autoInfo/{id}/delete"},method = RequestMethod.GET)
    public String showDeleteAutoById(Model model,@PathVariable Long id){
        try {
            Auto auto = autoService.getById(id);
            model.addAttribute("allowDelete",true);
            model.addAttribute("auto",auto);
        }catch (Exception ex){
            model.addAttribute("errorMessage","not fount");
        }
        return "autoInfo";
    }

    @RequestMapping(value = {"autoInfo/{id}/delete"},method = RequestMethod.POST)
    public String deleteAutoById(Model model, @PathVariable Long id){
        try {
            autoService.deleteAuto(id);
            return "redirect:/autoList";
        }catch (Exception ex){
            model.addAttribute("errorMessage","errorMessage");
            return "autoInfo";
        }
    }
}
