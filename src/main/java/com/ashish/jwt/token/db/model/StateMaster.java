package com.ashish.jwt.token.db.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


/**
 * The persistent class for the state_master database table.
 * 
 */
@Entity
@Table(name="state_master")
@NamedQuery(name="StateMaster.findAll", query="SELECT s FROM StateMaster s")
@SQLDelete(sql="UPDATE state_master SET delete_ind = 'Y' WHERE state_id = ?")
@Where(clause="delete_ind is NULL or delete_ind='N'")
public class StateMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="state_id")
	private int stateId;

	@Column(name="state_code")
	private String stateCode;

	@Column(name="state_name")
	private String stateName;
	
	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_user")
	private String createUser;
	
	@Column(name="update_date", insertable=false)
	private Timestamp updateDate;

	@Column(name="update_user")
	private String updateUser;

	@Column(name="delete_ind")
	private String deleteInd;
	
	//bi-directional many-to-one association to DistrictMaster
	@OneToMany(mappedBy="stateMaster", cascade = {CascadeType.REMOVE,CascadeType.MERGE})
	@Where(clause="delete_ind is NULL or delete_ind='N'")
	private List<DistrictMaster> districtMasters;

	//bi-directional many-to-one association to CountryMaster
	@ManyToOne//(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},fetch=FetchType.EAGER)
//	@OnDelete(action = org.hibernate.annotations.OnDeleteAction.CASCADE) 
	@JoinColumn(name="country_id")
	private CountryMaster countryMaster;

	public StateMaster() {
	}
	public String getDeleteInd() {
		return deleteInd;
	}
	public void setDeleteInd(String deleteInd) {
		this.deleteInd = deleteInd;
	}
	
	public int getStateId() {
		return this.stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateCode() {
		return this.stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public List<DistrictMaster> getDistrictMasters() {
		return this.districtMasters;
	}

	public void setDistrictMasters(List<DistrictMaster> districtMasters) {
		this.districtMasters = districtMasters;
	}

	public DistrictMaster addDistrictMaster(DistrictMaster districtMaster) {
		getDistrictMasters().add(districtMaster);
		districtMaster.setStateMaster(this);

		return districtMaster;
	}

	public DistrictMaster removeDistrictMaster(DistrictMaster districtMaster) {
		getDistrictMasters().remove(districtMaster);
		districtMaster.setStateMaster(null);

		return districtMaster;
	}

	public CountryMaster getCountryMaster() {
		return this.countryMaster;
	}

	public void setCountryMaster(CountryMaster countryMaster) {
		this.countryMaster = countryMaster;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + stateId;
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
		StateMaster other = (StateMaster) obj;
		if (stateId != other.stateId)
			return false;
		return true;
	}
	@PreUpdate
	@PrePersist
	public void updateTimeStamps() {
	    updateDate = new Timestamp(System.currentTimeMillis());
	    if (createDate == null) {
	    	createDate = new Timestamp(System.currentTimeMillis());
	    }
	}
}