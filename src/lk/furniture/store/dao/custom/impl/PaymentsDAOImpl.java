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
import lk.furniture.store.dao.custom.PaymentsDAO;
import lk.furniture.store.db.DBConnection;
import lk.furniture.store.dto.PaymentDTO;


public class PaymentsDAOImpl implements PaymentsDAO {

    @Override
    public boolean add(PaymentDTO dto) throws Exception {
        BigDecimal tot= BigDecimal.valueOf(Double.parseDouble(dto.getTotal()));
        String SQL = "INSERT INTO payments VALUES (?,?,?,?,?)";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getPID());
        stm.setObject(2, dto.getFID());
        stm.setObject(3, dto.getOID());
        stm.setObject(4, Integer.parseInt(dto.getQty()));
        stm.setObject(5, tot);
        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean update(PaymentDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(PaymentDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PaymentDTO search(PaymentDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PaymentDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
