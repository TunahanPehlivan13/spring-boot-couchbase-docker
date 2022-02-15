package com.tp.todo.repository;

import com.tp.todo.entity.User;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CouchbaseRepository<User, String> {
    boolean existsByEmailAndPassword(String email, String password);
}
