/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.furniture.store.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.furniture.store.dao.custom.CustomerDAO;
import lk.furniture.store.db.DBConnection;
import lk.furniture.store.dto.CustomerDTO;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean add(CustomerDTO dto) throws Exception {
        String SQL = "INSERT INTO customer VALUES (?,?,?,?,?,?)";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getCID());
        stm.setObject(2, dto.getFirstName());
        stm.setObject(3, dto.getLastName());
        stm.setObject(4, dto.getAddress());
        stm.setObject(5, dto.getDistrict());
        stm.setObject(6, dto.getContactNumber());
        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean update(CustomerDTO customer) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String fName = customer.getFirstName();
        String lName = customer.getLastName();
        String address = customer.getAddress();
        String district = customer.getDistrict();
        String contactNumber = customer.getContactNumber();
        String cid = customer.getCID();

        String sql = "UPDATE Customer SET fname='" + fName + "', lname='" + lName + "', address='" + address + "', District='" + district + "', contactNumber='" + contactNumber + "' WHERE CID='" + cid + "'";
        PreparedStatement pstm = connection.prepareStatement(sql);

        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean delete(CustomerDTO dto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Customer WHERE CID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, dto.getCID());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public CustomerDTO search(CustomerDTO dto) throws Exception {
        String SQL = "SELECT * FROM customer WHERE contactNumber='" + dto.getContactNumber() + "'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        rst.next();
        return new CustomerDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6));
    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws Exception {
        String SQL = "SELECT * FROM customer";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<CustomerDTO> customerList = new ArrayList<>();
        while (rst.next()) {
            customerList.add(new CustomerDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6)));
        }
        return customerList;
    }

    @Override
    public ArrayList<CustomerDTO> filteredFromName(String name) throws Exception {
        String SQL = "SELECT * FROM customer WHERE lName LIKE '%" + name + "%'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<CustomerDTO> customerList = new ArrayList<>();
        while (rst.next()) {
            customerList.add(new CustomerDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6)));
        }
        return customerList;
    }

    @Override
    public ArrayList<CustomerDTO> filteredFromID(String ID) throws Exception {
        String SQL = "SELECT * FROM customer WHERE CID LIKE '%" + ID + "%'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<CustomerDTO> customerList = new ArrayList<>();
        while (rst.next()) {
            customerList.add(new CustomerDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6)));
        }
        return customerList;
    }

    @Override
    public ArrayList<CustomerDTO> filteredFromContact(String contatactNumber) throws Exception {
        String SQL = "SELECT * FROM customer WHERE contactNumber LIKE '%" + contatactNumber + "%'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<CustomerDTO> customerList = new ArrayList<>();
        while (rst.next()) {
            customerList.add(new CustomerDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6)));
        }
        return customerList;
    }

    @Override
    public ArrayList<CustomerDTO> filteredFromDistrict(String district) throws Exception {
        String SQL = "SELECT * FROM customer WHERE district LIKE '%" + district + "%'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<CustomerDTO> customerList = new ArrayList<>();
        while (rst.next()) {
            customerList.add(new CustomerDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6)));
        }
        return customerList;
    }

}
