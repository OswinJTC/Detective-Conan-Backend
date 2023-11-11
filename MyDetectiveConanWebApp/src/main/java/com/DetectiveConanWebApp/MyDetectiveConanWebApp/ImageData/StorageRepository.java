package com.DetectiveConanWebApp.MyDetectiveConanWebApp.ImageData;

import com.DetectiveConanWebApp.MyDetectiveConanWebApp.ImageData.ImageData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StorageRepository extends MongoRepository<ImageData, String> {
    Optional<ImageData> findByName(String name);
}
