package com.tic.noli.game.repository;

import com.tic.noli.game.config.DBConnection;
import com.tic.noli.game.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {

    private final static String SAVE_USER_QUERY = "insert into users values (null, ?, ?, ?)";

    public int saveUser(User user) {
        final Connection connection = DBConnection.getConnection();

        try {
            final PreparedStatement statement = connection.prepareStatement(SAVE_USER_QUERY);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
