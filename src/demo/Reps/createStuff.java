package demo.Reps;

import java.sql.SQLException;

    // �������� � ���������
    public interface createStuff {
        void createTable() throws SQLException;
        void createData() throws SQLException;
        void getData() throws SQLException;
    }

