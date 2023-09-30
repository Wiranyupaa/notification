package com.example.project1.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.project1.pojo.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByUserId(String userId);
}
