package com.cepheuen.olahwa.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DashboardModel {

    @SerializedName("_id")
    @Expose
    private String Id;
    @SerializedName("client_id")
    @Expose
    private String clientId;
    @SerializedName("fullname")
    @Expose
    private String fullname;
    @SerializedName("kms")
    @Expose
    private int kms;
    @SerializedName("totalCost")
    @Expose
    private int totalCost;
    @SerializedName("monthlyCost")
    @Expose
    private int monthlyCost;
    @SerializedName("points")
    @Expose
    private int points;
    @SerializedName("__v")
    @Expose
    private int V;

    /**
     * @return The Id
     */
    public String getId() {
        return Id;
    }

    /**
     * @param Id The _id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * @return The clientId
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * @param clientId The client_id
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * @return The fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname The fullname
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return The kms
     */
    public int getKms() {
        return kms;
    }

    /**
     * @param kms The kms
     */
    public void setKms(int kms) {
        this.kms = kms;
    }

    /**
     * @return The totalCost
     */
    public int getTotalCost() {
        return totalCost;
    }

    /**
     * @param totalCost The totalCost
     */
    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * @return The monthlyCost
     */
    public int getMonthlyCost() {
        return monthlyCost;
    }

    /**
     * @param monthlyCost The monthlyCost
     */
    public void setMonthlyCost(int monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    /**
     * @return The points
     */
    public int getPoints() {
        return points;
    }

    /**
     * @param points The points
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * @return The V
     */
    public int getV() {
        return V;
    }

    /**
     * @param V The __v
     */
    public void setV(int V) {
        this.V = V;
    }

}