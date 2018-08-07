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
import lk.furniture.store.dao.custom.SupplierDAO;
import lk.furniture.store.db.DBConnection;
import lk.furniture.store.dto.SupplierDTO;


public class SupplierDAOImpl implements SupplierDAO {

    @Override
    public boolean add(SupplierDTO dto) throws Exception {
        String SQL = "INSERT INTO supplier VALUES (?,?,?,?,?)";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getSupplierID());
        stm.setObject(2, dto.getSupplierName());
        stm.setObject(3, dto.getAddress());
        stm.setObject(4, dto.getContact());
        stm.setObject(5, dto.getDistrict());
        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean update(SupplierDTO dto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String name = dto.getSupplierName();
        String address = dto.getAddress();
        String district = dto.getDistrict();
        String contactNumber = dto.getContact();
        String sid = dto.getSupplierID();

        String sql = "UPDATE supplier SET name='" + name + "', address='" + address + "', contactNumber='" + contactNumber + "', district='" + district + "'  WHERE SID='" + sid + "'";
        PreparedStatement pstm = connection.prepareStatement(sql);

        int affectedRows = pstm.executeUpdate();
        System.out.println(affectedRows);
        return (affectedRows > 0);
    }

    @Override
    public boolean delete(SupplierDTO dto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Supplier WHERE SID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, dto.getSupplierID());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public SupplierDTO search(SupplierDTO dto) throws Exception {
        String SQL = "SELECT * FROM supplier WHERE contactNumber='" + dto.getContact()+ "'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        rst.next();
        return new SupplierDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5));
    }

    @Override
    public ArrayList<SupplierDTO> getAll() throws Exception {
        String SQL = "SELECT * FROM supplier";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<SupplierDTO> supplierList = new ArrayList<>();
        while (rst.next()) {
            supplierList.add(new SupplierDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5)));
        }
        return supplierList;
    }

    @Override
    public ArrayList<SupplierDTO> filteredFromName(String name) throws Exception {
        String SQL = "SELECT * FROM supplier WHERE name LIKE '%" + name + "%'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<SupplierDTO> supplierList = new ArrayList<>();
        while (rst.next()) {
            supplierList.add(new SupplierDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5)));
        }
        return supplierList;
    }

    @Override
    public ArrayList<SupplierDTO> filteredFromID(String ID) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<SupplierDTO> filteredFromContact(String contatactNumber) throws Exception {
        String SQL = "SELECT * FROM supplier WHERE contactNumber LIKE '%" + contatactNumber + "%'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<SupplierDTO> supplierList = new ArrayList<>();
        while (rst.next()) {
            supplierList.add(new SupplierDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5)));
        }
        return supplierList;
    }

    @Override
    public ArrayList<SupplierDTO> filteredFromDistrict(String district) throws Exception {
        String SQL = "SELECT * FROM supplier WHERE district LIKE '%" + district + "%'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<SupplierDTO> supplierList = new ArrayList<>();
        while (rst.next()) {
            supplierList.add(new SupplierDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5)));
        }
        return supplierList;
    }
    
}
