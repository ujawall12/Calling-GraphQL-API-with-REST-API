package com.springboot.iplmanagement.iplmanagement.controller;

import com.springboot.iplmanagement.iplmanagement.model.PlayerDetails;
import com.springboot.iplmanagement.iplmanagement.service.IplService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IplController {

    private final IplService iplService;

    @GetMapping("/playerDetails")
    public ResponseEntity<PlayerDetails> getDetails(@RequestParam Long id) {
        return new ResponseEntity<>(iplService.getPlayerDetailsById(id), HttpHeaders.EMPTY, HttpStatus.FOUND);
    }
}
