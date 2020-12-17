package com.ashokit.controller;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.entity.Contact;
import com.ashokit.service.IContactService;

@Controller
@PropertySource("application.properties")
//@PropertySources(value = {@PropertySource("classpath:application.properties")})
public class ContactController {
	
	//private static final Logger logger = LoggerFactory.getLogger(ContactController.class);
	@Autowired
	private IContactService service;
	
	@Autowired
	private Environment env;
	
	@Value("${phnbook.message.failedmsg}")
	private String serverprot;
	
	
	@GetMapping("/welcome")
	public String showFormPage(@ModelAttribute("contactsave")Contact model, Map<String, Object> map) {
		//logger.info("GetRequest with trying to loading Formpage");
		return "form_page";
	}
	
	@PostMapping("/savedata")
	public String saveContactData(Map<String, Object>map,@ModelAttribute("contactsave")Contact entity) {
	//	logger.info("Data Entered by End User came to PostMapping method");
	//	logger.info(env.getRequiredProperty("server.port"));
         //boolean issaved=service.saveData(entity);
		  int issaved=service.saveData(entity);
		  
		  Contact entity1=service.getContactDetailsById(issaved);
		  map.put("entity", entity1);
       //  logger.info("Given Data saved or Not is there in issaved");
		/*  if(issaved) {
			  redirect.addFlashAttribute("contactId",env.getRequiredProperty("phnbook.message.successmsg"));
		  }
		  else {
			  redirect.addFlashAttribute("contactId",env.getRequiredProperty("phnbook.message.failedmsg"));
		  }*/
		//return "redirect:welcome";
		  return "getbyid";
	}
	
	@GetMapping("/getall")
	public String getAllContactDetails(Map<String, Object>map) {
		List<Contact> con=service.getAllDetails();
		map.put("alldetails", con);
		return "result_page";
	}
	

	@GetMapping("/editdetails")
	public String showEditForm(@RequestParam Integer contactId,@ModelAttribute("contactedit")Contact cnt) {
		Contact entity=service.getContactDetailsById(contactId);
		  BeanUtils.copyProperties(entity, cnt);
		return "edit_page";
	}
	
	/*@PostMapping("/editdata")
	public String updateContactDetails(RedirectAttributes redirect,@ModelAttribute("contactedit")Contact cont) {
		 boolean isupdated=service.saveData(cont);
	     if(isupdated) {
	    	 redirect.addFlashAttribute("conupdate",env.getRequiredProperty("phnbook.message.updatesuccessmsg") );
	     }
	     else {
	    	 redirect.addFlashAttribute("conupdate",env.getRequiredProperty("phnbook.message.updatesfailmsg"));
	     }
		return "redirect:welcome";
	}
	
	@GetMapping("/deletedetails")
	public String deleteContactDetails(@RequestParam Integer contactId) {
		Contact cnt =service.getContactDetailsById(contactId);
		if(cnt!=null) {
			service.removeConatctDetails(contactId);
		}
		return "redirect:getall";
	}
	*/	
}//class
