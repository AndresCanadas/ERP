package com.sge.erp.persistence;

import com.sge.erp.model.Task;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ManagerTask extends AdminDataBase {

    public ManagerTask() throws ClassNotFoundException {
        super();
    }

    public void insertTask(Task tk) throws SQLException {
        verifyConnection();
        String sql = "INSERT INTO task (id_task, id_project, dni, name) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, tk.getId_task());
        ps.setInt(2, tk.getId_project());
        ps.setString(3, tk.getDni());
        ps.setString(4, tk.getName());
        ps.executeUpdate();

    }

    public void updateTask(int id_task, Task tk) throws SQLException {
        verifyConnection();
        String sql = "UPDATE task SET id_project = '" + tk.getId_project() + "' , dni = '" + tk.getDni() + "' , name = '" + tk.getName() + "'  WHERE id_task =  '" + id_task + "' ";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        st.close();
    }

    public ArrayList<Task> getTask(int id_task) throws SQLException {
        ArrayList<Task> tks = new ArrayList<>();
        verifyConnection();
        String sql = "SELECT * FROM task WHERE id_task = '" + id_task + "'";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {

            tks.add(new Task(rs.getInt(0), rs.getInt(1), rs.getString(2), rs.getString(3)));

        }
        rs.close();
        st.close();
        return tks;

    }

    public ArrayList<Task> getTasks() throws SQLException {
        ArrayList<Task> tks = new ArrayList<>();
        verifyConnection();
        String sql = "SELECT * FROM task";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {

            tks.add(new Task(rs.getInt(0), rs.getInt(1), rs.getString(2), rs.getString(3)));

        }
        rs.close();
        st.close();

        return tks;

    }

    public void deleteTask(int id_task) throws SQLException {
        verifyConnection();
        String sql = "DELETE FROM task WHERE id_task = '" + id_task + "'";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        st.close();

    }

}
