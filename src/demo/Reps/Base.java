package demo.Reps;

import demo.demoConnect;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Base implements Closeable {
    Connection connection;  // JDBC-���������� ��� ������ � ��������
    String tableName;       // ��� �������

    Base(String tableName) throws SQLException { // ��� �������� ������� ��������� � ����������� � ���
        this.tableName = tableName;
        this.connection = demoConnect.getConnection(); // ��������� ���������� � ���� ��� ���������� ������
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    // ��������
    public void close() {
        try {
            if (connection != null && !connection.isClosed())
                connection.close();
        } catch (SQLException e) {
            System.out.println("������ �������� SQL ����������!");
        }
    }

    // ��������� SQL ������� ��� ���������� � ����, �� ���������� ������ ��������� � �������
    void executeSqlStatement(String sql, String description) throws SQLException {
        reopenConnection(); // ������������� (���� ��� ���������) ���������� � ����
        Statement statement = connection.createStatement();  // ������� statement ��� ���������� sql-������
        statement.execute(sql); // ��������� statement - sql �������
        statement.close();      // ��������� statement ��� �������� ��������� � ����
        if (description != null)
            System.out.println(description);
    };

    void executeSqlStatement(String sql) throws SQLException {
        executeSqlStatement(sql, "���������");
    };


    // ����������� ���������� � ����, ���� ��� �� �������.
    void reopenConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = demoConnect.getConnection();
        }
    }

}
