package com.sge.erp.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sge.erp.model.Client;

public class ManagerClient extends AdminDataBase {

    public ManagerClient() throws ClassNotFoundException {
        super();
        // TODO Auto-generated constructor stub
    }

    public void insertClient() {
        try {
            if (connection == null || connection.isClosed()) {
                openConnection();
            }

            String sql = "INSERT INTO client (nif, name, email, phone, address) VALUE (?, ?, ?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "70069267C");
            ps.setString(2, "Jorge");
            ps.setString(3, "d@g.c");
            ps.setInt(4, 676729969);
            ps.setString(5, "Nueva 2 ALC");
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public ArrayList<Client> readClient(Client c) {
        ArrayList<Client> client = null;
        try {
            if (connection == null || connection.isClosed()) {
                openConnection();
            }

            String sql = "SELECT * FROM client WHERE nif = '" + c.getNif() + "';";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                //System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3) + rs.getInt(4) + rs.getString(5));
                String nif = rs.getString(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String phone = Integer.toString(rs.getInt(4));
                String address = rs.getString(5);
                client.add(new Client(nif, name, email, phone, address));
            }

            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return client;
    }

    public ArrayList<Client> readClients(Client c) {
        ArrayList<Client> client = null;
        try {
            if (connection == null || connection.isClosed()) {
                openConnection();
            }

            String sql = "SELECT * FROM client ;";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                //System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3) + rs.getInt(4) + rs.getString(5));
                String nif = rs.getString(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String phone = Integer.toString(rs.getInt(4));
                String address = rs.getString(5);
                client.add(new Client(nif, name, email, phone, address));
            }

            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return client;
    }

    public void updateClient(Client c) {
        try {
            if (connection == null || connection.isClosed()) {
                openConnection();
            }
            String sql = "UPDATE client SET nif = '" + c.getNif() + "', name = '" + c.getName() + "', email = '" + c.getEmail() + "', phone = '" + c.getPhone() + "', address = '" + c.getAddress() + "' WHERE nif = '" + c.getNif() + "';";
            Statement st = connection.createStatement();

            st.executeUpdate(sql);

            st.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void deleteClient(Client c) {
        try {
            if (connection == null || connection.isClosed()) {
                openConnection();
            }
            String sql = "DELETE FROM client WHERE nif = '" + c.getNif() + "';";
            Statement st = connection.createStatement();

            st.executeUpdate(sql);

            st.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
