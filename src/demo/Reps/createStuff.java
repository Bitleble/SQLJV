package demo.Reps;

import java.sql.SQLException;

    // �������� � ���������
    public interface createStuff {
        void createTable() throws SQLException;
        void createData(String nameIn, String typeIn, int priceIn, int pagesIn) throws SQLException;
        void getData() throws SQLException;
        void deleteName(String ifDel) throws SQLException;
        void soldID(String ifDel) throws SQLException;
        void changeID(int id) throws SQLException;
    }

