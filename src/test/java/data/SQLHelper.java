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
    public static String getPurchaseStatus(String tableName) {
        var statusSQL = String.format("SELECT status FROM %s LIMIT 1;", tableName);
        try (var conn = getConn()) {
            System.out.println(Optional.ofNullable(QUERY_RUNNER.query(conn, statusSQL, new ScalarHandler<>())));
            return QUERY_RUNNER.query(conn, statusSQL, new ScalarHandler<>());
        }
    }
}