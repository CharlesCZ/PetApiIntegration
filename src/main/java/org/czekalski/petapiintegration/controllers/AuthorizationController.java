package org.czekalski.petapiintegration.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.czekalski.petapiintegration.apiClient.v1.dto.AnimalDto;
import org.czekalski.petapiintegration.apiClient.v1.dto.AnimalsListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AuthorizationController {

    @Value("${messages.base-uri}")
    private String messagesBaseUri;

    @Autowired
    private OAuth2RestTemplate auth2RestTemplatee;

    @GetMapping(value = "/")
    public String getHello() {



        return "hello" ;
    }

    @GetMapping(value = "/authorize", params = "grant_type=client_credentials")
    public String clientCredentialsGrant(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("AUTHENTICATION");
        System.out.println(authentication);
        String messages = this.auth2RestTemplatee.getForObject(this.messagesBaseUri, String.class);
        System.out.println(messages);


        return messages ;
    }


    private static AnimalDto toAnimalDto(String jsonData) throws IOException {
        ObjectMapper om = new ObjectMapper();
        return om.readValue(jsonData, AnimalDto.class);
    }


    @GetMapping(value = "/animal")
    public  AnimalDto animal() throws IOException {
String json="{\n" +
        "        \"id\": 1111,\n" +
        "        \"organization_id\": \"NJ65\",\n" +
        "        \"url\": \"https://www.petfinder.com/dog/slick-1111/nj/lindenwold/animal-adoption-center-nj65/?referrer_id=d08eabd0-f16d-4f6e-ab8a-d15115929e6f\",\n" +
        "        \"type\": \"Dog\",\n" +
        "        \"species\": \"Dog\",\n" +
        "        \"breeds\": {\n" +
        "            \"primary\": \"Labrador Retriever\",\n" +
        "            \"secondary\": null,\n" +
        "            \"mixed\": true,\n" +
        "            \"unknown\": false\n" +
        "        },\n" +
        "        \"colors\": {\n" +
        "            \"primary\": null,\n" +
        "            \"secondary\": null,\n" +
        "            \"tertiary\": null\n" +
        "        },\n" +
        "        \"age\": \"Senior\",\n" +
        "        \"gender\": \"Male\",\n" +
        "        \"size\": \"Medium\",\n" +
        "        \"coat\": null,\n" +
        "        \"attributes\": {\n" +
        "            \"spayed_neutered\": true,\n" +
        "            \"house_trained\": false,\n" +
        "            \"declawed\": null,\n" +
        "            \"special_needs\": false,\n" +
        "            \"shots_current\": true\n" +
        "        },\n" +
        "        \"environment\": {\n" +
        "            \"children\": false,\n" +
        "            \"dogs\": null,\n" +
        "            \"cats\": null\n" +
        "        },\n" +
        "        \"tags\": [],\n" +
        "        \"name\": \"Slick\",\n" +
        "        \"description\": \"Slick is an 11 year old senior who is ready to spend his golden years with you. He would prefer...\",\n" +
        "        \"photos\": [\n" +
        "            {\n" +
        "                \"small\": \"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/1111/1/?bust=1496239741&width=100\",\n" +
        "                \"medium\": \"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/1111/1/?bust=1496239741&width=300\",\n" +
        "                \"large\": \"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/1111/1/?bust=1496239741&width=600\",\n" +
        "                \"full\": \"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/1111/1/?bust=1496239741\"\n" +
        "            },\n" +
        "            {\n" +
        "                \"small\": \"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/1111/2/?bust=1496239741&width=100\",\n" +
        "                \"medium\": \"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/1111/2/?bust=1496239741&width=300\",\n" +
        "                \"large\": \"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/1111/2/?bust=1496239741&width=600\",\n" +
        "                \"full\": \"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/1111/2/?bust=1496239741\"\n" +
        "            },\n" +
        "            {\n" +
        "                \"small\": \"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/1111/3/?bust=1496239741&width=100\",\n" +
        "                \"medium\": \"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/1111/3/?bust=1496239741&width=300\",\n" +
        "                \"large\": \"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/1111/3/?bust=1496239741&width=600\",\n" +
        "                \"full\": \"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/1111/3/?bust=1496239741\"\n" +
        "            }\n" +
        "        ],\n" +
        "        \"status\": \"adopted\",\n" +
        "        \"status_changed_at\": \"2009-09-29T15:17:37+0000\",\n" +
        "        \"published_at\": \"2002-03-26T00:00:00+0000\",\n" +
        "        \"distance\": null,\n" +
        "        \"contact\": {\n" +
        "            \"email\": \"info@animaladoption.com\",\n" +
        "            \"phone\": \"(856) 435-9116\",\n" +
        "            \"address\": {\n" +
        "                \"address1\": \"501 Berlin Road North\",\n" +
        "                \"address2\": null,\n" +
        "                \"city\": \"Lindenwold\",\n" +
        "                \"state\": \"NJ\",\n" +
        "                \"postcode\": \"08021\",\n" +
        "                \"country\": \"US\"\n" +
        "            }\n" +
        "        },\n" +
        "        \"_links\": {\n" +
        "            \"self\": {\n" +
        "                \"href\": \"/v2/animals/1111\"\n" +
        "            },\n" +
        "            \"type\": {\n" +
        "                \"href\": \"/v2/types/dog\"\n" +
        "            },\n" +
        "            \"organization\": {\n" +
        "                \"href\": \"/v2/organizations/nj65\"\n" +
        "            }\n" +
        "        }\n" +
        "}";

AnimalDto animalDto= toAnimalDto(json);
        System.out.println( animalDto);
        return  toAnimalDto(json) ;
    }

    @GetMapping(value = "/authorize2", params = "grant_type=client_credentials")
    public AnimalsListDto clientCredentialsGrant2(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("AUTHENTICATION");
        System.out.println(authentication);
        AnimalsListDto animalsListDto = this.auth2RestTemplatee.getForObject(this.messagesBaseUri,  AnimalsListDto.class);
        System.out.println( animalsListDto);


        return  animalsListDto ;
    }

}
