package com.ashokit.service;

import java.util.List;

import com.ashokit.entity.Contact;

public interface IContactService {
	
	//boolean saveData(Contact entity);
	List<Contact> getAllDetails();
    Contact getContactDetailsById(int id);
    void removeConatctDetails(Integer id);
    public int saveData(Contact entity);
}
