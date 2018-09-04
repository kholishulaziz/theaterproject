package com.project.theater.account;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.theater.TheaterProjectConst;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by Kholishul_A on 20/04/2018.
 */
@Entity
@Table(indexes = { @Index(name = "IDX_ACCOUNT", columnList = "ACCOUNT_ID,LINKING_ID,USERNAME") })
public class Account implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ACCOUNT_ID")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@Column(name = "LINKING_ID")
	private String linkingId;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String password;

	private boolean administrator;

	private String fullname;

	private String email;

	private String phone;

	private int balance;

	private boolean enabled;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = TheaterProjectConst.DATE_FORMAT, timezone = TheaterProjectConst.LOCAL_TIME_ZONE)
	private Date memberSince;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = TheaterProjectConst.DATE_FORMAT, timezone = TheaterProjectConst.LOCAL_TIME_ZONE)
	private Date lastLogin;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = TheaterProjectConst.DATE_FORMAT, timezone = TheaterProjectConst.LOCAL_TIME_ZONE)
	private Date dateCreation;

	private String userCreationId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = TheaterProjectConst.DATE_FORMAT, timezone = TheaterProjectConst.LOCAL_TIME_ZONE)
	private Date dateLastUpdate;

	private String userLastUpdateId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLinkingId() {
		return linkingId;
	}

	public void setLinkingId(String linkingId) {
		this.linkingId = linkingId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdministrator() {
		return administrator;
	}

	public void setAdministrator(boolean administrator) {
		this.administrator = administrator;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getMemberSince() {
		return memberSince;
	}

	public void setMemberSince(Date memberSince) {
		this.memberSince = memberSince;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getUserCreationId() {
		return userCreationId;
	}

	public void setUserCreationId(String userCreationId) {
		this.userCreationId = userCreationId;
	}

	public Date getDateLastUpdate() {
		return dateLastUpdate;
	}

	public void setDateLastUpdate(Date dateLastUpdate) {
		this.dateLastUpdate = dateLastUpdate;
	}

	public String getUserLastUpdateId() {
		return userLastUpdateId;
	}

	public void setUserLastUpdateId(String userLastUpdateId) {
		this.userLastUpdateId = userLastUpdateId;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

}
