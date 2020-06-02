package main.java.com.example.ibmtest;

import java.util.Collections;
import java.util.LinkedList;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@EnableAutoConfiguration
public class Routes {

	@GetMapping("/movie-titles/{substr}")
	public ResponseEntity<LinkedList<String>> getMovieTitles(@PathVariable("substr") String substr) {

		int maxPages = Integer.MAX_VALUE;
		int numberOfPagesToSearch = 1; // initial value
		LinkedList<String> movieTitlesList = new LinkedList<String>();

		while (numberOfPagesToSearch <= maxPages) {

			String responseObject = new RestService(new RestTemplateBuilder()).getMoviesJSON(substr,
					numberOfPagesToSearch++);

			DatabaseResponse convertedObject = new Gson().fromJson(responseObject, DatabaseResponse.class);

			maxPages = convertedObject.getTotal_pages();

			for (Movies movie : convertedObject.getData()) {
				movieTitlesList.add(movie.getTitle());
			}

		}

		// printing titles in console
//		for (String title : movieTitlesList) {
//			System.out.println(title);
//		}

		Collections.sort(movieTitlesList);
		return new ResponseEntity<LinkedList<String>>(movieTitlesList, HttpStatus.OK);
	}
}