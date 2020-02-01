package com.esms.repository;


import java.util.List;
import com.esms.model.Learn;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface LearningRepository extends ReactiveMongoRepository<Learn, String> {
}

