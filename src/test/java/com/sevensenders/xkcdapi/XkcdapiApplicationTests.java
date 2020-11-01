package com.sevensenders.xkcdapi;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sevensenders.xkcdapi.model.FeedModel;
import com.sevensenders.xkcdapi.service.IFeedService;

@RunWith(SpringRunner.class)
@SpringBootTest
class XkcdapiApplicationTests {
	
	@Autowired
	private IFeedService feedService;

	@Test
	public void getFeedTest() {
		List<FeedModel> list = feedService.getFeed();
		Assert.assertNotNull(list);
	}

}
