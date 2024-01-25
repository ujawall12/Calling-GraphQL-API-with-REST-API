package com.springboot.iplmanagement.iplmanagement.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.iplmanagement.iplmanagement.model.Player;
import com.springboot.iplmanagement.iplmanagement.model.PlayerDetails;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class IplService {

    List<PlayerDetails> playerDetails = new ArrayList<>();
    @Value("${playerservice.url}")
    private String playerServiceUrl;

    public PlayerDetails getPlayerDetailsById(Long id) {
        return PlayerDetails.builder()
                .id(getPlayerDetails(id).getId())
                .name(getPlayerDetails(id).getName())
                .score(111)
                .wicket(1)
                .team(getPlayerDetails(id).getTeam())
                .build();
    }
    private Player getPlayerDetails(Long id) {

        ObjectMapper objectMapper = new ObjectMapper();
        WebClient webClient = WebClient.builder()
                .baseUrl(playerServiceUrl)
                .build();
        GraphQLWebClient graphQLWebClient = GraphQLWebClient.newInstance(webClient, objectMapper);
        return graphQLWebClient.post("query1.graphql", Map.of("id", id), Player.class).block();
    }
}
