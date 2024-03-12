//Adharsh Thiagarajan

package com.company;

import java.sql.Connection;

public class DatabaseConnection {
        private static final String JDBC_URL = "jdbc:mysql://localhost:3306/YourDatabase";
        private static final String USERNAME = "root";
        private static final String PASSWORD = "YOUR PWD HERE";

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        }

        public static void close(Connection conn, Statement stmt, ResultSet rs) {
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        public static void close(Statement stmt, Connection conn) {
            try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

    public static String getSelect() {
        return SELECT_SQL_BYID;
    }

    public static String getUpdate() {
        return UPDATE_SQL;
    }

    public static String getInsert() {
        return INSERT_SQL;
    }

    public static String getDelete() {
        return DELETE_SQL;
    }

    public static void disconnect() {


        }
}
