package com.cepheuen.olahwa.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RideEstimate {

    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("distance")
    @Expose
    private double distance;
    @SerializedName("travel_time_in_minutes")
    @Expose
    private int travelTimeInMinutes;
    @SerializedName("amount_min")
    @Expose
    private int amountMin;
    @SerializedName("amount_max")
    @Expose
    private int amountMax;

    /**
     * @return The category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category The category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return The distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * @param distance The distance
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * @return The travelTimeInMinutes
     */
    public int getTravelTimeInMinutes() {
        return travelTimeInMinutes;
    }

    /**
     * @param travelTimeInMinutes The travel_time_in_minutes
     */
    public void setTravelTimeInMinutes(int travelTimeInMinutes) {
        this.travelTimeInMinutes = travelTimeInMinutes;
    }

    /**
     * @return The amountMin
     */
    public int getAmountMin() {
        return amountMin;
    }

    /**
     * @param amountMin The amount_min
     */
    public void setAmountMin(int amountMin) {
        this.amountMin = amountMin;
    }

    /**
     * @return The amountMax
     */
    public int getAmountMax() {
        return amountMax;
    }

    /**
     * @param amountMax The amount_max
     */
    public void setAmountMax(int amountMax) {
        this.amountMax = amountMax;
    }

}