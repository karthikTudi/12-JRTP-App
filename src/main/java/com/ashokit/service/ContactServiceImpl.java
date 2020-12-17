package com.ashokit.service;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import com.ashokit.entity.Contact;
import com.ashokit.repo.ContactRepository;

@Service	
public class ContactServiceImpl implements IContactService {
	
	@Autowired
	private ContactRepository contactrepo;
	
	@Autowired
	private JdbcTemplate jt;
	
	/*@Autowired
	private DriverManagerDataSource dms;*/
	
	/*@Override
	public boolean saveData(Contact entity){
		entity.setActiveSw("Y");
		Contact e= contactrepo.save(entity);
		return e.getContactId()!=null;
	}*/

	@Override
	public int saveData(Contact entity){
		entity.setActiveSw("Y");
		Contact e= contactrepo.save(entity);
		return e.getContactId();
	}
	@Override
	public List<Contact> getAllDetails() {
		return  contactrepo.findAll();
	}
	
	@Override
	public Contact getContactDetailsById(int id) {
		Optional<Contact> cnt = contactrepo.findById(id);
		if(cnt.isPresent()) {
			return cnt.get();
		}
		return null;
	}
	
	@Override
	public void removeConatctDetails(Integer id) {
		contactrepo.deleteById(id);
		
	}
}
