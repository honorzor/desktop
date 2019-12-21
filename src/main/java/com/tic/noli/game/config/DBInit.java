package com.tic.noli.game.config;

import com.tic.noli.game.util.FileUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DBInit {

    private final static String CREATE_TABLE_USERS_QUERY = FileUtil.readStringFromFile("/query/CREATE_TABLES_QUERY.sql");


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


    private static void initUserTable(Connection connection) {

        splitQueries(CREATE_TABLE_USERS_QUERY).forEach(query -> {
            execute(connection, query);
        });
    }


    private static void execute(Connection connection, String query) {
        try {
            final Statement statement = connection.createStatement();
            statement.execute(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static List<String> splitQueries(String queries) {
        return Arrays
                .stream(queries.trim().split(";"))
                .peek(query -> query = query + ";")
                .collect(Collectors.toList());
    }
}
