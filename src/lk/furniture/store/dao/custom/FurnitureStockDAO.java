/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.furniture.store.dao.custom;

import java.util.ArrayList;
import lk.furniture.store.dao.SuperDAO;
import lk.furniture.store.dto.FurnitureStockDTO;
import lk.furniture.store.dto.SupplierDTO;

/**
 *
 * @author Lakitha
 */
public interface FurnitureStockDAO extends SuperDAO<FurnitureStockDTO>{
    public ArrayList<FurnitureStockDTO> filteredFromName(String name) throws Exception;

    public ArrayList<FurnitureStockDTO> filteredFromPrice(String price) throws Exception;
    
    public ArrayList<FurnitureStockDTO> filteredFromWoodType(String woodType) throws Exception;
    
}
