package com.springboot.graphql.controller;

import com.springboot.graphql.enums.Team;
import com.springboot.graphql.model.Player;
import com.springboot.graphql.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PlayerController {

    private final PlayerService playerService;

    @QueryMapping
    public Player getPlayer(@Argument Long id) {
        Player player = playerService.findById(id);
        log.info("-----------> PlayerController------------->player: {} {} {}", player.getName(), player.getTeam(), player.getId());
        return player;
    }

    @QueryMapping
    public List<Player> getPlayers() {
        return playerService.findAllPlayers();
    }

    @MutationMapping
    public Player createPlayer(@Argument String name, @Argument Team team) {
        return playerService.createPlayer(name, team);
    }

    @MutationMapping
    public void deletePlayer(@Argument Long id) {
        playerService.deletePlayer(id);
    }
}
