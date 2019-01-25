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
    }

    public void insertClient(Client c) throws SQLException {

        verifyConnection();
        String sql = "INSERT INTO client (nif, name, email, phone, address) VALUE (?, ?, ?, ?, ?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, c.getNif());
        ps.setString(2, c.getName());
        ps.setString(3, c.getEmail());
        ps.setInt(4, Integer.parseInt(c.getPhone()));
        ps.setString(5, c.getAddress());
        ps.executeUpdate();

    }

    public ArrayList<Client> readClient(String nifClient) throws SQLException {
        ArrayList<Client> client = new ArrayList<>();
        verifyConnection();

        String sql = "SELECT * FROM client WHERE nif = '" + nifClient + "';";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            String nif = rs.getString(1);
            String name = rs.getString(2);
            String email = rs.getString(3);
            String phone = Integer.toString(rs.getInt(4));
            String address = rs.getString(5);
            client.add(new Client(nif, name, email, phone, address));
        }

        rs.close();
        st.close();

        return client;
    }

    public ArrayList<Client> readClients() throws SQLException {
        ArrayList<Client> client = new ArrayList<>();
        verifyConnection();

        String sql = "SELECT * FROM client ;";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            String nif = rs.getString(1);
            String name = rs.getString(2);
            String email = rs.getString(3);
            String phone = Integer.toString(rs.getInt(4));
            String address = rs.getString(5);
            client.add(new Client(nif, name, email, phone, address));
        }

        rs.close();
        st.close();
        return client;
    }

    public void updateClient(Client c) throws SQLException {
        verifyConnection();
        String sql = "UPDATE client SET nif = '" + c.getNif() + "', name = '" + c.getName() + "', email = '" + c.getEmail() + "', phone = '" + c.getPhone() + "', address = '" + c.getAddress() + "' WHERE nif = '" + c.getNif() + "';";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        st.close();

    }

    public void deleteClient(String nifClient) throws SQLException {
        verifyConnection();
        String sql = "DELETE FROM client WHERE nif = '" + nifClient + "';";
        Statement st = connection.createStatement();

        st.executeUpdate(sql);

        st.close();

    }

}
