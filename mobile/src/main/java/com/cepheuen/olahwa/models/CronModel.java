package com.cepheuen.olahwa.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CronModel {

    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("days")
    @Expose
    private String days;
    @SerializedName("enabled")
    @Expose
    private boolean enabled;
    @SerializedName("source_lat")
    @Expose
    private double sourceLat;
    @SerializedName("soruce_lon")
    @Expose
    private double soruceLon;
    @SerializedName("dest_lat")
    @Expose
    private double destLat;
    @SerializedName("dest_lon")
    @Expose
    private double destLon;
    @SerializedName("source_text")
    @Expose
    private String sourceText;
    @SerializedName("dest_text")
    @Expose
    private String destText;

    /**
     * @return The time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time The time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return The days
     */
    public String getDays() {
        return days;
    }

    /**
     * @param days The days
     */
    public void setDays(String days) {
        this.days = days;
    }

    /**
     * @return The enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @param enabled The enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return The sourceLat
     */
    public double getSourceLat() {
        return sourceLat;
    }

    /**
     * @param sourceLat The source_lat
     */
    public void setSourceLat(double sourceLat) {
        this.sourceLat = sourceLat;
    }

    /**
     * @return The soruceLon
     */
    public double getSoruceLon() {
        return soruceLon;
    }

    /**
     * @param soruceLon The soruce_lon
     */
    public void setSoruceLon(double soruceLon) {
        this.soruceLon = soruceLon;
    }

    /**
     * @return The destLat
     */
    public double getDestLat() {
        return destLat;
    }

    /**
     * @param destLat The dest_lat
     */
    public void setDestLat(double destLat) {
        this.destLat = destLat;
    }

    /**
     * @return The destLon
     */
    public double getDestLon() {
        return destLon;
    }

    /**
     * @param destLon The dest_lon
     */
    public void setDestLon(double destLon) {
        this.destLon = destLon;
    }

    /**
     * @return The sourceText
     */
    public String getSourceText() {
        return sourceText;
    }

    /**
     * @param sourceText The source_text
     */
    public void setSourceText(String sourceText) {
        this.sourceText = sourceText;
    }

    /**
     * @return The destText
     */
    public String getDestText() {
        return destText;
    }

    /**
     * @param destText The dest_text
     */
    public void setDestText(String destText) {
        this.destText = destText;
    }

}