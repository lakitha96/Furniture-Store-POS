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
import lk.furniture.store.dao.custom.OrderDAO;
import lk.furniture.store.db.DBConnection;
import lk.furniture.store.dto.CustomerDTO;
import lk.furniture.store.dto.OrderDTO;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public boolean add(OrderDTO dto) throws Exception {
        String SQL = "INSERT INTO orders VALUES (?,?,?)";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getOID());
        stm.setObject(2, dto.getFID());
        stm.setObject(3, dto.getDate());
        return stm.executeUpdate() > 0;
        
        
    }

    @Override
    public boolean update(OrderDTO dto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String OID = dto.getOID();
        String FID = dto.getFID();
        String date = dto.getDate();
        String sql = "UPDATE orders SET OID='" + OID + "', lname='" + FID + "', address='" + date + "'";
        PreparedStatement pstm = connection.prepareStatement(sql);
        int affectedRows = pstm.executeUpdate();
        System.out.println(affectedRows);
        return (affectedRows > 0);
    }

    @Override
    public boolean delete(OrderDTO dto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM order WHERE OID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, dto.getOID());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public OrderDTO search(OrderDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OrderDTO> getAll() throws Exception {
        String SQL = "SELECT * FROM orders";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<OrderDTO> orderList = new ArrayList<>();
        while (rst.next()) {
            orderList.add(new OrderDTO(rst.getString(1), rst.getString(2), rst.getString(3)));
        }
        return orderList;
    }

}
