package roomescape.db;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

@JdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class JdbcConnectionTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void connect() {
        try (Connection connection = jdbcTemplate.getDataSource().getConnection()) {
            assertThat(connection).isNotNull();
            assertThat(connection.getCatalog()).isEqualTo("DATABASE");
            assertTableExists(connection, "RESERVATION");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    void assertTableExists(Connection connection, String tableName) throws SQLException {
        assertThat(connection.getMetaData().getTables(null, null, tableName, null).next()).isTrue();
    }
}
