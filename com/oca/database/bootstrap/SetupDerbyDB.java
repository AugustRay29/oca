package com.oca.database.bootstrap;

import java.sql.*;
import java.util.stream.IntStream;

public class SetupDerbyDB {
    static String url = "jdbc:derby:voltesvdb;create=true";

    public static void main(String[] args) throws SQLException {
        try ( Connection conn = DriverManager.getConnection(url)) {
            run(conn, "CREATE TABLE choudenji_machines (" +
                    "  machine_id INT PRIMARY KEY," +
                    "  name VARCHAR(255)," +
                    "  role VARCHAR(255)," +
                    "  pilot VARCHAR(255)" +
                    ")");
            run(conn,"CREATE TABLE enemies (" +
                    "  enemy_id INT PRIMARY KEY," +
                    "  name VARCHAR(255)," +
                    "  strength VARCHAR(255)," +
                    "  weakness VARCHAR(255)" +
                    ")");

            run(conn, "INSERT INTO choudenji_machines (machine_id, name, role, pilot)" +
                    "VALUES (1, 'Choudenji Machine Boomerang', 'Engineer and mechanic', 'Ippei Mine')," +
                    "       (2, 'Choudenji Machine Crane', 'Medic', 'Daijiro Gou')," +
                    "       (3, 'Choudenji Machine Spider', 'Scout and sharpshooter', 'Hiyoshi Wakajima')," +
                    "       (4, 'Choudenji Machine Big Shooter', 'Support and communications specialist', 'Megumi Oka')," +
                    "       (5, 'Voltes V', 'Primary combat mecha', 'Kenichi Gou')");
            run(conn, "INSERT INTO enemies (enemy_id, name, strength, weakness)" +
                    "VALUES (1, 'Zambot 3', 'High-energy blasts', 'Voltes V Beam')," +
                    "       (2, 'Daimos', 'Powerful physical attacks', 'Voltes V Sword')," +
                    "       (3, 'Golion', 'Agility and speed', 'Voltes V Hammer')");

            print(conn,"SELECT count(*) FROM choudenji_machines");
            print(conn,"SELECT count(*) FROM enemies");
        }
    }

    private static void run(Connection conn, String sql) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ps.executeUpdate();
        }
    }

    private static void print(Connection conn, String sql) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            rs.next();
            System.out.println(rs.getInt(1));
        }
    }
}
