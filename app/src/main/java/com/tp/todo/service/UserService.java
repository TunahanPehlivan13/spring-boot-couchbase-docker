package com.tp.todo.service;

import com.tp.todo.entity.User;
import com.tp.todo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserService {

    User saveUser(User user);

    Optional<User> findUserBy(String id);

    boolean checkUserExist(String email, String password);

    @Service
    @RequiredArgsConstructor
    class DefaultUserService implements UserService {

        private final UserRepository userRepository;

        @Override
        public User saveUser(User user) {
            return userRepository.save(user);
        }

        @Override
        @Transactional(readOnly = true)
        public Optional<User> findUserBy(String id) {
            return userRepository.findById(id);
        }

        @Override
        @Transactional(readOnly = true)
        public boolean checkUserExist(String email, String password) {
            return userRepository.existsByEmailAndPassword(email, password);
        }
    }
}
