package com.multicampus.kb03.weddingBuddy.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RestTemplateService {
	// server Test
	// https://localhost:8082/koofie/api/server/hello

	/*
	 * public void hello() { //uri 주소생성 URI uri = UriComponentsBuilder
	 * .fromUriString("https://localhost:8082/koofie") .path("/api/server/hello")
	 * .queryParam("name", "steve") .encode() .build() .toUri();
	 * 
	 * 
	 * System.out.println(uri.toString());
	 */

	public void test() {
		// RestTemplate 객체생성
		RestTemplate restTemplate = new RestTemplate();

		// openApi 호출
		String apiKey = "DC%2BqmUApWGCQbMOJF0QaGxhO7yY8SeoWldzEfB5%2FI1WPK8BaDYU9JaMOotJ79WAyyJuzI%2FbwD2O%2F7Jnj%2BIlfUQ%3D%3D";
		String apiUrl = "http://apis.data.go.kr/B553701/SeominFinancialEducationContentsInfoService"
				+ "/getFinancialEducationContentsInfo?ServiceKey=" + apiKey
				+ "&numOfRows=10&PageNo=1&edcSbjcNm=상권업자&edcLgclsNm=자영업자";
		ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, String.class);
		String result = response.getBody();
		System.out.println(result);
	}
}
