package com.sevensenders.xkcdapi.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.sevensenders.xkcdapi.model.FeedModel;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;


@Service
public class FeedServiceImpl implements IFeedService{

	@Override
	public List<FeedModel> getFeed(){
		List<FeedModel> feedModelList = new ArrayList<FeedModel>();
		getXkcdStrips(feedModelList);
	    getPDLStrips(feedModelList);
	    return feedModelList;	
	}

	private void getPDLStrips(List<FeedModel> feedModelList) {
		FeedModel feedModel = new FeedModel();
		try {
	    	XmlReader xmlReader = null;
	    	URL       url       = new URL("http://feeds.feedburner.com/PoorlyDrawnLines");
	    	
	        xmlReader = new XmlReader(url);
	        SyndFeed feeder = new SyndFeedInput().build(xmlReader);
	        System.out.println("Title Value " + feeder.getAuthor());

	        for (Iterator iterator = feeder.getEntries().iterator(); iterator.hasNext();) {
	            SyndEntry syndEntry = (SyndEntry) iterator.next();
	            feedModel.setPictureUrl(syndEntry.getTitle());
		        feedModel.setTitle(syndEntry.getTitle());
		        feedModelList.add(feedModel);
	            System.out.println(syndEntry.getTitle() + syndEntry.getAuthor() + syndEntry.getDescription() + syndEntry.getPublishedDate());
	        }
	        xmlReader.close();
	     } catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FeedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getXkcdStrips(List<FeedModel> feedModelList) {
		FeedModel feedModel = new FeedModel();
		int       num       = 0;
		int       i         = 0;
		String    url       = "";
		try {
			while(i < 10) {
				if(num == 0) {
					url = "https://xkcd.com/info.0.json";
				}else {
					url = "https://xkcd.com/"+num+"/info.0.json";
				}
				InputStream    is       = new URL(url).openStream();
		        BufferedReader rd       = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		        String         jsonText = readAll(rd);
		        JSONObject     json     = new JSONObject(jsonText);
		        
		        feedModel.setPictureUrl(json.getString("img"));
		        feedModel.setTitle(json.getString("title"));
		        feedModelList.add(feedModel);
		        is.close();
		        
		        feedModel = new FeedModel();
				num       = json.getInt("num")-1;
				i++;
			}
	    } catch(Exception e) {
	        System.out.println(e);
		}
	}
	
	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }

}
