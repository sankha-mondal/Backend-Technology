package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.entity.Address;
import com.service.AddressService;

@RestController
@RequestMapping("address")	// http://localhost:8383/address/
@CrossOrigin			    // Enable cors policies 
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	//  Retrieve Operation:-
	
	// http://localhost:8383/address/findAllAddress
	@GetMapping(value = "findAllAddress",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Address> findAllAddress() {
		return addressService.findAllAddress();
	}
	
	
	//  Insert Operation:-
	
	// http://localhost:8383/address/storeAddress
	@PostMapping(value = "storeAddress",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeAddress(@RequestBody Address address) {
		return addressService.storeAddress(address);
	}
	
	//  Update Operation:-
	
	//  http://localhost:8383/address/updateAddress
	@PutMapping(value = "updateAddress",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateAddress(@RequestBody Address address) {
		return addressService.updateAddress(address);
	}
	
	
	
	//  Delete Operation:-
	
	//  http://localhost:8383/address/deleteAddress/{id}
	@DeleteMapping(value = "deleteAddress/{id}")
	public String deleteAddress(@PathVariable("id") int id) {
		return addressService.deleteAddress(id);
	}

	
	
}
