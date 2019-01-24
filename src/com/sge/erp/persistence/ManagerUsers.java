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

    public void insertUsers() {
        try {
            if (connection == null || connection.isClosed()) {
                openConnection();
            }

            String sql = "INSERT INTO users (user, password) VALUE (?, ?);";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "coke");
            ps.setString(2, "1234");
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public ArrayList<Users> readUser(Users u) {
        ArrayList<Users> user = null;
        try {
            if (connection == null || connection.isClosed()) {
                openConnection();
            }

            String sql = "SELECT * FROM users WHERE user = '" + u.getUser() + "';";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                //System.out.println(rs.getString(1) + rs.getString(2));
                String usser = rs.getString(1);
                String password = rs.getString(2);
                user.add(new Users(usser, password));
            }

            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public ArrayList<Users> readUsers(Users u) {
        ArrayList<Users> user = null;
        try {
            if (connection == null || connection.isClosed()) {
                openConnection();
            }

            String sql = "SELECT * FROM users;";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                //System.out.println(rs.getString(1) + rs.getString(2));
                String usser = rs.getString(1);
                String password = rs.getString(2);
                user.add(new Users(usser, password));
            }

            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public void updateStaff_Team(Users u) {
        try {
            if (connection == null || connection.isClosed()) {
                openConnection();
            }
            String sql = "UPDATE users SET user = '" + u.getUser() + "', password = '" + u.getPassword() + "' WHERE user = '" + u.getUser() + "';";
            Statement st = connection.createStatement();

            st.executeUpdate(sql);

            st.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void deleteStaff_Team(Users u) {
        try {
            if (connection == null || connection.isClosed()) {
                openConnection();
            }
            String sql = "DELETE FROM users WHERE user = '" + u.getUser() + "';";
            Statement st = connection.createStatement();

            st.executeUpdate(sql);

            st.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
