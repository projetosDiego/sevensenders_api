package com.sevensenders.xkcdapi;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.sun.syndication.io.FeedException;

@SpringBootApplication
public class XkcdapiApplication {

	public static void main(String[] args) throws IOException, IllegalArgumentException, FeedException {
		SpringApplication.run(XkcdapiApplication.class, args);
		
//		URL url = new URL("http://feeds.feedburner.com/PoorlyDrawnLines");
//	    XmlReader xmlReader = null;
//
//	    try {
//
//	      xmlReader = new XmlReader(url);
//	      SyndFeed feeder = new SyndFeedInput().build(xmlReader);
//	      System.out.println("Title Value " + feeder.getAuthor());
//
//	      for (Iterator iterator = feeder.getEntries().iterator(); iterator.hasNext();) {
//	        SyndEntry syndEntry = (SyndEntry) iterator.next();
//	        System.out.println(syndEntry.getTitle() + syndEntry.getAuthor() + syndEntry.getDescription() + syndEntry.getPublishedDate());
//	      }
//	    } finally {
//	      if (xmlReader != null)
//	        xmlReader.close();
//	    }
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   return builder.build();
	}

}
