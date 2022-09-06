package com.service.imdb;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Main {
	
	public static void main(String[] args) throws Exception {
		
		JSONObject json = RequestTopMovies();
		
		List<Movie>  list = new ArrayList<Movie>();

		
		JSONArray jsonArr = json.getJSONArray("items");
		
		for (int i = 0; i < jsonArr.length(); i++) {
		    JSONObject jsonobject = jsonArr.getJSONObject(i);
		    list.add(new Movie(jsonobject.getString("title"), jsonobject.getString("image"), 
								jsonobject.getDouble("imDbRating"), jsonobject.getInt("year")));
		}
	
		list.forEach(System.out::println);

	}


	public static JSONObject RequestTopMovies() throws JSONException, URISyntaxException {
		String apiKey = "k_5bivjc99";
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest
	            .newBuilder()
	            .uri(new URI("https://imdb-api.com/en/API/Top250Movies/" + apiKey))
	            .header("X-RapidAPI-Key",apiKey )
	            .GET()
	            .build();
		
		StringBuilder jsonStr = new StringBuilder();
		
		client.sendAsync(request, BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenAccept( c -> jsonStr.append(c))
				.join();
		
		JSONObject json = new JSONObject(jsonStr.toString());
		
		return json;
		
	}

}





