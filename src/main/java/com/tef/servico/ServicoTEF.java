package com.tef.servico;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tef.domain.InitRequest;
import com.tef.domain.InitResponse;
import com.tef.domain.PaymentRequest;
import com.tef.domain.PaymentResponse;
import com.tef.domain.PinPad;
import com.tef.util.HttpService;
import com.tef.util.MapperJson;

public class ServicoTEF {

        public static String MKTOKEN;

        public static HttpService serviceHttp = new HttpService();
        static MapperJson mapperJson = new MapperJson();
        static ObjectMapper objectMapper = new ObjectMapper();
    

        public static InitResponse init(InitRequest initPinpad, String merchantToken)
                throws Exception {               
                MKTOKEN = merchantToken;
                final String url = "pinpad/init";
                 System.out.println(initPinpad);
                final String Body = objectMapper.writeValueAsString(initPinpad);
                
                HttpRequest request = serviceHttp.buildHttpRequestPOST(url, Body, MKTOKEN);
                HttpResponse<String> response = serviceHttp.sendHttpRequest(request);

                mapperJson.converteStringParaJson(response.body());
                System.out.println("response:" + response.body());
                InitResponse initResponse = objectMapper.readValue(response.body(), InitResponse.class);

                return initResponse;
        }

        public static PaymentResponse payment(PaymentRequest authorizationRequest)
                throws IOException, InterruptedException, NoSuchAlgorithmException, KeyManagementException {
                final String url = "charge/authorization";
                final String Body = objectMapper.writeValueAsString(authorizationRequest);

                HttpRequest request = serviceHttp.buildHttpRequestPOST(url, Body, MKTOKEN);
                HttpResponse<String> response = serviceHttp.sendHttpRequest(request);

                PaymentResponse paymentResponse = objectMapper.readValue(response.body(), PaymentResponse.class);

                return paymentResponse;
        }

        public static Integer confirm(Integer nsu)
                throws IOException, InterruptedException, NoSuchAlgorithmException, KeyManagementException {
                final String url = "charge/confirmation?nsu=" + nsu;

                HttpRequest request = serviceHttp.buildHttpRequestGET(url, MKTOKEN);
                HttpResponse<String> response = serviceHttp.sendHttpRequest(request);

                JsonNode jsonResponse = mapperJson.converteStringParaJson(response.body());
                Boolean confirmed = jsonResponse.get("confirmed").asBoolean();

                if (confirmed) {
                        System.out.println("Transação Confirmada !");
                } else {
                        System.out.println("Transação Não Confirmada !!!");
                }

                System.out.println("");
                System.out.println("Response: " + response.body());
                System.out.println("Stats HTTP: " + response.statusCode() + " Version HTTP: " + response.version());
                System.out.println("Headers: " + response.headers());

                return null;
        }

        public static PinPad cancelation(Integer nsu)
                throws IOException, InterruptedException, NoSuchAlgorithmException, KeyManagementException {
                final String url = "charge/cancelation?nsu=" + nsu;

                HttpRequest request = serviceHttp.buildHttpRequestGET(url, MKTOKEN);
                HttpResponse<String> response = serviceHttp.sendHttpRequest(request);

                System.out.println("");
                System.out.println("Response: " + response.body());
                System.out.println("Stats HTTP: " + response.statusCode() + " Version HTTP: " + response.version());
                System.out.println("Headers: " + response.headers());

                return null;
        }

        public static PinPad reversal(String nsu)
                throws IOException, InterruptedException, NoSuchAlgorithmException, KeyManagementException {
                final String url = "charge/reversal?nsu=" + nsu;

                HttpRequest request = serviceHttp.buildHttpRequestGET(url, MKTOKEN);
                HttpResponse<String> response = serviceHttp.sendHttpRequest(request);

                System.out.println("");
                System.out.println("Response: " + response);
                System.out.println("Stats HTTP: " + response.statusCode() + " Version HTTP: " + response.version());
                System.out.println("Headers: " + response.headers());

                return null;
        }

        public static PinPad getPending()
                throws IOException, InterruptedException, NoSuchAlgorithmException, KeyManagementException {
                final String url = "charge/pending";

                HttpRequest request = serviceHttp.buildHttpRequestGET(url, MKTOKEN);
                HttpResponse<String> response = serviceHttp.sendHttpRequest(request);

                System.out.println("");
                System.out.println("Response: " + response.body());
                System.out.println("Stats HTTP: " + response.statusCode() + " Version HTTP: " + response.version());
                System.out.println("Headers: " + response.headers());

                return null;
        }

        public static PinPad display(String messageEncode)
                throws IOException, InterruptedException, NoSuchAlgorithmException, KeyManagementException {
                final String url = "pinpad/display?message=" + messageEncode;

                HttpRequest request = serviceHttp.buildHttpRequestGET(url, MKTOKEN);
                HttpResponse<String> response = serviceHttp.sendHttpRequest(request);

                System.out.println("");
                System.out.println("Response: " + response);
                System.out.println("Stats HTTP: " + response.statusCode() + " Version HTTP: " + response.version());
                System.out.println("Headers: " + response.headers());

                return null;
        }
}