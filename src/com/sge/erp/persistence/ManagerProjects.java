package com.sge.erp.persistence;

import com.sge.erp.model.Project;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ManagerProjects extends AdminDataBase {

    public ManagerProjects() throws ClassNotFoundException {
        super();
    }

    public void insertProject(Project pj) throws SQLException {
        if (connection == null || connection.isClosed()) {
            openConnection();
        }
        String sql = "INSERT INTO project (id_project, nif_client, name) VALUES (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, pj.getId_project());
        ps.setString(2, pj.getNif_client());
        ps.setString(3, pj.getName());
        ps.executeUpdate();

    }

    public void updateProject(int id_project, Project pj) throws SQLException {
        if (connection == null || connection.isClosed()) {
            openConnection();
        }
        String sql = "UPDATE project SET nif_client = '" + pj.getNif_client() + "' , name = '" + pj.getName() + "'  WHERE id_project =  '" + id_project + "' ";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
    }

    public ArrayList<Project> getProject(int id_project) throws SQLException {
        ArrayList<Project> pjs = new ArrayList<>();
        if (connection == null || connection.isClosed()) {
            openConnection();
        }
        String sql = "SELECT * FROM project WHERE id_project = '" + id_project + "'";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {

            pjs.add(new Project(rs.getInt(0), rs.getString(1), rs.getString(2)));

        }

        return pjs;

    }

    public ArrayList<Project> getProjects() throws SQLException {
        ArrayList<Project> pjs = new ArrayList<>();
        if (connection == null || connection.isClosed()) {
            openConnection();
        }
        String sql = "SELECT * FROM project";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {

            pjs.add(new Project(rs.getInt(0), rs.getString(1), rs.getString(2)));

        }

        return pjs;

    }

    public void deleteProject(int id_project) throws SQLException {
        if (connection == null || connection.isClosed()) {
            openConnection();
        }
        String sql = "DELETE FROM project WHERE id_project = '" + id_project + "'";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);

    }

}
