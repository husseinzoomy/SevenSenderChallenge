package com.ss.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class XKCDModel {
	private int year;
	private int month;
	private int day;
	private String link;
	private String img;
	private String title;
}
