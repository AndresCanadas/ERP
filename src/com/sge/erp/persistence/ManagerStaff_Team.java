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

    public void insertStaff_Team(Staff_Team st) throws SQLException {

        verifyConnection();
        String sql = "INSERT INTO staff_team (id_team, dni) VALUE (?, ?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, st.getId_team());
        ps.setString(2, st.getDni());
        ps.executeUpdate();

    }

    public ArrayList<Staff_Team> readStaff_Team(String id_Team) throws SQLException {
        ArrayList<Staff_Team> steam = new ArrayList<>();
        verifyConnection();

        String sql = "SELECT * FROM staff_team WHERE id_team = '" + id_Team + "';";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            int id_team = rs.getInt(1);
            String dni = rs.getString(2);
            steam.add(new Staff_Team(id_team, dni));
        }

        rs.close();
        st.close();

        return steam;
    }

    public ArrayList<Staff_Team> readStaff_Teams() throws SQLException {
        ArrayList<Staff_Team> steam = null;
        verifyConnection();

        String sql = "SELECT * FROM staff_team;";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            int id_team = rs.getInt(1);
            String dni = rs.getString(2);
            steam.add(new Staff_Team(id_team, dni));
        }

        rs.close();
        st.close();

        return steam;
    }

    public void updateStaff_Team(Staff_Team stm) throws SQLException {
        verifyConnection();
        String sql = "UPDATE staff_team SET id_team = '" + stm.getId_team() + "', dni = '" + stm.getDni() + "' WHERE dni = '" + stm.getDni() + "';";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        st.close();

    }

    public void deleteStaff_Team(String dni) throws SQLException {
        verifyConnection();
        String sql = "DELETE FROM staff_team WHERE dni = '" + dni + "';";
        Statement st = connection.createStatement();

        st.executeUpdate(sql);

        st.close();

    }

}
