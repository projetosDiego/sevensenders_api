package com.sevensenders.xkcdapi.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.sevensenders.xkcdapi.model.FeedModel;

@Service
public class FeedServiceImpl implements IFeedService{

	@Override
	public List<FeedModel> getFeed(){
		try {
			int i = 0;
			String url = "";
			int number = 0;
			FeedModel feedModel = new FeedModel();
			List<FeedModel> feedModelList = new ArrayList<FeedModel>();
			while(i < 10) {
				if(i == 0) {
					url = "https://xkcd.com/info.0.json";
//					url = "http://xkcd.com/614/info.0.json";
				}else {
//					url = "http://xkcd.com/"+number+"/info.0.json";
					url = "http://xkcd.com/614/info.0.json";
				}
				InputStream is = new URL(url).openStream();
		        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		        String jsonText = readAll(rd);
		        JSONObject json = new JSONObject(jsonText);
		        feedModel.setPictureUrl(json.getString("img"));
		        feedModel.setTitle(json.getString("title"));
		        feedModelList.add(feedModel);
		        number = json.getInt("num") - 1;
		        is.close();
				i++;
			}
			System.out.println(feedModelList);
	    } catch(Exception e) {
	        System.out.println(e);
		}
	    return null;	
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
