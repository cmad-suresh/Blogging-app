package com.library.data.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;


@Entity
@Table(name="BOOKS")

public class Books {
	
	@Id
	/*@GeneratedValue(strategy=GenerationType.SEQUENCE)*/
	@Column(name="ISBN_ID")
	
	private int isbn_id;
	
	@Column(name="TITLE")
	private String title;
	
	/*@Column(name="AUTHOR")
	private Authors author;*/
	/*@Embedded*/
	/*private Authors author;*/
	
	@ElementCollection
	@JoinTable(name="AUTHORS",  joinColumns=@JoinColumn(name="ISBN_No"))
	private List<Authors> listOfAuthors =new ArrayList();
		
	@Column(name="YEAR_of_PUBLISH")
	@Temporal (TemporalType.DATE)
	
	private Date yearofpublish;
	
	public List<Authors> getListOfAuthors() {
		return listOfAuthors;
	}
	public void setListOfAuthors(List<Authors> listOfAuthors) {
		this.listOfAuthors = listOfAuthors;
	}
	@Column(name="EDITION")
	private String edition_no;
	
	public Date getYearofpublish() {
		return yearofpublish;
	}
	public void setYearofpublish(Date yearofpublish) {
		this.yearofpublish = yearofpublish;
	}
	public String getEdition_no() {
		return edition_no;
	}
	public void setEdition_no(String edition_no) {
		this.edition_no = edition_no;
	}
	public int getIsbn_id() {
		return isbn_id;
	}
	public void setIsbn_id(int isbn_id) {
		this.isbn_id = isbn_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
		
}
