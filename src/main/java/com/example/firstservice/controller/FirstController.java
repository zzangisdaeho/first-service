package com.example.firstservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequiredArgsConstructor
public class FirstController {

    private final Environment env;

    @GetMapping("/welcome")
    public String hello(){
        return "first service";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("first-request") String header){
        System.out.println(header);
        log.info(header);
        return "Hello in First Service.";
    }

    @GetMapping("/check")
    public String check(HttpServletRequest request){
        log.info("Server port = {}", request.getServerPort());
        return String.format("first check %s"
                , env.getProperty("local.server.port"));
    }
}
