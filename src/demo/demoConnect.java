package demo;

import demo.Reps.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.System.exit;

public class demoConnect {

    public static final String DB_URL = "jdbc:h2:./SQL/demoConnect";
    public static final String DB_Driver = "org.h2.Driver";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public Paper papers;


    public demoConnect() throws SQLException, ClassNotFoundException {
        Class.forName(DB_Driver);
        // Инициализируем таблицы
        papers = new Paper();
    }

    // Создание всех таблиц и ключей между ними
    /*public void createTablesAndForeignKeys() throws SQLException {
        //papers.createTable();
        papers.createData();
    }*/




    public static void main(String[] args) {

        try{
            demoConnect stockExchangeDB = new demoConnect();
            /*stockExchangeDB.papers.createTable(); // убрать комментарий, если нужно создать новую базу данных с таблицей
            stockExchangeDB.papers.createData("Первая запись", "Газета",170,2);
            stockExchangeDB.papers.createData("Вторая", "Книга",1045,22);
            stockExchangeDB.papers.createData("Третья", "Газета",10,2);
            stockExchangeDB.papers.createData("Первая запись", "Газета",10,2);
            stockExchangeDB.papers.createData("------------------", "Книга",101,2);
            //stockExchangeDB.papers.getData();
            //stockExchangeDB.papers.soldID("Вторая");
            //stockExchangeDB.papers.soldID("Третья");
            //stockExchangeDB.papers.getData();
            stockExchangeDB.papers.changeID(9,"Новое имя", "Новый тип", 324, 243);
            stockExchangeDB.papers.getData();
            stockExchangeDB.papers.close();
            exit(200);*/
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка SQL !");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
