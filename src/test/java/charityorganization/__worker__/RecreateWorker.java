package charityorganization.__worker__;

import org.springframework.stereotype.Component;

import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class RecreateWorker {

    public static void recreatePostgresDatabase(String dbName, String username) throws Exception {
        try (var connection = DriverManager.getConnection("jdbc:postgresql://localhost:10432/charity", "postgres", "")) {

            while (true) try (var statement = connection.createStatement()) {
                statement.execute("drop database " + dbName);
                break;
            } catch (SQLException e) {
                if ("3D000".equals(e.getSQLState())) {
                    break;
                }

                if ("55006"/*эта ошибка возникает если к БД кто-то приконечен*/.equals(e.getSQLState())) {

                    // отконекчиваем всех, кто приконектился
                    try (var statement = connection.createStatement()) {
                        statement.execute("SELECT pg_terminate_backend(pg_stat_activity.pid)\n" + "FROM pg_stat_activity\n" + "WHERE pg_stat_activity.datname = '" + dbName + "'");
                    }

                    //дропаем БД ещё раз
                    continue;

                }

                throw new RuntimeException("JyhSBz4pvO :: SQLException with e.getSQLState() = `" + e.getSQLState() + '`', e);
            }

            try (var statement = connection.createStatement()) {
                statement.execute("create database " + dbName);
            }
            try (var statement = connection.createStatement()) {
                statement.execute("GRANT ALL ON DATABASE " + dbName + " TO " + username);
            }

        }
    }

}
