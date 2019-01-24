package com.sge.erp.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sge.erp.model.Team;

public class ManagerTeam extends AdminDataBase {

    public ManagerTeam() throws ClassNotFoundException {
        super();
        // TODO Auto-generated constructor stub
    }

    public void insertClient() {
        try {
            if (connection == null || connection.isClosed()) {
                openConnection();
            }

            String sql = "INSERT INTO team (id_team, id_project, name) VALUE (?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setInt(2, 1);
            ps.setString(3, "ERP");
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public ArrayList<Team> readClient(Team t) {
        ArrayList<Team> team = null;
        try {
            if (connection == null || connection.isClosed()) {
                openConnection();
            }

            String sql = "SELECT * FROM team WHERE id_team = '" + t.getId_team() + "';";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                //System.out.println(rs.getInt(1) + rs.getInt(2) + rs.getString(3));
                int id_team = rs.getInt(1);
                int id_project = rs.getInt(2);
                String name = rs.getString(3);
                team.add(new Team(id_team, id_project, name));
            }

            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return team;
    }

    public ArrayList<Team> readClients(Team t) {
        ArrayList<Team> team = null;
        try {
            if (connection == null || connection.isClosed()) {
                openConnection();
            }

            String sql = "SELECT * FROM team ;";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                //System.out.println(rs.getInt(1) + rs.getInt(2) + rs.getString(3));
                int id_team = rs.getInt(1);
                int id_project = rs.getInt(2);
                String name = rs.getString(3);
                team.add(new Team(id_team, id_project, name));
            }

            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return team;
    }

    public void updateClient(Team t) {
        try {
            if (connection == null || connection.isClosed()) {
                openConnection();
            }
            String sql = "UPDATE team SET id_team = '" + t.getId_team() + "', name = '" + t.getName() + "', id_project = '" + t.getId_project() + "' WHERE id_team = '" + t.getId_team() + "';";
            Statement st = connection.createStatement();

            st.executeUpdate(sql);

            st.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void deleteClient(Team t) {
        try {
            if (connection == null || connection.isClosed()) {
                openConnection();
            }
            String sql = "DELETE FROM team WHERE id_team = '" + t.getId_team() + "';";
            Statement st = connection.createStatement();

            st.executeUpdate(sql);

            st.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
