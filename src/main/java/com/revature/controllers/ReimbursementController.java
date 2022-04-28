package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbursementStatusRepository;
import com.revature.models.ErsUser;
import com.revature.security.UserService;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;


@Controller
@RequestMapping("/reimbursements")
public class ReimbursementController {
	
	@Autowired
	ReimbursementService reimService; 
	
	@Autowired
	ReimbursementStatusRepository reimbStatusRepo;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/reimbrequest")
	public String reimbursementRequestForm(Model model) {
		
		Reimbursement aReimbursement = new Reimbursement();
		List<ErsUser> ersUsers = userService.getAll();
		
		model.addAttribute("reimbursement", aReimbursement);
		model.addAttribute("allErsUsers", ersUsers);
		 
		/*
		 * DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); String dateString
		 * = dateFormat.format(new Date()); model.addAttribute("eventDate", dateString);
		 */
		 
		 
		return "reimbursements/reimb-request"; //return the reimbursement-request form 
	}
	
	
	@PostMapping("save")
	public String createReimbursmentRequest(Reimbursement reimbursement) {
		//save to the database using a reimbursement CRUD repository
		reimService.save(reimbursement);
		//use a redirect to prevent duplicate submission 
		return "redirect:/reimbursements/list";
	}
	
	
	@GetMapping("/update")
	public String updateReimbursementRequestForm(@RequestParam("id") Integer reimbId, Model model) {
		
		Reimbursement aReimbursement = reimService.findByReimbId(reimbId);
		model.addAttribute("reimbursement", aReimbursement);
		return "reimbursements/update";
	}
	
	
	@GetMapping("/delete")
	public String deleteAreimbursementRequest(@RequestParam("id") Integer reimbId) {
		
		Reimbursement reimbursement = reimService.findByReimbId(reimbId);
		reimService.delete(reimbursement);
		return "redirect:/reimbursements/list";
	}
	

	  @GetMapping("/list") 
	  public String displayReimbursementRequestList(Model model) {
	  List<Reimbursement> aReimbursement = reimService.getAll();
	  model.addAttribute("reimbursement",aReimbursement); 
	  return "reimbursements/reimb-list"; 
	}
	  
	  @GetMapping("/displaydata")
		public String displayReimbursementStatusData(Model model) throws JsonProcessingException {
			
			List<Reimbursement> reimbursement = reimService.getAll();
			model.addAttribute("reimbursementStatusList", reimbursement);
			
			List<com.revature.dto.DataChart> ReimbursementStatusData = reimbStatusRepo.getReimbursementStatusCount();
			
			// Lets convert ReimbursementStatusData object into a json structure for use in javaScript
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonString = objectMapper.writeValueAsString(ReimbursementStatusData);
			
			model.addAttribute("reimbursementStatusCount", jsonString);
			
			
			return "reimbursements/reimb-status-data";
			
		}
	  
	  @RequestMapping(path = {"/","/search"})
	  public String home(Model model, String keyword) {
		  if(keyword!=null) {
			   List<Reimbursement> reimbursement = reimService.findByReimbStatus(keyword);
			   model.addAttribute("listreimb", reimbursement);
			  }else {
			  List<Reimbursement> listReimb = reimService.getAll();
			  model.addAttribute("listreimb", listReimb);
			  }
			  return "/reimbursements/search";
			 }
}
