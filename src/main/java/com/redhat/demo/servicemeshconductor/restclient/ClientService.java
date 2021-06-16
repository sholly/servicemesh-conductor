package com.redhat.demo.servicemeshconductor.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientService {

    @Value("${leaf1.hostname}")
    private String leaf1Hostname;
    @Value("${leaf1.portnum}")
    private String leaf1Port;

    @Value("${leaf2.hostname}")
    private String leaf2Hostname;

    @Value("${leaf2.portnum}")
    private String leaf2Port;

    private String leaf12path = "/callleaf2";
    private String leaf21path = "/callleaf1";

    @Autowired
    private RestTemplate restTemplate;


    public String callLeaf12() {
        String url = "http://" + leaf1Hostname + ":" + leaf1Port + leaf12path;
        System.out.println(url);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }

    public String callLeaf21() {
        String url = "http://" + leaf2Hostname + ":" + leaf2Port + leaf21path;
        System.out.println(url);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }
}
