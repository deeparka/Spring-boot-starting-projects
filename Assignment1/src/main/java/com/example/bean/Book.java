package com.example.bean;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
@EnableTransactionManagement
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "desc")
	private String description;
	
	@Column(name = "pub_year")
	private int publishedYear;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getPublishedYear() {
		return publishedYear;
	}
	
	public void setpublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}
}
