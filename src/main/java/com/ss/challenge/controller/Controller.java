package com.ss.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ss.challenge.model.WebComic;
import com.ss.challenge.service.WebComicService;

@RestController
public class Controller {
	@Autowired
	private WebComicService webComicService;


	@RequestMapping(value = "/webcomics", method = RequestMethod.GET)
	public List<WebComic> getWebComics() {
		return webComicService.getFeedBurner();
	}

}
