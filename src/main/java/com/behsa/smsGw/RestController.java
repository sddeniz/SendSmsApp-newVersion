package com.behsa.smsGw;


import com.behsa.smsGw.Entity.JwtResponse;
import com.behsa.smsGw.Entity.User;

import com.behsa.smsGw.Entity.UserLogin;
import com.behsa.smsGw.config.JwtTokenUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.net.URI;
import java.net.URISyntaxException;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin
@RequestMapping()
public class RestController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserrDetailsService userDetailsService;


    @Value("${token_url}")
    String tokenUrl;
    @Value("${sendSms_url}")
    String sendUrl;
    @Autowired
    private GetToken getToken;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(RestController.class);
    RestTemplate restTemplate = new RestTemplate();
    private void authenticate(String username, String password) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @PostMapping("login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserLogin request) throws Exception {

        authenticate(request.getP_USERNAME(), request.getP_PASSWORD());

        final UserDetails userDetails = userDetailsService.loadUserByUserpass(request.getP_USERNAME(),request.getP_PASSWORD());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));


    }

    @PostMapping ("send")

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
