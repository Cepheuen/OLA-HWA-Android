package com.cepheuen.olahwa.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookingResponseModel {

    @SerializedName("crn")
    @Expose
    private String crn;
    @SerializedName("driver_name")
    @Expose
    private String driverName;
    @SerializedName("driver_number")
    @Expose
    private String driverNumber;
    @SerializedName("cab_type")
    @Expose
    private String cabType;
    @SerializedName("cab_number")
    @Expose
    private String cabNumber;
    @SerializedName("car_model")
    @Expose
    private String carModel;
    @SerializedName("eta")
    @Expose
    private int eta;
    @SerializedName("driver_lat")
    @Expose
    private double driverLat;
    @SerializedName("driver_lng")
    @Expose
    private double driverLng;

    /**
     * @return The crn
     */
    public String getCrn() {
        return crn;
    }

    /**
     * @param crn The crn
     */
    public void setCrn(String crn) {
        this.crn = crn;
    }

    /**
     * @return The driverName
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * @param driverName The driver_name
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * @return The driverNumber
     */
    public String getDriverNumber() {
        return driverNumber;
    }

    /**
     * @param driverNumber The driver_number
     */
    public void setDriverNumber(String driverNumber) {
        this.driverNumber = driverNumber;
    }

    /**
     * @return The cabType
     */
    public String getCabType() {
        return cabType;
    }

    /**
     * @param cabType The cab_type
     */
    public void setCabType(String cabType) {
        this.cabType = cabType;
    }

    /**
     * @return The cabNumber
     */
    public String getCabNumber() {
        return cabNumber;
    }

    /**
     * @param cabNumber The cab_number
     */
    public void setCabNumber(String cabNumber) {
        this.cabNumber = cabNumber;
    }

    /**
     * @return The carModel
     */
    public String getCarModel() {
        return carModel;
    }

    /**
     * @param carModel The car_model
     */
    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    /**
     * @return The eta
     */
    public int getEta() {
        return eta;
    }

    /**
     * @param eta The eta
     */
    public void setEta(int eta) {
        this.eta = eta;
    }

    /**
     * @return The driverLat
     */
    public double getDriverLat() {
        return driverLat;
    }

    /**
     * @param driverLat The driver_lat
     */
    public void setDriverLat(double driverLat) {
        this.driverLat = driverLat;
    }

    /**
     * @return The driverLng
     */
    public double getDriverLng() {
        return driverLng;
    }

    /**
     * @param driverLng The driver_lng
     */
    public void setDriverLng(double driverLng) {
        this.driverLng = driverLng;
    }

}