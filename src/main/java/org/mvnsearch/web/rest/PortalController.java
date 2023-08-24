package org.mvnsearch.web.rest;

import org.mvnsearch.service.HttpBinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
public class PortalController {
    @Autowired
    private HttpBinService httpBinService;

    @GetMapping("/my-ip")
    public Mono<String> myIp() {
        return httpBinService.myIp().map(HttpBinService.MyIp::origin);
    }

}
