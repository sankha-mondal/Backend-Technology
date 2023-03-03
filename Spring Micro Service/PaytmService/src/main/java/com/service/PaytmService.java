package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bean.Paytm;
import com.dao.PaytmDao;

@Service
public class PaytmService {

	@Autowired
	PaytmDao paytmDao;
	
	@Autowired
	RestTemplate restTemplate;		// RestTemplate provide set of method 
									// which help to call other service or micro service 
	
//============================================================================================================================================

		//  Retrieve account operation:-	Op:1
		
		public String findAccounBalance(int pid) {
				Optional<Paytm> op = paytmDao.findById(pid);
				if(op.isPresent()) {
					Paytm pm  = op.get();
					if(pm.getAccno()==null) {
						return "Paytm account not link with any bank account...";
					} else {
						String result = restTemplate.getForObject("http://ACCOUNT-SERVICE:8383/account/findAccountDetails/"+pm.getAccno(), String.class);
						return result;
					}
				} else {
					return "Paytm account not exists...";
				}
		}
	

//============================================================================================================================================

		//  Create account operation:-	Op:2
		
		public String createPaytmAccount(Paytm paytm) {
			boolean res = paytmDao.existsById(paytm.getAccno());
			if(res) {
				return "Paytm link didn't generated...";
			} else {
				paytmDao.save(paytm);
				return "Paytm link generated...";
			}
		}
		
		
//============================================================================================================================================

		//  Update Operation:-    Op:4
		
		public String updatePaytmAccount(Paytm paytm) {
			
			Optional<Paytm> op =  paytmDao.findById(paytm.getPid());
				if(op.isPresent()) {
					Paytm p = op.get();
					p.setAccno(paytm.getAccno());
					paytmDao.saveAndFlush(p);
					return "Paytm-Account details updated successfully...";
				} else {
					return "Paytm-Account not present...";
				}
		}
			
			
			
//============================================================================================================================================
		
		//  Delete Operation:-    Op:5
		
		public String deletePaytmAccount(int pid) {
			
			Optional<Paytm> op =  paytmDao.findById(pid);
				if(op.isPresent()) {
						Paytm p = op.get();
						paytmDao.delete(p);
						return "Paytm-Account details deleted successfully...";
				} else {
					return "paytm-Account not present...";
				}
		}

		
		
//============================================================================================================================================
//============================================================================================================================================
		
		
		
		
		
		
		
}
