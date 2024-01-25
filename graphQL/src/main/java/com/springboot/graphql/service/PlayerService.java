package com.springboot.graphql.service;

import com.springboot.graphql.enums.Team;
import com.springboot.graphql.model.Player;
import com.springboot.graphql.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {


    private final PlayerRepository playerRepository;

    public Player findById(Long id) {
        return playerRepository.findById(id).orElseThrow(() -> new RuntimeException("Player not found"));
    }

    public Player createPlayer(String name, Team team) {
        return playerRepository.save(Player.builder().name(name).team(team).build());
    }

    public List<Player> findAllPlayers() {
        return playerRepository.findAll();
    }

    public void deletePlayer(Long id) {
        playerRepository.delete(playerRepository.findById(id).orElseThrow(() -> new RuntimeException("Player not found")));
    }
}
