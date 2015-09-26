
package com.cepheuen.olahwa.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Surcharge {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("value")
    @Expose
    private double value;

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The value
     */
    public double getValue() {
        return value;
    }

    /**
     * @param value The value
     */
    public void setValue(double value) {
        this.value = value;
    }

}
