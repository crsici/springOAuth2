package com.f4k.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.InMemoryClientDetailsService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sic.org on 9/9/2017.
 */
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
//    @Bean
//    ClientDetailsService clientDetailsService(){
//        Map<String, ClientDetails> clientDetailsStore = new HashMap<String, ClientDetails>();
//        BaseClientDetails clientDetails = new BaseClientDetails("client", "resource", null, null, "read,write");
//        clientDetailsStore.put("client", clientDetails);
//
//        InMemoryClientDetailsService clientDetailsService = new InMemoryClientDetailsService();
//        clientDetailsService.authorizedGrantTypes("authorization_code","refresh_token","password");
//        clientDetailsService.setClientDetailsStore(clientDetailsStore);
//        return   clientDetailsService;
//    }

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client")
                .authorizedGrantTypes("password")
                .authorities("ROLE_CLIENT")
                .scopes("read", "write")
                .resourceIds("ResourceID")
                .secret("officialclientsecret")
                .redirectUris("https://www.someurl.com/");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager);
    }
}
