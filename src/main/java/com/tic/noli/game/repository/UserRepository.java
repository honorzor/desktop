package com.tic.noli.game.repository;

import com.tic.noli.game.config.DBConnection;
import com.tic.noli.game.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    private final static String SAVE_USER_QUERY = "insert into users values (null, ?, ?, ?)";
    private final static String SAVE_USER_ROLE_QUERY = "insert into roles values (?, ?)";
    private final static String GET_USER_BY_NAME_QUERY = "select * from users where name = ?";

    public int saveUser(User user)  throws SQLException{
        final Connection connection = DBConnection.getConnection();

            final PreparedStatement statement = connection.prepareStatement(SAVE_USER_QUERY);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());

            final int i = statement.executeUpdate();

            if (user.getRole() != null && !user.getRole().isEmpty()) {
                System.out.println("saves user");
                saveUserRole(connection, user);
            }

            return i;

    }


    public void saveUserRole(Connection connection, User user) {
        try {
            final PreparedStatement getUserStatement = connection.prepareStatement(GET_USER_BY_NAME_QUERY);
            getUserStatement.setString(1, user.getName());
            final ResultSet resultSet = getUserStatement.executeQuery();

            final User userFromBase = getUserFromBase(resultSet);

            final PreparedStatement saveUserStatement = connection.prepareStatement(SAVE_USER_ROLE_QUERY);
            saveUserStatement.setInt(1, userFromBase.getId());
            saveUserStatement.setString(2, user.getRole());
            saveUserStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User getUserFromBase(ResultSet resultSet) throws SQLException {
        final User userFromBase = new User();
        while (resultSet.next()){
            String name = resultSet.getString("name");
            Integer id = resultSet.getInt("id");
            System.out.println(id);
            userFromBase.setName(name);
            userFromBase.setId(id);
        }
        return userFromBase;
    }


}
