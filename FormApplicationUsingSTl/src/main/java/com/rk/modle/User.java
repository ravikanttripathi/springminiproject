package com.rk.modle;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "user_tab")
public class User {
	@Id
	@GeneratedValue
	@Column(name = "u_id")
	private Integer userId;
	@Column(name = "u_name")
	private String userName;
	@Column(name="u_mail")
	private String userMail;
	@Column(name="u_pwd")
	private String userPwd;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="rol_tab", joinColumns = @JoinColumn(name="id"))
	@Column(name="role")
	private List<String> roles;

	public User(Integer userId) {
		super();
		this.userId = userId;
	}

	public User() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userMail=" + userMail + ", userPwd=" + userPwd
				+ ", roles=" + roles + "]";
	}

}
