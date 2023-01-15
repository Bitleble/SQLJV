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
            System.out.println("������������ : "+ name +" | ���� : "+resultSet.getString("price")+"\nid: " +resultSet.getString("id"));
        }
    }

    @Override
    public void deleteName(String ifDel) throws SQLException {
        Connection connectionT = super.getConnection();
        Statement stat = connectionT.createStatement();
        stat.executeUpdate(
                String.format("DELETE FROM ON_SELL WHERE name = '%s' LIMIT 1", ifDel));
        //System.out.println("������� ������ - "+ ifDel);
    }

    @Override
    public void soldID(String ifSell) throws SQLException {
        Connection connectionT = super.getConnection();
        Statement stat = connectionT.createStatement();
        ResultSet resultSet = stat.executeQuery(String.format("SELECT * FROM ON_SELL WHERE name = '%s' LIMIT 1",ifSell));
        while(resultSet.next())
            System.out.println("������ ����� - "+ ifSell + " | ���������� - "+ resultSet.getString("price"));

        deleteName(ifSell);
    }

    @Override
    public void changeID(int id, String chName, String chType, int chPrice, int chPages) throws SQLException {
        Connection connectionT = super.getConnection();
        Statement stat = connectionT.createStatement();
        // � ������ ��������� ��������� ������ � �������� ��� ���� �����, �� ���� ������� ������ ������� ���������
        stat.executeUpdate(String.format("UPDATE ON_SELL SET name = '%s', type = '%s', price = %s, pages = %s WHERE id = %s",chName,chType,chPrice,chPages,id));
    }
}
