package io.code.gamedb.services.impl;

import io.code.gamedb.dto.GameDto;
import io.code.gamedb.kafka.KafkaProducer;
import io.code.gamedb.models.Game;
import io.code.gamedb.repositories.GameRepository;
import io.code.gamedb.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class GameServiceImpl implements GameService {


    private final GameRepository gameRepository;
    private final KafkaProducer kafkaProducer;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository,KafkaProducer kafkaProducer) {
        this.gameRepository = gameRepository;
        this.kafkaProducer = kafkaProducer;
    }

    @Override
    public Mono<Game> create(GameDto gameDto) {

        Game gameModel = new Game();
        gameModel.setGenre(gameDto.getGenre());
        gameModel.setManufacturer(gameDto.getManufacturer());
        gameModel.setName(gameDto.getName());
        gameModel.setRating(null);
        gameModel.setReleaseDate(gameDto.getReleaseDate());

        System.out.println("saving game data in mongo.");
        Mono<Game>result = gameRepository.save(gameModel);

        // this producer sends the data in avro format.
        result.doOnSuccess(kafkaProducer::send);

        return result;
    }

    @Override
    public Mono<Game> get(int gameId) {

        return gameRepository.findById(gameId);

    }
}
