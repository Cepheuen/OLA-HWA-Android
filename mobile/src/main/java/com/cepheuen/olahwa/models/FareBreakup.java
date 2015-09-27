
package com.cepheuen.olahwa.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class FareBreakup {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("minimum_distance")
    @Expose
    private int minimumDistance;
    @SerializedName("minimum_time")
    @Expose
    private int minimumTime;
    @SerializedName("base_fare")
    @Expose
    private int baseFare;
    @SerializedName("cost_per_distance")
    @Expose
    private int costPerDistance;
    @SerializedName("waiting_cost_per_minute")
    @Expose
    private int waitingCostPerMinute;
    @SerializedName("ride_cost_per_minute")
    @Expose
    private int rideCostPerMinute;
    @SerializedName("surcharge")
    @Expose
    private List<Surcharge> surcharge = new ArrayList<Surcharge>();

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The minimumDistance
     */
    public int getMinimumDistance() {
        return minimumDistance;
    }

    /**
     * 
     * @param minimumDistance
     *     The minimum_distance
     */
    public void setMinimumDistance(int minimumDistance) {
        this.minimumDistance = minimumDistance;
    }

    /**
     * 
     * @return
     *     The minimumTime
     */
    public int getMinimumTime() {
        return minimumTime;
    }

    /**
     * 
     * @param minimumTime
     *     The minimum_time
     */
    public void setMinimumTime(int minimumTime) {
        this.minimumTime = minimumTime;
    }

    /**
     * 
     * @return
     *     The baseFare
     */
    public int getBaseFare() {
        return baseFare;
    }

    /**
     * 
     * @param baseFare
     *     The base_fare
     */
    public void setBaseFare(int baseFare) {
        this.baseFare = baseFare;
    }

    /**
     * 
     * @return
     *     The costPerDistance
     */
    public int getCostPerDistance() {
        return costPerDistance;
    }

    /**
     * 
     * @param costPerDistance
     *     The cost_per_distance
     */
    public void setCostPerDistance(int costPerDistance) {
        this.costPerDistance = costPerDistance;
    }

    /**
     * 
     * @return
     *     The waitingCostPerMinute
     */
    public int getWaitingCostPerMinute() {
        return waitingCostPerMinute;
    }

    /**
     * 
     * @param waitingCostPerMinute
     *     The waiting_cost_per_minute
     */
    public void setWaitingCostPerMinute(int waitingCostPerMinute) {
        this.waitingCostPerMinute = waitingCostPerMinute;
    }

    /**
     * 
     * @return
     *     The rideCostPerMinute
     */
    public int getRideCostPerMinute() {
        return rideCostPerMinute;
    }

    /**
     * 
     * @param rideCostPerMinute
     *     The ride_cost_per_minute
     */
    public void setRideCostPerMinute(int rideCostPerMinute) {
        this.rideCostPerMinute = rideCostPerMinute;
    }

    /**
     * 
     * @return
     *     The surcharge
     */
    public List<Surcharge> getSurcharge() {
        return surcharge;
    }

    /**
     * 
     * @param surcharge
     *     The surcharge
     */
    public void setSurcharge(List<Surcharge> surcharge) {
        this.surcharge = surcharge;
    }

}
