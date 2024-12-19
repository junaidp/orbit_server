package com.example.up;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncentiveSetupRepository extends MongoRepository<IncentiveSetup, String> {
}
