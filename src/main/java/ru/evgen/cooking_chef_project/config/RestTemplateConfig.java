package ru.evgen.cooking_chef_project.config;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;


import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;


@Configuration
public class RestTemplateConfig {

    /* Так можно настроить если делать запрос по http (не по https) */
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


//    @Bean
//    public RestTemplate restTemplate() throws KeyManagementException, NoSuchAlgorithmException,
//            KeyStoreException {
//
//        TrustStrategy acceptingTrustStrategy;
//        acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
//
//        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
//                .loadTrustMaterial(null, acceptingTrustStrategy)
//                .build();
//
//        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
//
//        CloseableHttpClient httpClient = HttpClients.custom()
//                .setSSLSocketFactory(csf)
//                .build();
//
//        HttpComponentsClientHttpRequestFactory requestFactory =
//                new HttpComponentsClientHttpRequestFactory();
//
//        requestFactory.setHttpClient(httpClient);
//
//        RestTemplate restTemplate = new RestTemplate(requestFactory);
//        return  restTemplate;
//    }

}
