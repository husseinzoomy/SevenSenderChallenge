package com.ss.challenge.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebComic {
	private String pictureUrl;
	private String title;
	private String webUrl;
	private Date publishingDate;
	
}
