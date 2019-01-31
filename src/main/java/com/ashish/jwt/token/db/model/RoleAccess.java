package com.ashish.jwt.token.db.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Where;

import java.sql.Timestamp;


/**
 * The persistent class for the role_access database table.
 * 
 */
@Entity
@Table(name="role_access")
@NamedQuery(name="RoleAccess.findAll", query="SELECT r FROM RoleAccess r")
@Where(clause="delete_ind is NULL or delete_ind='N'")
public class RoleAccess implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="role_access_id", unique=true, nullable=false)
	private int roleAccessId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_user", length=50)
	private String createUser;

	@Column(name="delete_ind", length=2)
	private String deleteInd;

	@Column(name="delete_reason", length=100)
	private String deleteReason;

	@Column(name="role_access_permission", nullable=false, length=1)
	private String roleAccessPermission;

	@Column(name="update_date")
	private Timestamp updateDate;

	@Column(name="update_user", length=50)
	private String updateUser;

	//bi-directional many-to-one association to RoleMaster
	@ManyToOne
	@JoinColumn(name="role_id", nullable=false)
	private RoleMaster roleMaster;

	public RoleAccess() {
	}

	public int getRoleAccessId() {
		return this.roleAccessId;
	}

	public void setRoleAccessId(int roleAccessId) {
		this.roleAccessId = roleAccessId;
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

	public String getDeleteInd() {
		return this.deleteInd;
	}

	public void setDeleteInd(String deleteInd) {
		this.deleteInd = deleteInd;
	}

	public String getDeleteReason() {
		return this.deleteReason;
	}

	public void setDeleteReason(String deleteReason) {
		this.deleteReason = deleteReason;
	}

	public String getRoleAccessPermission() {
		return this.roleAccessPermission;
	}

	public void setRoleAccessPermission(String roleAccessPermission) {
		this.roleAccessPermission = roleAccessPermission;
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

	public RoleMaster getRoleMaster() {
		return this.roleMaster;
	}

	public void setRoleMaster(RoleMaster roleMaster) {
		this.roleMaster = roleMaster;
	}

}