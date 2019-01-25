package com.sge.erp.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sge.erp.model.Users;

public class ManagerUsers extends AdminDataBase {

    public ManagerUsers() throws ClassNotFoundException {
        super();
        // TODO Auto-generated constructor stub
    }

    public void insertUsers(Users u) throws SQLException {
        verifyConnection();

        String sql = "INSERT INTO users (user, password) VALUE (?, ?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, u.getUser());
        ps.setString(2, u.getPassword());
        ps.executeUpdate();

    }

    public ArrayList<Users> readUser(String user_Name) throws SQLException {
        ArrayList<Users> user = new ArrayList<>();
        verifyConnection();

        String sql = "SELECT * FROM users WHERE user = '" + user_Name + "';";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            String usser = rs.getString(1);
            String password = rs.getString(2);
            user.add(new Users(usser, password));
        }

        rs.close();
        st.close();

        return user;
    }

    public ArrayList<Users> readUsers() throws SQLException {
        ArrayList<Users> user = new ArrayList<>();
        verifyConnection();

        String sql = "SELECT * FROM users;";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            String usser = rs.getString(1);
            String password = rs.getString(2);
            user.add(new Users(usser, password));
        }

        rs.close();
        st.close();

        return user;
    }

    public void updateUsers(Users u) throws SQLException {

        verifyConnection();
        String sql = "UPDATE users SET user = '" + u.getUser() + "', password = '" + u.getPassword() + "' WHERE user = '" + u.getUser() + "';";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        st.close();

    }

    public void deleteUsers(String user_Name) throws SQLException {
        verifyConnection();
        String sql = "DELETE FROM users WHERE user = '" + user_Name + "';";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        st.close();

    }

}
