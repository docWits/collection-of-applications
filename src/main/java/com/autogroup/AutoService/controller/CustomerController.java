package com.autogroup.AutoService.controller;

import com.autogroup.AutoService.model.Auto;
import com.autogroup.AutoService.model.Customer;
import com.autogroup.AutoService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = {"/customerList"},method = RequestMethod.GET)
    public String customerList(Model model){
        Iterable<Customer> customers = customerService.getAllCustomer();
        model.addAttribute("customers", customers);

        return "customerList";
    }

    @RequestMapping(value = {"/customerInfo/{id}"},method = RequestMethod.GET)
    public String customerInfo(Model model, @PathVariable Long id){
        try {
            Customer customer = customerService.getById(id);
            model.addAttribute("customer",customer);
        }catch (Exception ex){
            model.addAttribute("errorMessage","not found");
        }
        return "customerInfo";
    }

    @RequestMapping(value = {"/addCustomer"},method = RequestMethod.GET)
    public String showAddCustomerPage(Model model){

        Customer customer = new Customer();
        model.addAttribute("customer",customer);

        return "addCustomer";
    }

    @RequestMapping(value = {"/addCustomer"},method = RequestMethod.POST)
    public String saveCustomer(Model model, @ModelAttribute("customer") Customer customer){

        try {
            if(customer != null){
                customerService.addCustomer(customer);
            }
            return "redirect:/customerList";
        }catch (Exception ex){
            model.addAttribute("errorMessage","errorMessage");
            return "addCustomer";
        }
    }

    @RequestMapping(value = {"customerInfo/{id}/delete"},method = RequestMethod.GET)
    public String showDeleteCustomerById(Model model,@PathVariable Long id){
        try {
            Customer customer = customerService.getById(id);
            model.addAttribute("allowDelete",true);
            model.addAttribute("customer",customer);
        }catch (Exception ex){
            model.addAttribute("errorMessage","not fount");
        }
        return "customerInfo";
    }

    @RequestMapping(value = {"customerInfo/{id}/delete"},method = RequestMethod.POST)
    public String deleteCustomerById(Model model, @PathVariable Long id){
        try {
            customerService.deleteCustomer(id);
            return "redirect:/index";
        }catch (Exception ex){
            model.addAttribute("errorMessage","errorMessage");
            return "customerInfo";
        }
    }
}
