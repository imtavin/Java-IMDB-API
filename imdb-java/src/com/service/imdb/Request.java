package com.service.imdb;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Request {
	
	public static void main(String[] args) {
		
		HttpClient client = HttpClient
				.newBuilder()
				.build();
			
		HttpRequest request = HttpRequest
	            .newBuilder()
	            .uri(URI.create("https://imdb-api.com/en/API/Title/"))
	            .GET()
	            .build();
		
		
//		HttpResponse response = client.newCall(request).execute();
		
		System.out.println(request);
	}
}
