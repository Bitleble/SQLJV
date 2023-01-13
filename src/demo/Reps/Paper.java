package demo.Reps;

import java.sql.SQLException;

public class Paper extends Base implements createStuff {

    public Paper() throws SQLException {
        super("table");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("""
                CREATE TABLE ON_SELL (
                    id INT,
                    name VARCHAR(255) NOT NULL,
                    type VARCHAR(255),
                    price INT,
                    pages INT);
                    """);
    }
}
