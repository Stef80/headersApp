package it.longobucco.analisihttp.prova;

import org.jsoup.HttpStatusException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws HttpStatusException {
       execution("https://www.ciaoamigos.it/videochat/stanzerosse");
    }
    public static void execution(String url) throws HttpStatusException {
        RestTemplate restTemplate = new RestTemplate();
        //ResponseEntity<String> response= restTemplate.getForEntity(url,String.class);

        //System.out.println(response.getStatusCode().value());
       // System.out.println(response.getHeaders().entrySet().stream().limit(2).map(x-> x.getKey()+"=" + x.getValue()).collect(Collectors.toList()));

        HttpHeaders httpHeaders = restTemplate.headForHeaders(url);

       System.out.println(httpHeaders);

    }
}
