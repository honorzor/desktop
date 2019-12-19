package com.tic.noli.game.service;

import com.tic.noli.game.model.User;
import com.tic.noli.game.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    public int saveUser(User user) {
        return userRepository.saveUser(user);
    }
}
