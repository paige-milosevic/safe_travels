package com.codingdojo.safetravels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="expenses")
public class Expense {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotBlank
	    @Size(min = 1, max = 200, message="Expense name is required!")
	    private String expenseName;
	    
	    @NotBlank
	    @Size(min = 1, max = 200, message="Vendor is required!")
	    private String vendor;
	    
	    @NotBlank
	    @Size(min = 1, max = 400, message="Description is required!")
	    private String description;
	    
	    @NotNull(message="Amount is required!")
	    @Min(value = 0, message="Amount must be greater than zero!")
	    private Double ammount;

	    
	    // This will not allow the createdAt column to be updated after creation
	    @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
	    
	    @PrePersist
	    protected void onCreate() {
	    	this.createdAt = new Date();
	    }
	    
	    @PreUpdate
	    protected void onUpdate() {
	    	this.updatedAt = new Date();
	    }
	    
	    // Constructor

		public Expense() {
		}
		
		public Expense(String expenseName, String vendor, Double ammount, String description) {
			this.expenseName = expenseName;
			this.vendor = vendor;
			this.ammount = ammount;
			this.description = description;
		}
		
		// Getters & Setters

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getExpenseName() {
			return expenseName;
		}

		public void setExpenseName(String expenseName) {
			this.expenseName = expenseName;
		}

		public String getVendor() {
			return vendor;
		}

		public void setVendor(String vendor) {
			this.vendor = vendor;
		}

		public Double getAmmount() {
			return ammount;
		}

		public void setAmmount(Double ammount) {
			this.ammount = ammount;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		
		
	    
	    
	
}
