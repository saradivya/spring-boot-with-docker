package com.sprintretroapp.repository;

import com.sprintretroapp.domain.RetroBoard;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface RetroBoardRepository extends ReactiveMongoRepository<RetroBoard, String> {

  Mono<RetroBoard> findFirstBySprintBoardNumber(String sprintBoardNumber);
}
