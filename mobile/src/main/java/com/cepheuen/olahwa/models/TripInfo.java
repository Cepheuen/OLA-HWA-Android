
package com.cepheuen.olahwa.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TripInfo {

    @SerializedName("amount")
    @Expose
    private int amount;
    @SerializedName("payable_amount")
    @Expose
    private int payableAmount;
    @SerializedName("distance")
    @Expose
    private Distance distance;
    @SerializedName("wait_time")
    @Expose
    private WaitTime waitTime;
    @SerializedName("discount")
    @Expose
    private int discount;
    @SerializedName("advance")
    @Expose
    private int advance;

    /**
     * 
     * @return
     *     The amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * 
     * @param amount
     *     The amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * 
     * @return
     *     The payableAmount
     */
    public int getPayableAmount() {
        return payableAmount;
    }

    /**
     * 
     * @param payableAmount
     *     The payable_amount
     */
    public void setPayableAmount(int payableAmount) {
        this.payableAmount = payableAmount;
    }

    /**
     * 
     * @return
     *     The distance
     */
    public Distance getDistance() {
        return distance;
    }

    /**
     * 
     * @param distance
     *     The distance
     */
    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    /**
     * 
     * @return
     *     The waitTime
     */
    public WaitTime getWaitTime() {
        return waitTime;
    }

    /**
     * 
     * @param waitTime
     *     The wait_time
     */
    public void setWaitTime(WaitTime waitTime) {
        this.waitTime = waitTime;
    }

    /**
     * 
     * @return
     *     The discount
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * 
     * @param discount
     *     The discount
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    /**
     * 
     * @return
     *     The advance
     */
    public int getAdvance() {
        return advance;
    }

    /**
     * 
     * @param advance
     *     The advance
     */
    public void setAdvance(int advance) {
        this.advance = advance;
    }

}
