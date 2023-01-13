package demo.Reps;

import java.sql.SQLException;

    // Операции с таблицами
    public interface createStuff {
        void createTable() throws SQLException;
        void createData() throws SQLException;
        void getData() throws SQLException;
    }

