package com.ss.challenge.mapper;


import org.mapstruct.Mapper;

import com.rometools.rome.feed.synd.SyndEntry;
import com.ss.challenge.model.WebComic;
import com.ss.challenge.model.XKCDModel;


@Mapper
public interface WebComicsMapper {

	WebComic mapFeedBurner(SyndEntry input);
	WebComic mapxkcd(XKCDModel input);
	
}
