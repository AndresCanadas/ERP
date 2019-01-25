package com.sge.erp.persistence;

import com.sge.erp.model.Staff;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ManagerStaff extends AdminDataBase {

    public ManagerStaff() throws ClassNotFoundException {
        super();
    }

    public void insertStaff(Staff sf) throws SQLException {
        verifyConnection();
        String sql = "INSERT INTO staff (dni, id_task, name, surname, job) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, sf.getDni());
        ps.setInt(2, sf.getId_task());
        ps.setString(3, sf.getName());
        ps.setString(4, sf.getSurname());
        ps.setString(5, sf.getJob());
        ps.executeUpdate();

    }

    public void updateStaff(String dni, Staff sf) throws SQLException {
        verifyConnection();
        String sql = "UPDATE staff SET id_task = '" + sf.getId_task() + "' , name = '" + sf.getName() + "' , surname = '" + sf.getSurname() + "', job = '" + sf.getJob() + "'  WHERE dni =  '" + dni + "' ";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        st.close();
    }

    public ArrayList<Staff> getStaff(String dni) throws SQLException {
        ArrayList<Staff> sfs = new ArrayList<>();
        verifyConnection();
        String sql = "SELECT * FROM staff WHERE dni = '" + dni + "'";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {

            sfs.add(new Staff(rs.getString(0), rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));

        }
        rs.close();
        st.close();

        return sfs;

    }

    public ArrayList<Staff> getStaffs() throws SQLException {
        ArrayList<Staff> sfs = new ArrayList<>();
        verifyConnection();
        String sql = "SELECT * FROM staff";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {

            sfs.add(new Staff(rs.getString(0), rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));

        }
        rs.close();
        st.close();

        return sfs;

    }

    public void deleteStaff(String dni) throws SQLException {
        verifyConnection();
        String sql = "DELETE FROM staff WHERE dni = '" + dni + "'";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        st.close();
    }

}
