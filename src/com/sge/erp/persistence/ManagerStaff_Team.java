package com.sge.erp.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sge.erp.model.Staff_Team;

public class ManagerStaff_Team extends AdminDataBase {

    public ManagerStaff_Team() throws ClassNotFoundException {
        super();
    }

    public void insertStaff_Team() {
        try {
            if (connection == null || connection.isClosed()) {
                openConnection();
            }

            String sql = "INSERT INTO staff_team (id_team, dni) VALUE (?, ?);";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setString(2, "10069267C");
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public ArrayList<Staff_Team> readStaff_Team(Staff_Team stm) {
        ArrayList<Staff_Team> steam = null;
        try {
            if (connection == null || connection.isClosed()) {
                openConnection();
            }

            String sql = "SELECT * FROM staff_team WHERE id_team = '" + stm.getId_team() + "';";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                //System.out.println(rs.getInt(1) + rs.getString(2));
                int id_team = rs.getInt(1);
                String dni = rs.getString(2);
                steam.add(new Staff_Team(id_team, dni));
            }

            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return steam;
    }

    public ArrayList<Staff_Team> readStaff_Teams(Staff_Team stm) {
        ArrayList<Staff_Team> steam = null;
        try {
            if (connection == null || connection.isClosed()) {
                openConnection();
            }

            String sql = "SELECT * FROM staff_team;";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                //System.out.println(rs.getInt(1) + rs.getString(2));
                int id_team = rs.getInt(1);
                String dni = rs.getString(2);
                steam.add(new Staff_Team(id_team, dni));
            }

            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return steam;
    }

    public void updateStaff_Team(Staff_Team stm) {
        try {
            if (connection == null || connection.isClosed()) {
                openConnection();
            }
            String sql = "UPDATE staff_team SET id_team = '" + stm.getId_team() + "', dni = '" + stm.getDni() + "' WHERE dni = '" + stm.getDni() + "';";
            Statement st = connection.createStatement();

            st.executeUpdate(sql);

            st.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void deleteStaff_Team(Staff_Team stm) {
        try {
            if (connection == null || connection.isClosed()) {
                openConnection();
            }
            String sql = "DELETE FROM staff_team WHERE dni = '" + stm.getDni() + "';";
            Statement st = connection.createStatement();

            st.executeUpdate(sql);

            st.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
