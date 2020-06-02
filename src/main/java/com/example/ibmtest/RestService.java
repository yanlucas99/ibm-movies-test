package com.example.ibmtest;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
    public class RestService {

        private final RestTemplate restTemplate;

        public RestService(RestTemplateBuilder restTemplateBuilder) {
            this.restTemplate = restTemplateBuilder.build();
        }

        public String getMoviesJSON(String substr, int pageNumber) {
            String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr +"&page=" + pageNumber;
            return this.restTemplate.getForObject(url, String.class);
        }
    }
