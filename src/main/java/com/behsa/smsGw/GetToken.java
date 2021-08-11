package com.behsa.smsGw;

import com.behsa.smsGw.Entity.Token;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class GetToken {
    public String gettoken(String url){
        System.out.println("URL:" + url);
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<Token> response=restTemplate.getForEntity(url, Token.class);
        System.out.println("*******"+ response);
        return response.getBody().getToken();
    }

}
