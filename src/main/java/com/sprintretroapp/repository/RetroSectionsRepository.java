package com.sprintretroapp.repository;


import com.sprintretroapp.domain.RetroSection;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface RetroSectionsRepository extends ReactiveMongoRepository<RetroSection, String> {

  Flux<RetroSection> findRetroSectionBySprintBoardNumber(String sprintBoardNumber);

  Mono<RetroSection> findFirstRetroSectionBySectionName(String sectionName);
}

