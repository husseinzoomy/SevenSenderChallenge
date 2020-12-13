package com.ss.challenge;

import static com.ss.challenge.util.MapperConstant.instanceOrderListMapper;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ss.challenge.model.WebComic;
import com.ss.challenge.model.XKCDModel;

@SpringBootTest
public class MapperTest {
	
	@Test
	public void testxkcd() {
		XKCDModel model = new XKCDModel(2020, 12, 11, "www.website.com", "www.img.com/comic", "test image");
		WebComic comic = instanceOrderListMapper.mapxkcd(model);
		
		assertThat(comic != null);
		assertEquals(comic.getPictureUrl(), model.getImg());
		assertEquals(comic.getTitle(), model.getTitle());
		assertEquals(comic.getWebUrl(), model.getLink());
		assertThat(comic.getPublishingDate())
		.hasDayOfMonth(model.getDay())
		.hasMonth(model.getMonth())
		.hasYear(model.getYear());
		
	}
	

}
