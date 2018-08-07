/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.furniture.store.dao;



import lk.furniture.store.dao.custom.impl.CustomerDAOImpl;
import lk.furniture.store.dao.custom.impl.DeliverDAOImpl;
import lk.furniture.store.dao.custom.impl.FurnitureStockDAOImpl;
import lk.furniture.store.dao.custom.impl.OrderDAOImpl;
import lk.furniture.store.dao.custom.impl.PaymentsDAOImpl;
import lk.furniture.store.dao.custom.impl.SupplierDAOImpl;

/**
 *
 * @author Lakitha
 */
public class DAOFactory {
    
    public static DAOFactory dAOFactory;

    public enum DAOTypes {
        CUSTOMER,SUPPLIER,FURNITURE,ORDERS,PAYMENTS,DELIVER

        /**
         *
         */
        
    }

    public DAOFactory() {
    }

    public static DAOFactory getInstance() {
        if (dAOFactory == null) {
            dAOFactory = new DAOFactory();
        }
        return dAOFactory;
    }

    public SuperDAO getDAO(DAOTypes dAOTypes) {
        switch (dAOTypes) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case SUPPLIER:
                return new SupplierDAOImpl();
            case FURNITURE:
                return new FurnitureStockDAOImpl();
            case ORDERS:
                return new OrderDAOImpl();    
            case PAYMENTS:
                return new PaymentsDAOImpl();   
            case DELIVER:
                return new DeliverDAOImpl();
            default:
                return null;
        }
    }
    
}
