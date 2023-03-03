package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Account;
import com.dao.AccountDao;
import java.util.List;

@Service
public class AccountService {

	@Autowired
	AccountDao accountDao;
	
//============================================================================================================================================

		//  Create account operation:-	Op:1
		
		public String createAccount(Account account) {
			boolean res = accountDao.existsById(account.getAccno());
			if(res) {
				return "Account didn't create...";
			} else {
				accountDao.save(account);
				return "Account created successfully...";
			}
		}
	
	
//============================================================================================================================================
		
			//  Retrieve Operation:- 	Op:2
		
			public List<Account> findAllAccount() {
				return accountDao.findAll();
			}
			
			
//============================================================================================================================================
			
			
		//  Retrieve account operation:-	Op:3
	
		public String getAccountDetails(int accno) {
			Optional<Account> op = accountDao.findById(accno);
			if(op.isPresent()) {
				Account acc = op.get();
				return "You name is "+acc.getName()+" and your balance amount is "+acc.getAmount();
			}else {
				return "Account number not present...";
			}
		}
		
		
//============================================================================================================================================
		
		
		//  Update Operation:-    Op:4
		
		public String updateAccount(Account account) {
			
			Optional<Account> op =  accountDao.findById(account.getAccno());
				if(op.isPresent()) {
					Account a = op.get();
					a.setAccno(account.getAccno());
					a.setName(account.getName());
					a.setAmount(account.getAmount());
					accountDao.saveAndFlush(a);
					return "Account details updated successfully...";
				} else {
					return "Account not present...";
				}
		}
		
		
		
//============================================================================================================================================
		
		
		//  Delete Operation:-    Op:5
		
		public String deleteAccount(int accno) {
			
			Optional<Account> op =  accountDao.findById(accno);
				if(op.isPresent()) {
						Account a = op.get();
						accountDao.delete(a);
						return "Account details deleted successfully...";
				} else {
					return "Account not present...";
				}
		}

		
		
//============================================================================================================================================
//============================================================================================================================================
		
		
}

