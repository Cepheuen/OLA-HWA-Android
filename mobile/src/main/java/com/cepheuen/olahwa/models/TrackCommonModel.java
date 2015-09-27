
package com.cepheuen.olahwa.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TrackCommonModel {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("request_type")
    @Expose
    private String requestType;
    @SerializedName("crn")
    @Expose
    private String crn;
    @SerializedName("driver_lat")
    @Expose
    private double driverLat;
    @SerializedName("driver_lng")
    @Expose
    private double driverLng;
    @SerializedName("booking_status")
    @Expose
    private String bookingStatus;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("ola_money_balance")
    @Expose
    private int olaMoneyBalance;
    @SerializedName("trip_info")
    @Expose
    private TripInfo tripInfo;
    @SerializedName("fare_breakup")
    @Expose
    private List<FareBreakup> fareBreakup = new ArrayList<FareBreakup>();

    /**
     * 
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The requestType
     */
    public String getRequestType() {
        return requestType;
    }

    /**
     * 
     * @param requestType
     *     The request_type
     */
    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    /**
     * 
     * @return
     *     The crn
     */
    public String getCrn() {
        return crn;
    }

    /**
     * 
     * @param crn
     *     The crn
     */
    public void setCrn(String crn) {
        this.crn = crn;
    }

    /**
     * 
     * @return
     *     The driverLat
     */
    public double getDriverLat() {
        return driverLat;
    }

    /**
     * 
     * @param driverLat
     *     The driver_lat
     */
    public void setDriverLat(double driverLat) {
        this.driverLat = driverLat;
    }

    /**
     * 
     * @return
     *     The driverLng
     */
    public double getDriverLng() {
        return driverLng;
    }

    /**
     * 
     * @param driverLng
     *     The driver_lng
     */
    public void setDriverLng(double driverLng) {
        this.driverLng = driverLng;
    }

    /**
     * 
     * @return
     *     The bookingStatus
     */
    public String getBookingStatus() {
        return bookingStatus;
    }

    /**
     * 
     * @param bookingStatus
     *     The booking_status
     */
    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    /**
     * 
     * @return
     *     The text
     */
    public String getText() {
        return text;
    }

    /**
     * 
     * @param text
     *     The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 
     * @return
     *     The olaMoneyBalance
     */
    public int getOlaMoneyBalance() {
        return olaMoneyBalance;
    }

    /**
     * 
     * @param olaMoneyBalance
     *     The ola_money_balance
     */
    public void setOlaMoneyBalance(int olaMoneyBalance) {
        this.olaMoneyBalance = olaMoneyBalance;
    }

    /**
     * 
     * @return
     *     The tripInfo
     */
    public TripInfo getTripInfo() {
        return tripInfo;
    }

    /**
     * 
     * @param tripInfo
     *     The trip_info
     */
    public void setTripInfo(TripInfo tripInfo) {
        this.tripInfo = tripInfo;
    }

    /**
     * 
     * @return
     *     The fareBreakup
     */
    public List<FareBreakup> getFareBreakup() {
        return fareBreakup;
    }

    /**
     * 
     * @param fareBreakup
     *     The fare_breakup
     */
    public void setFareBreakup(List<FareBreakup> fareBreakup) {
        this.fareBreakup = fareBreakup;
    }

}
