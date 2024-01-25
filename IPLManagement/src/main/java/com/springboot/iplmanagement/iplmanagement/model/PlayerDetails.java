package com.springboot.iplmanagement.iplmanagement.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerDetails {


    Long id;
    String name;
    String team;
    Integer wicket;
    Integer score;
    Integer fairplayScore;

}
