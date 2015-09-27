package com.cepheuen.olahwa.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MusicRequestModel {

    @SerializedName("crn")
    @Expose
    private String crn;
    @SerializedName("songs")
    @Expose
    private List<MusicListModel> songs = new ArrayList<MusicListModel>();

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
     * @return The songs
     */
    public List<MusicListModel> getSongs() {
        return songs;
    }

    /**
     * @param songs The songs
     */
    public void setSongs(List<MusicListModel> songs) {
        this.songs = songs;
    }

}