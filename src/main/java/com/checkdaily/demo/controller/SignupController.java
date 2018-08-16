package com.checkdaily.demo.controller;
import com.checkdaily.demo.entity.User;
import com.checkdaily.demo.service.SignupService;
import com.mongodb.util.JSON;
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
@RequestMapping("/signup")
public class SignupController {
    private static final Logger logger = LoggerFactory.getLogger(SignupController.class);
    SignupService signupService;
    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> signupUser(@RequestBody User user){

        signupService.createUser(user);
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        logger.info("Signup--------");
        response.put("Message:", "signup success");
        response.put("User:",user);
        return response;
    }
}
