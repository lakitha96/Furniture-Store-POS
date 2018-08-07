/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.furniture.store.dao.custom.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import lk.furniture.store.dao.custom.DeliverDAO;
import lk.furniture.store.db.DBConnection;
import lk.furniture.store.dto.DeliverDTO;


public class DeliverDAOImpl implements DeliverDAO {

    @Override
    public boolean add(DeliverDTO dto) throws Exception {
        String SQL = "INSERT INTO Deliver VALUES (?,?,?,?)";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getDID());
        stm.setObject(2, dto.getPaymentID());
        stm.setObject(3, dto.getDate());
        stm.setObject(4, dto.getAddress());
        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean update(DeliverDTO dto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String name = dto.getDID();
        String fType = dto.getPaymentID();
        String wType = dto.getDate();
        String qty = dto.getAddress();
        

//        String sql = "UPDATE furniture_stock SET name='" + name + "', FurnitureType='" + fType + "', woodType='" + wType + "', color='" + clr + "',  qty_on_hand='" + qty + "' , price='" + price + "'  WHERE FID='" + fid + "'";
////        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        int affectedRows = pstm.executeUpdate();
//        return (affectedRows > 0);
return false;
    }

    @Override
    public boolean delete(DeliverDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DeliverDTO search(DeliverDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DeliverDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
