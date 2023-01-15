package demo.Reps;

import java.sql.SQLException;

    // Операции с таблицами
    public interface createStuff {
        void createTable() throws SQLException;
        void createData(String nameIn, String typeIn, int priceIn, int pagesIn) throws SQLException;
        void getData() throws SQLException;
        void deleteID(int ifDel) throws SQLException;
        void soldID(int ifSell) throws SQLException;
        void changeID(int id) throws SQLException;
    }

