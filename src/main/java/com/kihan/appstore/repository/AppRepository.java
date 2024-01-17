package com.kihan.appstore.repository;

import com.kihan.appstore.entity.App;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppRepository extends MongoRepository<App, String> {
    // Named query
    // Query methods
    public App findByName(String name);
}
