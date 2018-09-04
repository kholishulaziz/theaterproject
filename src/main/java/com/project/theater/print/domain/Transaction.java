package com.project.theater.print.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.theater.TheaterProjectConst;

/**
 * Created by Kholishul_A on 20/04/2018.
 */
@Entity
@Table(indexes = { @Index(name = "IDX_TRX", columnList = "TRANSACTION_ID,ACCOUNT_ID,APP_ID,FILE_ID") })
public class Transaction {

	@Id
	@Column(name = "TRANSACTION_ID")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@Column(name = "ACCOUNT_ID")
	private String accountId;

	@Column(name = "APP_ID")
	private String appId;

	@Column(name = "FILE_ID")
	private String fileId;

	private int costEstimation;

	private int cost;

	private int status;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = TheaterProjectConst.DATE_FORMAT, timezone = TheaterProjectConst.LOCAL_TIME_ZONE)
	private Date dateIn;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = TheaterProjectConst.DATE_FORMAT, timezone = TheaterProjectConst.LOCAL_TIME_ZONE)
	private Date datePrintStart;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = TheaterProjectConst.DATE_FORMAT, timezone = TheaterProjectConst.LOCAL_TIME_ZONE)
	private Date datePrintComplete;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = TheaterProjectConst.DATE_FORMAT, timezone = TheaterProjectConst.LOCAL_TIME_ZONE)
	private Date dateOut;

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

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public int getCostEstimation() {
		return costEstimation;
	}

	public void setCostEstimation(int costEstimation) {
		this.costEstimation = costEstimation;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDateIn() {
		return dateIn;
	}

	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}

	public Date getDatePrintStart() {
		return datePrintStart;
	}

	public void setDatePrintStart(Date datePrintStart) {
		this.datePrintStart = datePrintStart;
	}

	public Date getDatePrintComplete() {
		return datePrintComplete;
	}

	public void setDatePrintComplete(Date datePrintComplete) {
		this.datePrintComplete = datePrintComplete;
	}

	public Date getDateOut() {
		return dateOut;
	}

	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
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

}
