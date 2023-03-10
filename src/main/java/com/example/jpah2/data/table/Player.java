package com.example.jpah2.data.table;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Entity
@Table(name = "player")
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    @CreationTimestamp
    private LocalDateTime createDt;
    @UpdateTimestamp
    private LocalDateTime updateDt;

    @ManyToOne(targetEntity = Team.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "teamId")
    private Team team;

    public com.example.jpah2.domain.entity.Player toEntity() {
        return new com.example.jpah2.domain.entity.Player();
    }

    public static Player of(String name, Integer age) {
        var player = new Player();
        player.name = name;
        player.age = age;
        return player;
    }
}
