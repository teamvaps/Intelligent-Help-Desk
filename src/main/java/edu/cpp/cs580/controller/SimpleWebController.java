package edu.cpp.cs580.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import edu.cpp.cs580.data.BitLockerCBoxValues;
import edu.cpp.cs580.data.BitLockerEntity;
import edu.cpp.cs580.data.BitLockerRepository;
import edu.cpp.cs580.data.Bitlocker;
import edu.cpp.cs580.data.Customer;
import edu.cpp.cs580.data.EmpAccSetup;
import edu.cpp.cs580.data.FormUserOffice365;
import edu.cpp.cs580.data.LocComp;
import edu.cpp.cs580.data.NewUserCBoxValues;
import edu.cpp.cs580.data.NewUserEntity;
import edu.cpp.cs580.data.NewUserRepository;
import edu.cpp.cs580.data.Newuser;
import edu.cpp.cs580.data.UserTermCBoxValues;
import edu.cpp.cs580.data.UserTermEntity;
import edu.cpp.cs580.data.UserTermRepository;
import edu.cpp.cs580.data.UserTerminationCBoxValues;
import edu.cpp.cs580.data.UserTerminationEntity;
import edu.cpp.cs580.data.UserTerminationRepository;
import edu.cpp.cs580.data.Userterm;
import edu.cpp.cs580.data.Usertermination;

@Controller
public class SimpleWebController {
	
    Logger log = LoggerFactory.getLogger(this.getClass());
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    UserTerminationRepository userTerminationRepository;
    @Autowired
   BitLockerRepository bitLockerRepository;
    
   
    
    @Autowired
   NewUserRepository newUserRepository;
    
    @Autowired
    UserTermRepository userTermRepository;
    
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
    @RequestMapping(value="/UserTerm", method=RequestMethod.GET)
    public String UserTermForm(Model model) {
        model.addAttribute("Userterm", new Userterm());
        return "UserTerm";
    }
    @RequestMapping(value="/NewUser", method=RequestMethod.GET)
    public String NewUserForm(Model model) {
        model.addAttribute("Newuser", new Newuser());
        return "NewUser";
    }
    
    @RequestMapping(value="/BitLocker", method=RequestMethod.GET)
    public String BitLockerForm(Model model) {
        model.addAttribute("Bitlocker", new Bitlocker());
        return "BitLocker";
    }
   
    @RequestMapping(value="/EmpAccSetup", method=RequestMethod.GET)
    public String EmpAccSetupForm(Model model) {
        model.addAttribute("EmpAccSetup", new EmpAccSetup());
        return "EmpAccSetup";
    }
   
    @RequestMapping(value="/LocComp", method=RequestMethod.GET)
    public String LocCompForm(Model model) {
        model.addAttribute("LocComp", new LocComp());
        return "LocComp";
    }
    
    
    @RequestMapping(value="/FormUserOffice365", method=RequestMethod.GET)
    public String FormUserOffice365Form(Model model) {
        model.addAttribute("FormUserOffice365", new FormUserOffice365());
        return "FormUserOffice365";
    }
  
