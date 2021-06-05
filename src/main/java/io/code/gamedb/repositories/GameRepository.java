package io.code.gamedb.repositories;

import io.code.gamedb.models.Game;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends ReactiveCrudRepository<Game,Integer> {

}
