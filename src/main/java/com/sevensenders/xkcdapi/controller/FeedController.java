package com.sevensenders.xkcdapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sevensenders.xkcdapi.model.FeedModel;
import com.sevensenders.xkcdapi.service.IFeedService;

@RestController
public class FeedController {
	
	@Autowired
    private IFeedService feedService;
	
	@RequestMapping(value = "/feed", method = RequestMethod.GET)
	public ResponseEntity<List<FeedModel>> feed() {
		return new ResponseEntity<List<FeedModel>>(feedService.getFeed(), HttpStatus.FOUND);
	}

}
