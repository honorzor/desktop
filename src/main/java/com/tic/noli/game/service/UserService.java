package com.tic.noli.game.service;

import com.tic.noli.game.model.User;
import com.tic.noli.game.repository.UserRepository;

import java.sql.SQLException;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    public int saveUser(User user) throws SQLException {
        return userRepository.saveUser(user);
    }
}
