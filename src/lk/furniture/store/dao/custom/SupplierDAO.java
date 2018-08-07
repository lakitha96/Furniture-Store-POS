/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.furniture.store.dao.custom;

import java.util.ArrayList;
import lk.furniture.store.dao.SuperDAO;
import lk.furniture.store.dto.CustomerDTO;
import lk.furniture.store.dto.SupplierDTO;

/**
 *
 * @author Lakitha
 */
//public interface CustomerDAO extends SuperDAO <CustomerDTO>{
//public interface CustomerDAO extends SuperDAO <CustomerDTO>{
public interface SupplierDAO extends SuperDAO<SupplierDTO>{
    
    public ArrayList<SupplierDTO> filteredFromName(String name) throws Exception;

    public ArrayList<SupplierDTO> filteredFromID(String ID) throws Exception;
    
    public ArrayList<SupplierDTO> filteredFromContact(String Contact) throws Exception;
    
    public ArrayList<SupplierDTO> filteredFromDistrict(String district) throws Exception;
    
    
    
}
