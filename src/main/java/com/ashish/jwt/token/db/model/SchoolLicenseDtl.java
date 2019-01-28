package  com.ashish.jwt.token.db.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Where;

import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the school_license_dtl database table.
 * 
 */
@Entity
@Table(name="school_license_dtl")
@NamedQuery(name="SchoolLicenseDtl.findAll", query="SELECT b FROM SchoolLicenseDtl b")
@Where(clause="delete_ind is NULL or delete_ind='N'")
public class SchoolLicenseDtl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="school_license_id")
	private int schoolLicenseId;

	@Column(name="school_id")
	private int schoolId;
	
	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_user")
	private String createUser;

	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	@Column(name="grace_day")
	private int graceDay;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;

	@Column(name="update_date", insertable=false)
	private Timestamp updateDate;

	@Column(name="update_user")
	private String updateUser;

	@Column(name="delete_ind")
	private String deleteInd;
	
	//bi-directional many-to-one association to SchoolMaster
	@ManyToOne
	@JoinColumn(name="school_id", insertable=false, updatable=false)
	private SchoolMaster schoolMaster;

	public SchoolLicenseDtl() {
	}

	public String getDeleteInd() {
		return deleteInd;
	}

	public void setDeleteInd(String deleteInd) {
		this.deleteInd = deleteInd;
	}

	public int getSchoolLicenseId() {
		return this.schoolLicenseId;
	}

	public void setSchoolLicenseId(int schoolLicenseId) {
		this.schoolLicenseId = schoolLicenseId;
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

	public int getGraceDay() {
		return this.graceDay;
	}

	public void setGraceDay(int graceDay) {
		this.graceDay = graceDay;
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

	public SchoolMaster getSchoolMaster() {
		return this.schoolMaster;
	}

	public void setSchoolMaster(SchoolMaster schoolMaster) {
		this.schoolMaster = schoolMaster;
	}


	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + schoolLicenseId;
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
		SchoolLicenseDtl other = (SchoolLicenseDtl) obj;
		if (schoolLicenseId != other.schoolLicenseId)
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