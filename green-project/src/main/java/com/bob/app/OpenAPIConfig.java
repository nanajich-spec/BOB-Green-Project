package com.bob.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {

  @Value("${app.openapi.dev-url}")
  private String devUrl;

  @Value("${app.openapi.prod-url}")
  private String prodUrl;

  @Bean
  public OpenAPI myOpenAPI() {
    Server devServer = new Server();
    devServer.setUrl(devUrl);
    devServer.setDescription("Server URL in Development environment");

    Server prodServer = new Server();
    prodServer.setUrl(prodUrl);
    prodServer.setDescription("Server URL in Production environment");

    Contact contact = new Contact();
    contact.setEmail("noncbs.developers@bankofbaroda.com");
    contact.setName("RPT");
    contact.setUrl("https://noncbsuat.bankofbaroda.co.in/greenfinance");

    License mitLicense = new License().name("BOB License").url("https://noncbsuat.bankofbaroda.co.in/greenfinance");

    Info info = new Info()
        .title("Green Finance API")
        .version("1.0")
        .contact(contact)
        .description("This API exposes endpoints to manage RPT project api.").termsOfService("https://noncbsuat.bankofbaroda.co.in/greenfinance")
        .license(mitLicense);

    return new OpenAPI().info(info).servers(Arrays.asList(devServer, prodServer));
  }
}