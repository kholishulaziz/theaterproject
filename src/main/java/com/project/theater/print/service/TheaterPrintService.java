package com.project.theater.print.service;

import java.io.IOException;
import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.theater.TheaterProjectConst;
import com.project.theater.account.Account;
import com.project.theater.account.AccountService;
import com.project.theater.print.domain.App;
import com.project.theater.print.domain.File;
import com.project.theater.print.domain.Transaction;
import com.project.theater.print.repository.AppRepository;
import com.project.theater.print.repository.FileRepository;
import com.project.theater.print.repository.TransactionRepository;

/**
 * Created by Kholishul_A on 20/04/2018.
 */
@Service
public class TheaterPrintService {

	@Autowired
	private AccountService accountService;

	@Autowired
	private AppRepository appRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private FileRepository fileRepository;

	/*
	 * AccountService
	 */

	public Account getAccount() {
		Account account = (Account) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		return (Account) accountService.loadUserByUsername(account
				.getUsername());
	}

	/*
	 * AppRepository
	 */

	public App getServer() {
		App app = appRepository.findOne(TheaterProjectConst.DEFAULT_TP_APP);
		if (app == null) {
			throw new NoSuchElementException(
					TheaterProjectConst.ERROR_NOT_FOUND);
		}
		app.setQueue(getAllQueues());
		app.setAccount(getAccount());
		return app;
	}

	public App getServer(String appId) {
		App app = appRepository.findOne(appId);
		if (app == null) {
			throw new NoSuchElementException(
					TheaterProjectConst.ERROR_NOT_FOUND);
		}
		app.setQueue(getQueues(appId));
		app.setAccount(getAccount());
		return app;
	}

	public Iterable<App> findAllServer() {
		Iterable<App> apps = appRepository.findAll();
		for (App app : apps) {
			app.setQueue(getQueues(app.getId()));
		}
		return apps;
	}

	/*
	 * TransactionRepository
	 */

	public Transaction createTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	public Transaction getTransaction(String id) {
		Transaction transaction = transactionRepository.findOne(id);
		if (transaction == null) {
			throw new NoSuchElementException(
					TheaterProjectConst.ERROR_NOT_FOUND);
		}
		return transaction;
	}

	public Transaction updateTransaction(String id, Transaction editTransaction) {
		getTransaction(id);
		return transactionRepository.save(editTransaction);
	}

	public void deleteTransaction(String id) {
		getTransaction(id);
		transactionRepository.delete(id);
	}

	public Iterable<Transaction> findLastTransaction() {
		return transactionRepository
				.findTop25ByAccountIdOrderByDateInDesc(getAccount().getId());
	}

	public Iterable<Transaction> findAllTransaction(Pageable pageable) {
		return transactionRepository.findAll(pageable);
	}

	public Iterable<Transaction> findRemainingTransaction(String appId,
			Pageable pageable) {
		return transactionRepository.findRemaining(appId, pageable);
	}

	public int getAllQueues() {
		return transactionRepository.getAllQueue();
	}

	public int getQueues(String appId) {
		return transactionRepository.getQueue(appId);
	}

	/*
	 * FileRepository
	 */

	public File uploadFile(MultipartFile file) {
		File uploadFile = new File();
		try {
			uploadFile = fileRepository.save(new File(file
					.getOriginalFilename(), file.getContentType(), file
					.getBytes(), new Date(), getAccount().getId()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return uploadFile;
	}

	public File getFile(String id) {
		File file = fileRepository.findOne(id);
		if (file == null) {
			throw new NoSuchElementException(
					TheaterProjectConst.ERROR_NOT_FOUND);
		}
		return file;
	}

	public Iterable<File> findAllFile(Pageable pageable) {
		return fileRepository.findAll(pageable);
	}

	public Iterable<File> findRemainingFile(String appId, Pageable pageable) {
		return fileRepository.findRemaining(appId, pageable);
	}

}
