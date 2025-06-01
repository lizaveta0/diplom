package data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class SQLHelper {
    private static final QueryRunner QUERY_RUNNER = new QueryRunner();

    private SQLHelper() {
    }

    private static Connection getConn() throws SQLException {
        return DriverManager.getConnection(System.getProperty("db.url"), "app", "pass");
    }

    @SneakyThrows
    public static String getPurchaseStatus() {
        var statusSQL = "SELECT status FROM payment_entity LIMIT 1;";
        try (var conn = getConn()) {
            System.out.println(Optional.ofNullable(QUERY_RUNNER.query(conn, statusSQL, new ScalarHandler<>())));
            return QUERY_RUNNER.query(conn, statusSQL, new ScalarHandler<>());
        }
    }
}