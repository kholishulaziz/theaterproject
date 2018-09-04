package com.project.theater.print.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.project.theater.TheaterProjectConst;
import com.project.theater.print.domain.Transaction;
import com.project.theater.print.service.TheaterPrintService;

/**
 * Created by Kholishul_A on 20/04/2018.
 */
@RestController
@RequestMapping(path = TheaterProjectConst.API_TP_TRANSACTION)
public class TransactionController {

	@Autowired
	private TheaterPrintService theaterPrintService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Transaction createTransaction(@RequestBody Transaction transaction) {
		return theaterPrintService.createTransaction(transaction);
	}

	@RequestMapping(path = TheaterProjectConst.API_ENTITY, method = RequestMethod.GET)
	public Transaction getTransaction(@PathVariable String id) {
		return theaterPrintService.getTransaction(id);
	}

	@RequestMapping(path = TheaterProjectConst.API_ENTITY, method = RequestMethod.PUT)
	public Transaction updateTransaction(@PathVariable String id,
			@RequestBody Transaction editTransaction) {
		return theaterPrintService.updateTransaction(id, editTransaction);
	}

	@RequestMapping(path = TheaterProjectConst.API_ENTITY, method = RequestMethod.DELETE)
	public void deleteTransaction(@PathVariable String id) {
		theaterPrintService.deleteTransaction(id);
	}

	@RequestMapping(path = TheaterProjectConst.API_FIND_ALL, method = RequestMethod.GET)
	public Iterable<Transaction> findAllTransaction(Pageable pageable) {
		return theaterPrintService.findAllTransaction(pageable);
	}

	@RequestMapping(path = TheaterProjectConst.API_FIND_LAST, method = RequestMethod.GET)
	public Iterable<Transaction> findLastTransaction() {
		return theaterPrintService.findLastTransaction();
	}

	@RequestMapping(path = TheaterProjectConst.API_FIND_REMAINING, method = RequestMethod.GET)
	public Iterable<Transaction> findRemainingTransaction(
			@RequestParam("appId") String appId, Pageable pageable) {
		return theaterPrintService.findRemainingTransaction(appId, pageable);
	}
}