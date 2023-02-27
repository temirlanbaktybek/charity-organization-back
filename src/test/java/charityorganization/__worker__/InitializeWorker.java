package charityorganization.__worker__;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InitializeWorker {

    public static String personTableName;

    public static void initializePostgresDatabase(String dbName, String username) throws Exception {
        try (var connection = DriverManager.getConnection("jdbc:postgresql://localhost:10432/", username, "")) {
            try (var statement = connection.createStatement()) {
                statement.execute("create database " + dbName);
                System.out.println("xlCM6GiOXy :: charity DATABASE created!!!");

                createTables(statement);

            }
        }
    }

    private static void createTables(Statement statement) {
        try (statement) {

            StringBuilder sql = new StringBuilder();

            sql.append("create table ");
            sql.append(personTableName);
            sql.append(" ( ");
            sql.append("id bigserial primary key, ");
            sql.append("email varchar (50) not null, ");
            sql.append("encryptedPassword varchar (50) not null, ");
            sql.append("surname varchar (50) not null, ");
            sql.append("name varchar (50) not null, ");
            sql.append("actual varchar(10) not null, ");
            sql.append("accessLevel varchar(20) not null ");
            sql.append("); ");

            statement.execute(sql.toString());


        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }


    }
}