    @RequestMapping(value="/form", method=RequestMethod.POST)
    public String customerSubmit(@ModelAttribute Customer customer, Model model) {
          
        model.addAttribute("customer", customer);
        String info = String.format("Customer Submission: id = %d, firstname = %s, lastname = %s", 
                                        customer.getId(), customer.getFirstname(), customer.getLastname());
        log.info(info);
          
        return "result";
    }
    @RequestMapping(value="/UserTermination", method=RequestMethod.POST)
    public @ResponseBody String userTerminationSubmit(@ModelAttribute Usertermination userTermination, Model model) {
        UserTerminationEntity userTerminationEntity = new UserTerminationEntity();
        userTerminationEntity.setTech(userTermination.getTech());
        userTerminationEntity.setComputerName(userTermination.getComputerName());
        userTerminationEntity.setDate(userTermination.getDate());
        userTerminationEntity.setTicket(userTermination.getTicket());
        UserTerminationCBoxValues checkBoxes = new UserTerminationCBoxValues(); 
        checkBoxes.setC1(userTermination.getC1());
        checkBoxes.setC2(userTermination.getC2());
        checkBoxes.setC3(userTermination.getC3());
        checkBoxes.setC4(userTermination.getC4());
        checkBoxes.setC5(userTermination.getC5());
        try {
			String JSONCheckboxes = mapper.writeValueAsString(checkBoxes);
			userTerminationEntity.setJsonChecklist(JSONCheckboxes);
			userTerminationRepository.save(userTerminationEntity);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
        return "";
    }
    
    @RequestMapping(value="/UserTerminationSearch", method=RequestMethod.GET)
    public String userTerminationSearchGet(Model model) {
        model.addAttribute("Usertermination", new Usertermination());
        return "UserTerminationSearch";
    }
    @RequestMapping(value="/UserTerminationSearch", method=RequestMethod.POST)
    public String userTerminationSearch(@RequestParam("computerName")String computerName,Model model) {
        Usertermination found = new Usertermination();
    	UserTerminationEntity userTerminationFound = userTerminationRepository.findByComputerName(computerName);
          	UserTerminationCBoxValues userCBoxes;
		try {
			userCBoxes = mapper.readValue(userTerminationFound.getJsonChecklist(), UserTerminationCBoxValues.class);
	    	found.setC1(userCBoxes.getC1());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		found.setComputerName(userTerminationFound.getComputerName());
    	model.addAttribute("Usertermination", found);
    	return "UserTermination";
    }
/*  
 * User Termin form submit
 */
    @RequestMapping(value="/UserTerm", method=RequestMethod.POST)
    public @ResponseBody String userTermSubmit(@ModelAttribute Userterm userTerm, Model model) {
        UserTermEntity userTermEntity = new UserTermEntity();
        userTermEntity.setTech(userTerm.getTech());
        userTermEntity.setComputerName(userTerm.getComputerName());
        userTermEntity.setDate(userTerm.getDate());
        userTermEntity.setTicket(userTerm.getTicket());
        UserTermCBoxValues checkBoxes = new UserTermCBoxValues(); 
        checkBoxes.setC1(userTerm.getC1());
        checkBoxes.setC2(userTerm.getC2());
        checkBoxes.setC3(userTerm.getC3());
        checkBoxes.setC4(userTerm.getC4());
        checkBoxes.setC5(userTerm.getC5());
        try {
			String JSONCheckboxes = mapper.writeValueAsString(checkBoxes);
			userTermEntity.setJsonChecklist(JSONCheckboxes);
			userTermRepository.save(userTermEntity);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
        return "";
    }
    
    /*
     * End of User Term Form Submit
     */
    /*  
     * New User form submit
     */
        @RequestMapping(value="/NewUser", method=RequestMethod.POST)
        public @ResponseBody String newUserSubmit(@ModelAttribute Newuser newUser, Model model) {
            NewUserEntity newUserEntity = new NewUserEntity();
            newUserEntity.setTech(newUser.getTech());
            newUserEntity.setComputerName(newUser.getComputerName());
            newUserEntity.setDate(newUser.getDate());
            newUserEntity.setTicket(newUser.getTicket());
            NewUserCBoxValues checkBoxes = new NewUserCBoxValues(); 
            checkBoxes.setC1(newUser.getC1());
            checkBoxes.setC2(newUser.getC2());
            checkBoxes.setC3(newUser.getC3());
            checkBoxes.setC4(newUser.getC4());
            checkBoxes.setC5(newUser.getC5());
            try {
    			String JSONCheckboxes = mapper.writeValueAsString(checkBoxes);
    			newUserEntity.setJsonChecklist(JSONCheckboxes);
    			newUserRepository.save(newUserEntity);
    			
    		} catch (JsonProcessingException e) {
    			e.printStackTrace();
    		}
            return "";
        }
        
        /*
         * End of User Term Form Submit
         */
        /*
         * End of User Term Form Submit
         */
        /*  
         * New User form submit
         */
            @RequestMapping(value="/BitLocker", method=RequestMethod.POST)
            public @ResponseBody String bitLockerSubmit(@ModelAttribute Bitlocker bitLocker, Model model) {
                BitLockerEntity bitLockerEntity = new BitLockerEntity();
                bitLockerEntity.setTech(bitLocker.getTech());
                bitLockerEntity.setComputerName(bitLocker.getComputerName());
                bitLockerEntity.setDate(bitLocker.getDate());
                bitLockerEntity.setTicket(bitLocker.getTicket());
                BitLockerCBoxValues checkBoxes = new BitLockerCBoxValues(); 
                checkBoxes.setC1(bitLocker.getC1());
                checkBoxes.setC2(bitLocker.getC2());
                checkBoxes.setC3(bitLocker.getC3());
                checkBoxes.setC4(bitLocker.getC4());
                checkBoxes.setC5(bitLocker.getC5());
                checkBoxes.setC6(bitLocker.getC6());
                checkBoxes.setC7(bitLocker.getC7());
                try {
        			String JSONCheckboxes = mapper.writeValueAsString(checkBoxes);
        			bitLockerEntity.setJsonChecklist(JSONCheckboxes);
        			bitLockerRepository.save(bitLockerEntity);
        			
        		} catch (JsonProcessingException e) {
        			e.printStackTrace();
        		}
                return "";
            }
            
            /*
             * End of User Term Form Submit
             */
    }

