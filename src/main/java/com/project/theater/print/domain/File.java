package com.project.theater.print.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.theater.TheaterProjectConst;

@Entity
public class File {

	@Id
	@Column(name = "FILE_ID")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	private String name;

	private String type;

	@Lob
	private byte[] raw;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = TheaterProjectConst.DATE_FORMAT, timezone = TheaterProjectConst.LOCAL_TIME_ZONE)
	private Date dateCreation;

	private String userCreationId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getRaw() {
		return raw;
	}

	public void setRaw(byte[] raw) {
		this.raw = raw;
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

	public File() {
		super();
	}

	public File(String name, String type, byte[] raw, Date dateCreation,
			String userCreationId) {
		super();
		this.name = name;
		this.type = type;
		this.raw = raw;
		this.dateCreation = dateCreation;
		this.userCreationId = userCreationId;
	}

}