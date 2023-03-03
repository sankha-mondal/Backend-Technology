package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Paytm;
import com.service.PaytmService;

@RestController
@RequestMapping("paytm")
public class PaytmController {

	
	@Autowired
	PaytmService paytmService;
	
//============================================================================================================================================
	
		//  Retrieve account operation:- 	Op:1
		
		//  http://localhost:8484/paytm/findAccount/{pid}
		@GetMapping(value = "findAccount/{pid}")
		public String findAccountDetails(@PathVariable("pid") int pid) {
		
			return paytmService.findAccounBalance(pid);	
		}
	
	
	
//============================================================================================================================================
	
		//  Create account operation:-	Op:2
		
		//  http://localhost:8484/paytm/create
		@PostMapping(value = "create",consumes = MediaType.APPLICATION_JSON_VALUE)
		public String createPaytmAccount(@RequestBody Paytm paytm) {
			
			System.out.println(paytm.getAccno());
			return paytmService.createPaytmAccount(paytm);
		}
		
		
//============================================================================================================================================
		
		//  Update Operation:-   Op:4
		
		//  http://localhost:8484/paytm/updatePaytmAccount
		@PutMapping(value = "updatePaytmAccount",consumes = MediaType.APPLICATION_JSON_VALUE)
		public String updatePaytmAccount(@RequestBody Paytm paytm) {
			return paytmService.updatePaytmAccount(paytm);
		}
			
			
//============================================================================================================================================
		
		//  Delete Operation:-   Op:5
		
		//  http://localhost:8484/paytm/deletePaytmAccount/{pid}
		@DeleteMapping(value = "deletePaytmAccount/{pid}")
		public String deletePaytmAccount(@PathVariable("pid") int pid) {
			return paytmService.deletePaytmAccount(pid);
		}
				
			
		
//============================================================================================================================================
//============================================================================================================================================
	
		
		
}
