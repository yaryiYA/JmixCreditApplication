package com.company.creditapplication.webclient;

import com.company.creditapplication.dto.PassportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.util.List;
import java.util.UUID;

@Component
public class ClientPass {

    private final WebClient webClient;

    private String baseUrl = "http://localhost:8081/passport";

    @Autowired
    public ClientPass() {
        HttpClient httpClient = HttpClient.
                create()
                .port(8085);

        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }


    public List<PassportDto> findAll() {
        return webClient.get()
                .uri("/all")
                .retrieve()
                .bodyToFlux(PassportDto.class)
                .collectList()
                .block();
    }


    public PassportDto findByUUID(UUID uuid) {
        return webClient.get()
                .uri("/"+ uuid)
                .retrieve()
                .bodyToMono(PassportDto.class)
                .block();
    }


    public PassportDto create(PassportDto passportDto) {
        return webClient.post()
                .uri("/create")
                .bodyValue(passportDto)
                .retrieve()
                .bodyToMono(PassportDto.class)
                .block();

    }
//
//
//    public Mono<EmployeeDTOv1> update(EmployeeDTOv1 employee) {
//        return null;
//    }
//
//
//    public Mono<Void> delete(UUID uuid) {
//        return null;
//    }

}
