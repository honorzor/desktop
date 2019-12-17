package com.tic.noli.game.config;

import com.tic.noli.game.util.FileUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInit {

    private final static String CREATE_TABLE_USERS_QUERY = FileUtil.readStringFromFile("/query/CREATE_TABLE_USERS_QUERY.sql");


    public static void init() {
        System.out.println("init scripts");
    }

    static {

        try (Connection connection = DBConnection.getConnection()) {

            initUserTable(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static void initUserTable(Connection connection) throws SQLException {
        final Statement statement = connection.createStatement();
        statement.execute(CREATE_TABLE_USERS_QUERY);
        statement.close();
    }
}
