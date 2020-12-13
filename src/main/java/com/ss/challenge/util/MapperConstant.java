package com.ss.challenge.util;


import org.mapstruct.factory.Mappers;

import com.ss.challenge.mapper.WebComicsMapper;

public class MapperConstant {
	
	public static final WebComicsMapper instanceOrderListMapper = Mappers.getMapper(WebComicsMapper.class);
}
