package com.ashish.jwt.token.db.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Where;


/**
 * The persistent class for the school_address database table.
 * 
 */
@Entity
@Table(name="school_address")
@NamedQuery(name="SchoolAddress.findAll", query="SELECT b FROM SchoolAddress b")
@Where(clause="delete_ind is NULL or delete_ind='N'")
public class SchoolAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="company_addr_id")
	private int companyAddrId;

	@Column(name="create_date", updatable=false)
	private Timestamp createDate;

	@Column(name="create_user")
	private String createUser;

	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;

	@Column(name="update_date", insertable=false, updatable=false)
	private Timestamp updateDate;

	@Column(name="update_user")
	private String updateUser;

	@Column(name="delete_ind")
	private String deleteInd;
	
	//bi-directional many-to-one association to Address
	@ManyToOne(cascade={CascadeType.REMOVE,CascadeType.MERGE})
	@JoinColumn(name="address_id")
	private Address address;

	//bi-directional many-to-one association to SchoolMaster
	@ManyToOne(cascade={CascadeType.REMOVE,CascadeType.MERGE})
	@JoinColumn(name="school_id")
	private SchoolMaster schoolMaster;

	public SchoolAddress() {
	}

	public int getCompanyAddrId() {
		return this.companyAddrId;
	}

	public void setCompanyAddrId(int companyAddrId) {
		this.companyAddrId = companyAddrId;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public SchoolMaster getSchoolMaster() {
		return schoolMaster;
	}

	public void setSchoolMaster(SchoolMaster schoolMaster) {
		this.schoolMaster = schoolMaster;
	}

	@Override
	public boolean equals(Object object) {
		boolean result = false;
		if (object == null || object.getClass() != getClass()) {
			result = false;
		} else {
			SchoolAddress ba = (SchoolAddress) object;
			if (this.getAddress().getAddressId() == ba.getAddress().getAddressId()) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 7 * hash + this.getAddress().getAddressId();
		return hash;
	}
	
	public String getDeleteInd() {
		return deleteInd;
	}

	public void setDeleteInd(String deleteInd) {
		this.deleteInd = deleteInd;
	}

	/*
	 * public void addSchoolMastersIntoSchoolAddress(SchoolMaster schoolMaster) {
	 * if(schoolMaster != null) { List<SchoolAddress> schoolAddresses =
	 * schoolMaster.getSchoolAddresses(); if(schoolAddresses != null &&
	 * schoolAddresses.size() > 0) { for(SchoolAddress schoolAddres :
	 * schoolAddresses) { schoolAddres.setSchoolMaster(schoolMaster); } } } }
	 */
	
	@PreUpdate
	@PrePersist
	public void updateTimeStamps() {
	    updateDate = new Timestamp(System.currentTimeMillis());
	    if (createDate == null) {
	    	createDate = new Timestamp(System.currentTimeMillis());
	    }
	}
}