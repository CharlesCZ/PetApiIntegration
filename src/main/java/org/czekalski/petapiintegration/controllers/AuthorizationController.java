package org.czekalski.petapiintegration.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationController {



    @Value("${messages.base-uri}")
    private String messagesBaseUri;

    @Autowired
    private OAuth2RestTemplate messagingClientClientCredsRestTemplate;


    @GetMapping(value = "/authorize", params = "grant_type=client_credentials")
    public String client_credentials_grant(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("AUTHENTICATION");
        System.out.println(authentication);
        String messages = this.messagingClientClientCredsRestTemplate.getForObject(this.messagesBaseUri, String.class);
        System.out.println(messages);


        return messages ;
    }



  /*  @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return login();
    }*/
}
