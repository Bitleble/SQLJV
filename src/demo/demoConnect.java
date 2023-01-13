package demo;

import demo.Reps.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class demoConnect {


    public static final String DB_URL = "jdbc:h2:C:/Users/VV/IdeaProjects/SQLJV/SQL/demoConnect";
    public static final String DB_Driver = "org.h2.Driver";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    Paper papers;


    public demoConnect() throws SQLException, ClassNotFoundException {
        Class.forName(DB_Driver);
        // Инициализируем таблицы
        papers = new Paper();
    }

    // Создание всех таблиц и ключей между ними
    public void createTablesAndForeignKeys() throws SQLException {
        papers.createTable();
    }




    public static void main(String[] args) {
        try{
            demoConnect stockExchangeDB = new demoConnect();
            stockExchangeDB.createTablesAndForeignKeys();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка SQL !");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



}
