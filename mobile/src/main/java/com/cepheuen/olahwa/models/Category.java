
package com.cepheuen.olahwa.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Category {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("distance_unit")
    @Expose
    private String distanceUnits;
    @SerializedName("time_unit")
    @Expose
    private String timeUnits;
    @SerializedName("eta")
    @Expose
    private int eta;
    @SerializedName("distance")
    @Expose
    private double distance;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("fare_breakup")
    @Expose
    private List<FareBreakup> fareBreakup = new ArrayList<FareBreakup>();

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 
     * @param displayName
     *     The display_name
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * 
     * @return
     *     The currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 
     * @param currency
     *     The currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * 
     * @return
     *     The distanceUnits
     */
    public String getDistanceUnits() {
        return distanceUnits;
    }

    /**
     * 
     * @param distanceUnits
     *     The distance_units
     */
    public void setDistanceUnits(String distanceUnits) {
        this.distanceUnits = distanceUnits;
    }

    /**
     * 
     * @return
     *     The timeUnits
     */
    public String getTimeUnits() {
        return timeUnits;
    }

    /**
     * 
     * @param timeUnits
     *     The time_units
     */
    public void setTimeUnits(String timeUnits) {
        this.timeUnits = timeUnits;
    }

    /**
     * 
     * @return
     *     The eta
     */
    public int getEta() {
        return eta;
    }

    /**
     * 
     * @param eta
     *     The eta
     */
    public void setEta(int eta) {
        this.eta = eta;
    }

    /**
     * 
     * @return
     *     The distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * 
     * @param distance
     *     The distance
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * 
     * @return
     *     The image
     */
    public String getImage() {
        return image;
    }

    /**
     * 
     * @param image
     *     The image
     */
    public void setImage(String image) {
        this.image = image;
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
