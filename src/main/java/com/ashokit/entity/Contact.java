package com.ashokit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contact implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contact_id",length = 10)
	private Integer contactId;
	
	@Column(name = "contact_name",length = 15)
	private String contactName;
	
	@Column(name = "contact_number")
	private Long contatcNumber;
	
	@Column(name = "contact_email")
	private String contactEmail;
	
	@Column(name = "active_sw")
	private String activeSw;

}
