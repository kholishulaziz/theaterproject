package com.project.theater.print.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.project.theater.TheaterProjectConst;
import com.project.theater.print.domain.File;
import com.project.theater.print.service.TheaterPrintService;

/**
 * Created by Kholishul_A on 20/04/2018.
 */
@RestController
@RequestMapping(path = TheaterProjectConst.API_TP_FILE)
public class FileController {

	@Autowired
	private TheaterPrintService theaterPrintService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public File uploadFile(@RequestParam("file") MultipartFile file) {
		return theaterPrintService.uploadFile(file);
	}

	@RequestMapping(path = TheaterProjectConst.API_ENTITY, method = RequestMethod.GET)
	public File getFile(@PathVariable String id) {
		return theaterPrintService.getFile(id);
	}

	@RequestMapping(path = TheaterProjectConst.API_FIND_ALL, method = RequestMethod.GET)
	public Iterable<File> findAllFile(Pageable pageable) {
		return theaterPrintService.findAllFile(pageable);
	}

	@RequestMapping(path = TheaterProjectConst.API_FIND_REMAINING, method = RequestMethod.GET)
	public Iterable<File> findRemainingFile(
			@RequestParam("appId") String appId, Pageable pageable) {
		return theaterPrintService.findRemainingFile(appId, pageable);
	}

}