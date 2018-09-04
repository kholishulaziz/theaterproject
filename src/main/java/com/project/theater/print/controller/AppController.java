package com.project.theater.print.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.theater.TheaterProjectConst;
import com.project.theater.print.domain.App;
import com.project.theater.print.service.TheaterPrintService;

/**
 * Created by Kholishul_A on 20/04/2018.
 */
@RestController
@RequestMapping(path = TheaterProjectConst.API_TP_APP)
public class AppController {

	@Autowired
	private TheaterPrintService theaterPrintService;

	@RequestMapping(method = RequestMethod.GET)
	public App getServer() {
		return theaterPrintService.getServer();
	}

	@RequestMapping(path = TheaterProjectConst.API_ENTITY, method = RequestMethod.GET)
	public App getServer(@PathVariable String id) {
		return theaterPrintService.getServer(id);
	}

	@RequestMapping(path = TheaterProjectConst.API_FIND_ALL, method = RequestMethod.GET)
	public Iterable<App> getAllServer() {
		return theaterPrintService.findAllServer();
	}

}
