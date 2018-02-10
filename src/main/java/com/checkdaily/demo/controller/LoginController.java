package com.checkdaily.demo.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/login")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping(method = RequestMethod.GET)
    public Map<String, Object> getSessionKey(@PathParam("code") String code){

        final String uri = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type="+ code;

        RestTemplate restTemplate = new RestTemplate();

        String userAuth = restTemplate.getForObject(uri, String.class);
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        logger.info("test--------"+userAuth);
        response.put("message", "userAuth get successfully");
        response.put("userAuth",userAuth);
        return response;
    }
}
