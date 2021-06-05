package io.code.gamedb.controllers;

import io.code.gamedb.dto.GameDto;
import io.code.gamedb.models.Game;
import io.code.gamedb.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/game")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public Mono<Game> createGame(@RequestBody GameDto gameDto) {
        return gameService.create(gameDto);
    }

}
