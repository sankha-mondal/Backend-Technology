package com.controller;

import java.util.List;

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

import com.bean.Account;
import com.service.AccountService;



@RestController
@RequestMapping("account")
public class AccountController {

	@Autowired
	AccountService accountService;
	
//============================================================================================================================================
	
		//  Create account operation:-	Op:1
		
		//  http://localhost:8383/account/create
		@PostMapping(value = "create",consumes = MediaType.APPLICATION_JSON_VALUE)
		public String createAccount(@RequestBody Account account) {
			System.out.println(account.getAccno());
			return accountService.createAccount(account);
		}
	

	
//============================================================================================================================================
		
		//  Retrieve Operation:-  Op:2
		
		// 	http://localhost:8383/account/findAll
		@GetMapping(value = "findAll",produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Account> findAllUser() {
			return accountService.findAllAccount();
		}

			
			
//============================================================================================================================================
			
		//  Retrieve account operation:-	Op:3
		
		//  http://localhost:8383/account/findAccountDetails/{accno}
		@GetMapping(value = "findAccountDetails/{accno}")
		public String findAccountDetails(@PathVariable("accno") int accno) {
			return accountService.getAccountDetails(accno);
		}
	
	
	
//============================================================================================================================================
	
	
		//  Update Operation:-   Op:4
		
		//  http://localhost:8383/account/updateAccount
		@PutMapping(value = "updateAccount",consumes = MediaType.APPLICATION_JSON_VALUE)
		public String updateAccount(@RequestBody Account account) {
			return accountService.updateAccount(account);
		}
		
		
//============================================================================================================================================
		
		//  Delete Operation:-   Op:5
		
		//  http://localhost:8383/account/deleteAccount/{accNo}
		@DeleteMapping(value = "deleteAccount/{accNo}")
		public String deleteAccount(@PathVariable("accNo") int accNo) {
			return accountService.deleteAccount(accNo);
		}
				
			
		
//============================================================================================================================================
//============================================================================================================================================
	
	
}
