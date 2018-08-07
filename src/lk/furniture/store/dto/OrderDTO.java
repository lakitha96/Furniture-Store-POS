/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.furniture.store.dto;

/**
 *
 * @author Lakitha
 */
public class OrderDTO extends SuperDTO {
    private String OID;
    private String FID;
    private String date;

    public OrderDTO() {
    }

    public OrderDTO(String OID, String FID, String date) {
        this.OID = OID;
        this.FID = FID;
        this.date = date;
    }

    /**
     * @return the OID
     */
    public String getOID() {
        return OID;
    }

    /**
     * @param OID the OID to set
     */
    public void setOID(String OID) {
        this.OID = OID;
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
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
    
    
    
}
