package io.code.gamedb.services;

import io.code.gamedb.dto.GameDto;
import io.code.gamedb.models.Game;
import reactor.core.publisher.Mono;

public interface GameService {

    Mono<Game> create(GameDto gameDto);
    Mono<Game> get(int gameId);

}
