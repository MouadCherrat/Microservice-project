//package com.hps.user_service.config;
//
//import feign.RequestInterceptor;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
//import org.springframework.security.oauth2.client.registration.ClientRegistration;
//import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
//
//@Configuration
//
//public class OAuthFeignConfig {
//
//    public static final String CLIENT_REGISTRATION_ID = "keycloak";
//
//    private final OAuth2AuthorizedClientService oAuth2AuthorizedClientService;
//    private final ClientRegistrationRepository clientRegistrationRepository;
//
//    public OAuthFeignConfig(OAuth2AuthorizedClientService oAuth2AuthorizedClientService,
//                            ClientRegistrationRepository clientRegistrationRepository) {
//        this.oAuth2AuthorizedClientService = oAuth2AuthorizedClientService;
//        this.clientRegistrationRepository = clientRegistrationRepository;
//    }
//
//    @Bean
//    public RequestInterceptor requestInterceptor() {
//        ClientRegistration clientRegistration = clientRegistrationRepository.findByRegistrationId(CLIENT_REGISTRATION_ID);
//        OAuthClientCredentialsFeignManager clientCredentialsFeignManager =
//                new OAuthClientCredentialsFeignManager(authorizedClientManager(), clientRegistration);
//        return requestTemplate -> {
//            requestTemplate.header("Authorization", "Bearer " + clientCredentialsFeignManager.getAccessToken());
//        };
//    }
//
//}
