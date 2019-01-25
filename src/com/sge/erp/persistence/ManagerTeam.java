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
    }

    public void insertTeam(Team t) throws SQLException {
        verifyConnection();
        String sql = "INSERT INTO team (id_team, id_project, name) VALUE (?, ?, ?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, t.getId_team());
        ps.setInt(2, t.getId_project());
        ps.setString(3, t.getName());
        ps.executeUpdate();

    }

    public ArrayList<Team> readTeam(String id_Team) throws SQLException {
        ArrayList<Team> team = new ArrayList<>();
        verifyConnection();

        String sql = "SELECT * FROM team WHERE id_team = '" + id_Team + "';";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            int id_team = rs.getInt(1);
            int id_project = rs.getInt(2);
            String name = rs.getString(3);
            team.add(new Team(id_team, id_project, name));
        }

        rs.close();
        st.close();

        return team;
    }

    public ArrayList<Team> readTeams() throws SQLException {
        ArrayList<Team> team = new ArrayList<>();
        verifyConnection();

        String sql = "SELECT * FROM team ;";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            int id_team = rs.getInt(1);
            int id_project = rs.getInt(2);
            String name = rs.getString(3);
            team.add(new Team(id_team, id_project, name));
        }

        rs.close();
        st.close();

        return team;
    }

    public void updateTeam(Team t) throws SQLException {
        verifyConnection();
        String sql = "UPDATE team SET id_team = '" + t.getId_team() + "', name = '" + t.getName() + "', id_project = '" + t.getId_project() + "' WHERE id_team = '" + t.getId_team() + "';";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        st.close();
    }

    public void deleteTeam(String id_Team) throws SQLException {
        verifyConnection();
        String sql = "DELETE FROM team WHERE id_team = '" + id_Team + "';";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        st.close();

    }

}
