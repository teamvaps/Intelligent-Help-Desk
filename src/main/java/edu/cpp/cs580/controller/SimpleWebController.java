package edu.cpp.cs580.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.cpp.cs580.data.Customer;
import edu.cpp.cs580.data.Usertermination;

@Controller
public class SimpleWebController {
	
    Logger log = LoggerFactory.getLogger(this.getClass());
    
    @RequestMapping(value="/form", method=RequestMethod.GET)
    public String customerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "form";
    }
    @RequestMapping(value="/UserTermination", method=RequestMethod.GET)
    public String UserTerminationForm(Model model) {
        model.addAttribute("Usertermination", new Usertermination());
        return "UserTermination";
    }
  
    @RequestMapping(value="/form", method=RequestMethod.POST)
    public String customerSubmit(@ModelAttribute Customer customer, Model model) {
          
        model.addAttribute("customer", customer);
        String info = String.format("Customer Submission: id = %d, firstname = %s, lastname = %s", 
                                        customer.getId(), customer.getFirstname(), customer.getLastname());
        log.info(info);
          
        return "result";
    }
}
