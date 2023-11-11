package com.DetectiveConanWebApp.MyDetectiveConanWebApp.Vote;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends MongoRepository<Vote, ObjectId> {
    Optional<Vote> findBytopicId(String topicId);
}