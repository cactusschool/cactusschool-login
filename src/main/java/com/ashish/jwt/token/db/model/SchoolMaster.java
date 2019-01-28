package com.ashish.jwt.token.db.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Where;


/**
 * The persistent class for the school_master database table.
 * 
 */
@Entity
@Table(name="school_master")
@NamedQuery(name="SchoolMaster.findAll", query="SELECT b FROM SchoolMaster b")
@Where(clause="delete_ind is NULL or delete_ind='N'")
public class SchoolMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="school_id")
	private int schoolId;

	@Column(name="school_name")
	private String schoolName;

	@Column(name="branch_name")
	private String branchName;

	@Column(name="create_date", updatable=false)
	private Timestamp createDate;

	@Column(name="create_user")
	private String createUser;

	private String email1;

	private String email2;
	
	@Column(name="gmail_id")
	private String gmailId;
	
	@Column(name="gmail_password")
	private String gmailPassword;
	
	@Column(name="sms_sender_id")
	private String smsSenderId;

	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	@Column(name="school_code")
	private String schoolCode;

	@Column(name="context_root")
	private String contextRoot;

	@Column(name="db_name")
	private String dbName;
	
	@Column(name="parent_id")
	private int parentId;

	private String phone1;

	private String phone2;

	private String remarks;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;

	@Column(name="update_date", insertable=false, updatable=true)
	private Timestamp updateDate;

	@Column(name="update_user")
	private String updateUser;

	@Column(name="delete_ind")
	private String deleteInd;
	
	@Column(name="delete_reason")
	private String deleteReason;
	
	/*
	 * //bi-directional many-to-one association to SchoolAddress
	 * 
	 * @OneToMany(mappedBy="SchoolMaster", fetch = FetchType.LAZY,
	 * cascade={CascadeType.REMOVE,CascadeType.MERGE,CascadeType.REFRESH})
	 * 
	 * @Where(clause = "delete_ind is null") private List<SchoolAddress>
	 * schoolAddresses;
	 */

	/*
	 * //bi-directional many-to-one association to User
	 * 
	 * @OneToMany(mappedBy="SchoolMaster", fetch = FetchType.LAZY,
	 * cascade={CascadeType.REMOVE,CascadeType.MERGE,CascadeType.REFRESH}) private
	 * List<User> users;
	 * 
	 * //bi-directional many-to-one association to SchoolLicenseDtl
	 * 
	 * @OneToMany(mappedBy="SchoolMaster", fetch = FetchType.LAZY,
	 * cascade={CascadeType.REMOVE,CascadeType.MERGE,CascadeType.REFRESH}) private
	 * List<SchoolLicenseDtl> schoolLicenseDtls;
	 */
		
	public SchoolMaster() {
	}

	public String getDeleteInd() {
		return deleteInd;
	}
	public void setDeleteInd(String deleteInd) {
		this.deleteInd = deleteInd;
	}
	

	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
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

	public String getEmail1() {
		return this.email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return this.email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public int getParentId() {
		return this.parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getPhone1() {
		return this.phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return this.phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	/*
	 * public List<SchoolAddress> getSchoolAddresses() { if(this.schoolAddresses ==
	 * null) { schoolAddresses = new ArrayList<SchoolAddress>(); } return
	 * this.schoolAddresses; }
	 * 
	 * public void setSchoolAddresses(List<SchoolAddress> schoolAddresses) {
	 * this.schoolAddresses = schoolAddresses; }
	 */



	/*
	 * public List<User> getUsers() { return this.users; }
	 * 
	 * public void setUsers(List<User> users) { this.users = users; }
	 */

	public String getContextRoot() {
		return contextRoot;
	}

	public void setContextRoot(String contextRoot) {
		this.contextRoot = contextRoot;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	
	/*
	 * public List<SchoolLicenseDtl> getSchoolLicenseDtls() { return
	 * this.schoolLicenseDtls; }
	 * 
	 * public void setSchoolLicenseDtls(List<SchoolLicenseDtl> schoolLicenseDtls) {
	 * this.schoolLicenseDtls = schoolLicenseDtls; }
	 */

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	/*
	 * public SchoolLicenseDtl addSchoolLicenseDtl(SchoolLicenseDtl
	 * schoolLicenseDtl) { getSchoolLicenseDtls().add(schoolLicenseDtl);
	 * schoolLicenseDtl.setSchoolMaster(this);
	 * 
	 * return schoolLicenseDtl; }
	 * 
	 * public SchoolLicenseDtl removeSchoolLicenseDtl(SchoolLicenseDtl
	 * schoolLicenseDtl) { getSchoolLicenseDtls().remove(schoolLicenseDtl);
	 * schoolLicenseDtl.setSchoolMaster(null);
	 * 
	 * return schoolLicenseDtl; }
	 */
	@PreUpdate
	@PrePersist
	public void updateTimeStamps() {
	    updateDate = new Timestamp(System.currentTimeMillis());
	    if (createDate == null) {
	    	createDate = new Timestamp(System.currentTimeMillis());
	    }
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + schoolId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SchoolMaster other = (SchoolMaster) obj;
		if (schoolId != other.schoolId)
			return false;
		return true;
	}

	public String getDeleteReason() {
		return deleteReason;
	}

	public void setDeleteReason(String deleteReason) {
		this.deleteReason = deleteReason;
	}

	public String getGmailId() {
		return gmailId;
	}

	public void setGmailId(String gmailId) {
		this.gmailId = gmailId;
	}

	public String getGmailPassword() {
		return gmailPassword;
	}

	public void setGmailPassword(String gmailPassword) {
		this.gmailPassword = gmailPassword;
	}

	public String getSmsSenderId() {
		return smsSenderId;
	}

	public void setSmsSenderId(String smsSenderId) {
		this.smsSenderId = smsSenderId;
	}
	
	
}