package com.client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MyThread extends Thread{
	
	public void run() {
		while(true) {
			System.out.println(getResponse());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String getResponse() {
		String result="";
		try {

			URL url = new URL("http://localhost:8888/spring3/pavan/");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			//conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			//System.out.println("up");
			result = "up";
			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			//e.printStackTrace();
			//System.out.println("down");
			result = "down";
		  }
		return result;
	}
}
