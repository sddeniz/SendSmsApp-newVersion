package com.behsa.smsGw;

import com.behsa.smsGw.Entity.User;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.net.URI;
import java.net.URISyntaxException;

@org.springframework.web.bind.annotation.RestController
@RequestMapping()
public class RestController {

    @Value("${token_url}")
    String tokenUrl;
    @Value("${sendSms_url}")
    String sendUrl;
    @Autowired
    private GetToken getToken;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(RestController.class);
    RestTemplate restTemplate = new RestTemplate();

    @PostMapping("login")
    public String login(@RequestParam String username, @RequestParam String password) {

    }

    @RequestMapping("send")

    public ResponseEntity<?> send(@RequestBody User requestMessage) throws URISyntaxException {
        if (requestMessage == null) {
            return null;
        }
        logger.info("done");
        String token = getToken.gettoken(tokenUrl);
        logger.info("get token");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("application/json"));
        headers.setBearerAuth("bearer" + " " + token);
        HttpEntity<User> request = new HttpEntity<>(requestMessage, headers);
        URI send = new URI(sendUrl);
        headers.setLocation(send);
        ResponseEntity<?> response = restTemplate.postForEntity(send, request, User.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            logger.info("successful");
        } else {
            logger.info("failed");
        }
        return response;

    }
}
