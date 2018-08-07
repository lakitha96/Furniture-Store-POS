/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.furniture.store.tables.observablelist;

import java.math.BigDecimal;

/**
 *
 * @author Lakitha
 */
public class PayemntTable {
    
    private String furnitureID;
    private String furnitureName;
    private String quantity;
    private BigDecimal unitPrice;
    private BigDecimal total;

    public PayemntTable() {
    }

    public PayemntTable(String furnitureID, String furnitureName, String quantity, BigDecimal unitPrice, BigDecimal total) {
        this.furnitureID = furnitureID;
        this.furnitureName = furnitureName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.total = total;
    }

    /**
     * @return the furnitureID
     */
    public String getFurnitureID() {
        return furnitureID;
    }

    /**
     * @param furnitureID the furnitureID to set
     */
    public void setFurnitureID(String furnitureID) {
        this.furnitureID = furnitureID;
    }

    /**
     * @return the furnitureName
     */
    public String getFurnitureName() {
        return furnitureName;
    }

    /**
     * @param furnitureName the furnitureName to set
     */
    public void setFurnitureName(String furnitureName) {
        this.furnitureName = furnitureName;
    }

    /**
     * @return the quantity
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the unitPrice
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the total
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    
}
