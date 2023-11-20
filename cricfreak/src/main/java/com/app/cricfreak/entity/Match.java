package com.app.cricfreak.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cricket_match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matchId;

    private String teamHeading;
    private String matchNumberVenue;
    private String battingTeam;
    private String battingTeamScore;
    private String bowlTeam;
    private String bowlTeamScore;
    private String liveText;
    private String matchLink;
    private String textComplete;
    @Enumerated
    private MatchStatus status;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Instant date;

    public void setMatchStatus()
    {
        if (textComplete.isBlank()){
            this.status=MatchStatus.LIVE;
        }
        else {
            this.status=MatchStatus.COMPLETED;
        }
    }



}
