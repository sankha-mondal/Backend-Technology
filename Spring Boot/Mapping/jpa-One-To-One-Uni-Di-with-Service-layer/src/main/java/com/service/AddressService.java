package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.entity.Address;
import com.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	AddressRepository addressRepository;
	
	//  Retrieve Operation:-
	
	public List<Address> findAllAddress() {
		return addressRepository.findAll();
	}
	
	//  Insert Operation:-
	
	public String storeAddress(Address address) {
		boolean result = addressRepository.existsById(address.getId());
			if(result) {
				return "Address didn't store. id must be unique";
			} else {
				addressRepository.save(address);
				return "Address stored successfully";
			}
	}
	
	//  Update Operation:-
	
	public String updateAddress(Address address) {
		Optional<Address> op =  addressRepository.findById(address.getId());
			if(op.isPresent()) {
					Address a = op.get();
					a.setCity(address.getCity());
					addressRepository.saveAndFlush(a);
					return "Address updated successfully";
			} else {
				return "Address not present";
			}
		}
	
	
	//  Delete Operation:-
	
	public String deleteAddress(int id) {
		Optional<Address> op =  addressRepository.findById(id);
			if(op.isPresent()) {
				Address a = op.get();
					addressRepository.delete(a);
					return "Address deleted successfully";
			} else {
				return "Address not present";
			}
		}
	
		

}
