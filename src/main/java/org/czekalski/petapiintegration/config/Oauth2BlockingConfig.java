package org.czekalski.petapiintegration.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;


@Configuration
@EnableOAuth2Client
public class Oauth2BlockingConfig {


    @ConfigurationProperties(prefix = "security.oauth2.client.petapiintegration")
    @Bean
    public OAuth2ProtectedResourceDetails apiClientCredsDetails() {
        return new ClientCredentialsResourceDetails();
    }


    @Bean
    public OAuth2RestTemplate apiClientCredsRestTemplate(OAuth2ProtectedResourceDetails resourceDetails) {
        return new OAuth2RestTemplate(resourceDetails);
    }



}
