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
public class ItemTable {
    private String furnitureID;
    private String furnitureName;
    private String furnitureType;
    private String woodType;
    private String quantity;
    private String color;
    private BigDecimal unitPrice;

    public ItemTable() {
    }

    public ItemTable(String furnitureID, String furnitureName, String furnitureType, String woodType, String quantity, String color, BigDecimal unitPrice) {
        this.furnitureID = furnitureID;
        this.furnitureName = furnitureName;
        this.furnitureType = furnitureType;
        this.woodType = woodType;
        this.quantity = quantity;
        this.color = color;
        this.unitPrice = unitPrice;
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
     * @return the furnitureType
     */
    public String getFurnitureType() {
        return furnitureType;
    }

    /**
     * @param furnitureType the furnitureType to set
     */
    public void setFurnitureType(String furnitureType) {
        this.furnitureType = furnitureType;
    }

    /**
     * @return the woodType
     */
    public String getWoodType() {
        return woodType;
    }

    /**
     * @param woodType the woodType to set
     */
    public void setWoodType(String woodType) {
        this.woodType = woodType;
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
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
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
    
    
}
