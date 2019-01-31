package com.ashish.jwt.token.db.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Where;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the role_master database table.
 * 
 */
@Entity
@Table(name="role_master")
@NamedQuery(name="RoleMaster.findAll", query="SELECT r FROM RoleMaster r")
@Where(clause="delete_ind is NULL or delete_ind='N'")
public class RoleMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="role_id", unique=true, nullable=false)
	private int roleId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_user", length=50)
	private String createUser;

	@Column(name="delete_ind", length=2)
	private String deleteInd;

	@Column(name="delete_reason", length=100)
	private String deleteReason;

	@Column(name="role_desc", nullable=false, length=100)
	private String roleDesc;

	@Column(name="role_name", nullable=false, length=50)
	private String roleName;

	@Column(name="update_date")
	private Timestamp updateDate;

	@Column(name="update_user", length=50)
	private String updateUser;

	//bi-directional many-to-one association to RoleAccess
	@OneToMany(mappedBy="roleMaster", cascade={CascadeType.REMOVE,CascadeType.MERGE, CascadeType.REFRESH}, fetch=FetchType.EAGER)
	private List<RoleAccess> roleAccesses;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="roleMaster", cascade={CascadeType.REMOVE,CascadeType.MERGE, CascadeType.REFRESH}, fetch=FetchType.LAZY)
	private List<UserRole> userRoles;

	public RoleMaster() {
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
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

	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

	public List<RoleAccess> getRoleAccesses() {
		return this.roleAccesses;
	}

	public void setRoleAccesses(List<RoleAccess> roleAccesses) {
		this.roleAccesses = roleAccesses;
	}

	public RoleAccess addRoleAccess(RoleAccess roleAccess) {
		getRoleAccesses().add(roleAccess);
		roleAccess.setRoleMaster(this);

		return roleAccess;
	}

	public RoleAccess removeRoleAccess(RoleAccess roleAccess) {
		getRoleAccesses().remove(roleAccess);
		roleAccess.setRoleMaster(null);

		return roleAccess;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setRoleMaster(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setRoleMaster(null);

		return userRole;
	}

}