package com.tic.noli.game.repository;

import com.tic.noli.game.config.DBConnection;
import com.tic.noli.game.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {

    private final static String SAVE_USER_QUERY = "insert into users values (null, ?, ?, ?)";
    private final static String SAVE_USER_ROLE_QUERY = "insert into roles values (?, ?)";

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

        if (user.getRole() != null && !user.getRole().isEmpty()) {
            System.out.println("saves user");
            saveUserRole(connection, user);
        }

        return 0;
    }


    public void saveUserRole(Connection connection, User user) {
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USER_ROLE_QUERY);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getRole());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
