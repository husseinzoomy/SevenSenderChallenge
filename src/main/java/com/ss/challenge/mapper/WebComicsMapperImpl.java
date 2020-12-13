package com.ss.challenge.mapper;

import java.util.Calendar;

import org.springframework.stereotype.Component;

import com.rometools.rome.feed.synd.SyndEntry;
import com.ss.challenge.model.WebComic;
import com.ss.challenge.model.XKCDModel;


@Component
public class WebComicsMapperImpl implements WebComicsMapper {

	@Override
	public WebComic mapFeedBurner(SyndEntry input) {
		WebComic output = new WebComic();
		output.setPictureUrl(input.getLink());
		output.setTitle(input.getTitle());
		output.setWebUrl(input.getUri());
		output.setPublishingDate(input.getPublishedDate());
		return output;
	}

	@Override
	public WebComic mapxkcd(XKCDModel input) {
		WebComic output = new WebComic();
		output.setTitle(input.getTitle());
		output.setPictureUrl(input.getImg());
		output.setWebUrl(input.getLink());
		Calendar c = Calendar.getInstance();
		c.set(input.getYear(), input.getMonth()-1, input.getDay());
		output.setPublishingDate(c.getTime());
		return output;
	}


		

}
