/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.furniture.store.dto;

import java.math.BigDecimal;

/**
 *
 * @author Lakitha
 */
public class FurnitureStockDTO extends SuperDTO{
    private String FID;
    private String fname;
    private String furnitureType;
    private String woodType;
    private String color;
    private String availableQty;
    private BigDecimal unitPrice;

    public FurnitureStockDTO() {
    }

    public FurnitureStockDTO(String FID, String fname, String furnitureType, String woodType, String color, String availableQty, BigDecimal unitPrice) {
        this.FID = FID;
        this.fname = fname;
        this.furnitureType = furnitureType;
        this.woodType = woodType;
        this.color = color;
        this.availableQty = availableQty;
        this.unitPrice = unitPrice;
    }

    /**
     * @return the FID
     */
    public String getFID() {
        return FID;
    }

    /**
     * @param FID the FID to set
     */
    public void setFID(String FID) {
        this.FID = FID;
    }

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
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
     * @return the availableQty
     */
    public String getAvailableQty() {
        return availableQty;
    }

    /**
     * @param availableQty the availableQty to set
     */
    public void setAvailableQty(String availableQty) {
        this.availableQty = availableQty;
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
