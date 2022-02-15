package com.tp.todo.repository;

import com.tp.todo.entity.Note;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends CouchbaseRepository<Note, String> {
    List<Note> findByUserId(String userId);
}
