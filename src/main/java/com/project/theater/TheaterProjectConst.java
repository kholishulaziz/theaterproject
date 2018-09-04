package com.project.theater;

/**
 * Created by Kholishul_A on 20/04/2018.
 */
public interface TheaterProjectConst {

	String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
	String LOCAL_TIME_ZONE = "GMT+7";
	String USER_ADMIN = "SYS";
	
	String API_ENTITY = "/{id}";
	String API_FIND_LAST = "/last";
	String API_FIND_ALL = "/all";
	String API_FIND_REMAINING = "/remaining";
	String API_TP_APP = "/api/tp-app";
	String API_TP_ACCOUNT = "/api/tp-account";
	String API_TP_TRANSACTION = "/api/tp-trx";
	String API_TP_FILE = "/api/tp-file";
	
	String DEFAULT_TP_APP = "APP-01";
	String ERROR_NOT_FOUND = "Entity not Found";
	String ERROR_DUPLICATE = "Duplicate entity";
	
}
