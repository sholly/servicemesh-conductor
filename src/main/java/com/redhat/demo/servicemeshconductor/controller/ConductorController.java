package com.redhat.demo.servicemeshconductor.controller;

import com.redhat.demo.servicemeshconductor.restclient.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ConductorController {

    private static AtomicLong callCount = new AtomicLong(0);

    @Autowired
    private ClientService clientService;

    @GetMapping("/conduct")
    public String leaf1() {
        return new StringBuilder("conductor")
                .append(", call Count: " + callCount.incrementAndGet())
                .toString();
    }

    @GetMapping("/callleaf12")
    public String callLeaf12() {
        String response = clientService.callLeaf12();
        StringBuilder finalResponse = new StringBuilder("conductor ")
                .append(callCount.incrementAndGet())
                .append(" -> ")
                .append(response);
        return finalResponse.toString();
    }

    @GetMapping("/callleaf21")
    public String callLeaf21() {
        String response = clientService.callLeaf21();
        StringBuilder finalResponse = new StringBuilder("conductor " )
                .append(callCount.incrementAndGet())
                .append(" -> ")
                .append(response);
        return finalResponse.toString();
    }
}
