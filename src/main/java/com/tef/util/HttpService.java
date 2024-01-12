package com.tef.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.net.ssl.SSLContext;

public class HttpService {

    private static final int TIMEOUT = 120;

    private SSLContextBuilder sslContextBuilder = new SSLContextBuilder();

    public SSLContext sslContext;

    public String SERVICE = "https://localhost:4090/v1/";

    private SSLContext objectSSL(){
        try {
          sslContext = sslContextBuilder.SSLContext("mykeystore.jks","150173", "mycert");
            
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return sslContext;
    }

    public HttpRequest buildHttpRequestGET(String url, String MKTOKEN) {
        return HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(SERVICE + url))
                .headers("Content-Type", "application/json", "Authorization", MKTOKEN)
                .timeout(java.time.Duration.ofSeconds(TIMEOUT))
                .build();
    }

    public HttpRequest buildHttpRequestPOST(String url, String body, String MKTOKEN) {
        return HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create(SERVICE + url))
                .headers("Content-Type", "application/json", "Authorization", MKTOKEN)
                .timeout(java.time.Duration.ofSeconds(TIMEOUT))
                .build();
    }

    public HttpResponse<String> sendHttpRequest(HttpRequest request) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(java.time.Duration.ofSeconds(TIMEOUT))
                .followRedirects(HttpClient.Redirect.NORMAL)
                .sslContext(objectSSL())  // Configurar o SSLContext
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
