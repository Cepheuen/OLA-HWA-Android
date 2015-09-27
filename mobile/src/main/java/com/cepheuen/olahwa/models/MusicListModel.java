
package com.cepheuen.olahwa.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MusicListModel {

    @SerializedName("_id")
    @Expose
    private String Id;
    @SerializedName("musicId")
    @Expose
    private int musicId;
    @SerializedName("songName")
    @Expose
    private String songName;
    @SerializedName("albumName")
    @Expose
    private String albumName;
    @SerializedName("url")
    @Expose
    private String url;

    private boolean selected;
    /**
     * 
     * @return
     *     The Id
     */
    public String getId() {
        return Id;
    }

    /**
     * 
     * @param Id
     *     The _id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * 
     * @return
     *     The musicId
     */
    public int getMusicId() {
        return musicId;
    }

    /**
     * 
     * @param musicId
     *     The musicId
     */
    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }

    /**
     * 
     * @return
     *     The songName
     */
    public String getSongName() {
        return songName;
    }

    /**
     * 
     * @param songName
     *     The songName
     */
    public void setSongName(String songName) {
        this.songName = songName;
    }

    /**
     * 
     * @return
     *     The albumName
     */
    public String getAlbumName() {
        return albumName;
    }

    /**
     * 
     * @param albumName
     *     The albumName
     */
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }


    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}
