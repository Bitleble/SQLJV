package demo.Reps;

import java.awt.*;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    public ArrayList<String> getData() throws SQLException {
        Connection connectionT = super.getConnection();
        Statement stat = connectionT.createStatement();
        ResultSet resultSet = stat.executeQuery("SELECT * FROM ON_SELL");
        ArrayList<String> forShow = new ArrayList<>();
        while(resultSet.next()) {
            String name = resultSet.getString("name");
            forShow.add("Наименование : "+ name +" | Цена : "+resultSet.getString("price")+" | id: " +resultSet.getString("id")+"\n");
        }
        return forShow;
    }

    @Override
    public void deleteName(String ifDel) throws SQLException {
        Connection connectionT = super.getConnection();
        Statement stat = connectionT.createStatement();
        stat.executeUpdate(
                String.format("DELETE FROM ON_SELL WHERE name = '%s' LIMIT 1", ifDel));
        //System.out.println("Удалена запись - "+ ifDel);
    }

    @Override
    public String soldID(String ifSell) throws SQLException {
        Connection connectionT = super.getConnection();
        Statement stat = connectionT.createStatement();
        ResultSet resultSet = stat.executeQuery(String.format("SELECT * FROM ON_SELL WHERE name = '%s' LIMIT 1",ifSell));
        String info = null;
        while(resultSet.next())
            info = ("Продан товар: "+ ifSell + "\n стоимостью: "+ resultSet.getString("price"));
        deleteName(ifSell);
        return info;
    }

    @Override
    public void changeID(int id, String chName, String chType, int chPrice, int chPages) throws SQLException {
        Connection connectionT = super.getConnection();
        Statement stat = connectionT.createStatement();
        // в идеале открывать отдельное окошко и изменять что тебе нужно, но пока пропишу полное разовое изменение
        stat.executeUpdate(String.format("UPDATE ON_SELL SET name = '%s', type = '%s', price = %s, pages = %s WHERE id = %s",chName,chType,chPrice,chPages,id));
    }
}
