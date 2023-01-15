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
    public void createData(String nameIn, String typeIn, int priceIn, int pagesIn) throws SQLException {
        super.executeSqlStatement(String.format("""
                INSERT INTO ON_SELL (name, type, price, pages) VALUES ('%s', '%s', %s, %s)
                """,nameIn, typeIn, priceIn, pagesIn));
    }

    @Override
    public void getData() throws SQLException {
        Connection connectionT = super.getConnection();
        Statement stat = connectionT.createStatement();
        ResultSet resultSet = stat.executeQuery("SELECT * FROM ON_SELL");
        while(resultSet.next()) {
            String name = resultSet.getString("name");
            System.out.println("Наименование : "+ name +"| id: " +resultSet.getString("id"));
        }
    }

    @Override
    public void deleteID(int idDel) throws SQLException {
        Connection connectionT = super.getConnection();
        Statement stat = connectionT.createStatement();
        stat.executeUpdate("DELETE FROM ON_SELL WHERE id = "+ idDel);
        System.out.println("Удалена запись с ID - "+ idDel);
    }

    @Override
    public void soldID(int ifSell) throws SQLException {
        Connection connectionT = super.getConnection();
        Statement stat = connectionT.createStatement();
        ResultSet resultSet = stat.executeQuery("SELECT * FROM ON_SELL WHERE id = "+ifSell);
        while(resultSet.next()) {
            System.out.println("Продан товар с ID - "+ ifSell + "| стоимостью - "+ resultSet.getString("price"));
            deleteID(ifSell);
        }
    }

    @Override
    public void changeID(int id) throws SQLException {
        Connection connectionT = super.getConnection();
        Statement stat = connectionT.createStatement();
        stat.executeUpdate("");
    }
}
