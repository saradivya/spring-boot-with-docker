package com.sprintretroapp.repository;

import com.sprintretroapp.domain.RetroSectionNotes;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetroSectionNotesRepository extends ReactiveMongoRepository<RetroSectionNotes, String> {

}
