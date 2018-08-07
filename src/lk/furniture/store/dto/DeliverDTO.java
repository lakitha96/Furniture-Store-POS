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
public class DeliverDTO extends SuperDTO{
    private String DID;
    private String paymentID;
    private String date;
    private String address;

    public DeliverDTO() {
    }

    public DeliverDTO(String DID, String paymentID, String date, String address) {
        this.DID = DID;
        this.paymentID = paymentID;
        this.date = date;
        this.address = address;
    }

    /**
     * @return the DID
     */
    public String getDID() {
        return DID;
    }

    /**
     * @param DID the DID to set
     */
    public void setDID(String DID) {
        this.DID = DID;
    }

    /**
     * @return the paymentID
     */
    public String getPaymentID() {
        return paymentID;
    }

    /**
     * @param paymentID the paymentID to set
     */
    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
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

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
}
