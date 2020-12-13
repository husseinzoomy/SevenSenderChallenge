package com.ss.challenge.service;

import static com.ss.challenge.util.MapperConstant.instanceOrderListMapper;

import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import com.ss.challenge.feign.XKCDCClient;
import com.ss.challenge.model.WebComic;
import com.ss.challenge.model.XKCDModel;


@Service
public class WebComicService {
	private static final Logger LOGGER = LoggerFactory.getLogger(WebComicService.class);
	
	@Autowired
	private XKCDCClient xkcdcClient;
	
	String feedBurnerUrl = "http://feeds.feedburner.com/PoorlyDrawnLines";
	
	private static final Gson GSON = new Gson();

	public List<WebComic>  getFeedBurner() {
		List<WebComic> response = new ArrayList<WebComic>();
		   try {
	            try (XmlReader reader = new XmlReader(new URL(feedBurnerUrl))) {
	                SyndFeed feed = new SyndFeedInput().build(reader);
	                long count =   feed.getEntries().stream().count();
	                feed.getEntries().stream().skip(count>10 ? count-10: 0).forEach(s->{
	                	response.add(instanceOrderListMapper.mapFeedBurner(s));
	                }); 
	            }
	        }  catch (Exception e) {
	        	LOGGER.error("Error while reading the feeds");
	        }
		   XKCDModel xkcd = GSON.fromJson(xkcdcClient.getComic(), new TypeToken<XKCDModel>(){}.getType());
		   response.add(instanceOrderListMapper.mapxkcd(xkcd));
		   
		return response.stream().sorted(Comparator.comparing(WebComic::getPublishingDate)).collect(Collectors.toList());
	}

}
