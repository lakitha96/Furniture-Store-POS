/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.furniture.store.dao.custom.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.furniture.store.dao.custom.FurnitureStockDAO;
import lk.furniture.store.db.DBConnection;
import lk.furniture.store.dto.FurnitureStockDTO;


public class FurnitureStockDAOImpl implements FurnitureStockDAO {

    @Override
    public boolean add(FurnitureStockDTO dto) throws Exception {
        String SQL = "INSERT INTO Furniture_Stock VALUES (?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getFID());
        stm.setObject(2, dto.getFname());
        stm.setObject(3, dto.getFurnitureType());
        stm.setObject(4, dto.getWoodType());
        stm.setObject(5, dto.getColor());
        stm.setObject(6, dto.getAvailableQty());
        stm.setObject(7, dto.getUnitPrice());
        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean update(FurnitureStockDTO dto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String name = dto.getFname();
        String fType = dto.getFurnitureType();
        String wType = dto.getWoodType();
        String qty = dto.getAvailableQty();
        BigDecimal price = dto.getUnitPrice();
        String clr = dto.getColor();
        String fid = dto.getFID();

        String sql = "UPDATE furniture_stock SET name='" + name + "', FurnitureType='" + fType + "', woodType='" + wType + "', color='" + clr + "',  qty_on_hand='" + qty + "' , price='" + price + "'  WHERE FID='" + fid + "'";
        PreparedStatement pstm = connection.prepareStatement(sql);

        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean delete(FurnitureStockDTO dto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM furniture_stock WHERE FID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, dto.getFID());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public FurnitureStockDTO search(FurnitureStockDTO dto) throws Exception {
        String SQL = "SELECT * FROM furniture_stock WHERE FID='" + dto.getFID()+ "'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        rst.next();
        return new FurnitureStockDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getBigDecimal(7));
    }

    @Override
    public ArrayList<FurnitureStockDTO> getAll() throws Exception {
        String SQL = "SELECT * FROM Furniture_Stock";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<FurnitureStockDTO> furnitureList = new ArrayList<>();
        while (rst.next()) {
            furnitureList.add(new FurnitureStockDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getBigDecimal(7)));
        }
        return furnitureList;
    }

    @Override
    public ArrayList<FurnitureStockDTO> filteredFromName(String name) throws Exception {
        String SQL = "SELECT * FROM furniture_stock WHERE name LIKE '%" + name + "%'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<FurnitureStockDTO> furnitureList = new ArrayList<>();
        while (rst.next()) {
            furnitureList.add(new FurnitureStockDTO(rst.getString(1), rst.getString(2),
                    rst.getString(3), rst.getString(4), rst.getString(5),rst.getString(6),
                    rst.getBigDecimal(7) ));
        }
        return furnitureList;
    }

    @Override
    public ArrayList<FurnitureStockDTO> filteredFromPrice(String price) throws Exception {
        String SQL = "SELECT * FROM furniture_stock WHERE Price LIKE '%" + price + "%'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<FurnitureStockDTO> furnitureList = new ArrayList<>();
        while (rst.next()) {
            furnitureList.add(new FurnitureStockDTO(rst.getString(1), rst.getString(2),
                    rst.getString(3), rst.getString(4), rst.getString(5),rst.getString(6),
                    rst.getBigDecimal(7) ));
        }
        return furnitureList;
    }

    @Override
    public ArrayList<FurnitureStockDTO> filteredFromWoodType(String woodType) throws Exception {
        String SQL = "SELECT * FROM furniture_stock WHERE WoodType LIKE '%" + woodType + "%'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<FurnitureStockDTO> furnitureList = new ArrayList<>();
        while (rst.next()) {
            furnitureList.add(new FurnitureStockDTO(rst.getString(1), rst.getString(2),
                    rst.getString(3), rst.getString(4), rst.getString(5),rst.getString(6),
                    rst.getBigDecimal(7) ));
        }
        return furnitureList;
    }
    
}
