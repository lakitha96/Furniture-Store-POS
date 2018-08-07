/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.furniture.store.dao.custom;

import java.util.ArrayList;
import lk.furniture.store.dao.SuperDAO;
import lk.furniture.store.dto.CustomerDTO;

/**
 *
 * @author Lakitha
 */
//extends SuperDAO<CustomerDTO>
public interface CustomerDAO extends SuperDAO <CustomerDTO>{
    
    public ArrayList<CustomerDTO> filteredFromName(String name) throws Exception;

    public ArrayList<CustomerDTO> filteredFromID(String ID) throws Exception;
    
    public ArrayList<CustomerDTO> filteredFromContact(String Contact) throws Exception;
    
    public ArrayList<CustomerDTO> filteredFromDistrict(String district) throws Exception;
    
    


    
}
