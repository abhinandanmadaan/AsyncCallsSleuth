package com.example.demo.Client;

import com.example.demo.Client.Output.Country;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

//@Service
//public class CountryClient {
//	
//	 private static final Logger logger = LoggerFactory.getLogger(CountryClient.class);
//
//    RestTemplate restTemplate = new RestTemplate();
//
//    @Async("threadPoolTaskExecutor")
//    public CompletableFuture<List<Country>> getCountriesByLanguage(String language) {
//
//        logger.info("Entering getCountriesByLanguage");
//    	String url = "https://restcountries.eu/rest/v2/lang/" + language + "?fields=name";
//        Country[] response = restTemplate.getForObject(url, Country[].class);
//        try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        logger.info("Exiting getCountriesByLanguage");
//        return CompletableFuture.completedFuture(Arrays.asList(response));
//    }
//
//    @Async("threadPoolTaskExecutor")
//    public CompletableFuture<List<Country>> getCountriesByRegion(String region) {
//    	logger.info("Entering getCountriesByRegion");
//    	String url = "https://restcountries.eu/rest/v2/region/" + region + "?fields=name";
//        Country[] response = restTemplate.getForObject(url, Country[].class);
//        logger.info("Exiting getCountriesByRegion");
//        return CompletableFuture.completedFuture(Arrays.asList(response));
//    }
//}




@Service
public class CountryClient {
	
	 private static final Logger logger = LoggerFactory.getLogger(CountryClient.class);

    RestTemplate restTemplate = new RestTemplate();

//    @Async("threadPoolTaskExecutor")
    public List<Country> getCountriesByLanguage(String language){
        logger.info("Entering getCountriesByLanguage");
    	String url = "https://restcountries.eu/rest/v2/lang/" + language + "?fields=name";
        Country[] response = restTemplate.getForObject(url, Country[].class);
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        logger.info("Exiting getCountriesByLanguage");
//        return CompletableFuture.completedFuture(Arrays.asList(response));
        return Arrays.asList(response);
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<Country>> getCountriesByRegion(String region) {
    	logger.info("Entering getCountriesByRegion");
    	String url = "https://restcountries.eu/rest/v2/region/" + region + "?fields=name";
        Country[] response = restTemplate.getForObject(url, Country[].class);
        logger.info("Exiting getCountriesByRegion");
        return CompletableFuture.completedFuture(Arrays.asList(response));
    }
}
