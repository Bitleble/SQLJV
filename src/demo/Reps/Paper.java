package demo.Reps;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Paper extends Base implements createStuff {

    public Paper() throws SQLException {
        super("");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("""
                CREATE TABLE ON_SELL (
                    id INT AUTO_INCREMENT,
                    name VARCHAR(255) NOT NULL,
                    type VARCHAR(255),
                    price INT,
                    pages INT);
                    """);
    }

    @Override
    public void createData() throws SQLException {
        super.executeSqlStatement("""
                INSERT INTO ON_SELL (name, type, price, pages) VALUES ('Угол Шара', 'BOOK', 224, 154)
                """);
        super.executeSqlStatement("""
                INSERT INTO ON_SELL (name, type, price, pages) VALUES ('SQUARE2', 'Газета', 2243, 1544)
                """);
    }

    @Override
    public void getData() throws SQLException {
        Connection connectionT = super.getConnection();
        Statement stat = connectionT.createStatement();
        ResultSet resultSet = stat.executeQuery("SELECT * FROM ON_SELL");
        while(resultSet.next()) {
            String name = resultSet.getString("name");
            System.out.println("Наименование : "+name);
        }
    }
}
