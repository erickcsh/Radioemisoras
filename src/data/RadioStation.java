/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.SongsList;
import business.BroadcastersList;
import java.util.ArrayList;

/**
 * Manages all radio station info
 * @author erick
 */
public class RadioStation {
    
    private String name;
    private String address;
    private String frequency;
    private String url;
    private BroadcastersList broadcasters;
    private SongsList songs;
    private ArrayList<Show> shows;

    public RadioStation(String name, String address, String frequency, String url) {
        this.name = name;
        this.address = address;
        this.frequency = frequency;
        this.url = url;
        this.broadcasters = new BroadcastersList();
        this.songs = new SongsList();
        this.shows = new ArrayList<Show>();
    }

    public RadioStation() {
        this("", "", "", "");
    }
    
    public void addShow(Show show) {
        this.shows.add(show);
    }
    
    public Show getShow(int index) {
        return this.shows.get(index);
    }
    
    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BroadcastersList getBroadcasters() {
        return broadcasters;
    }

    public void setBroadcasters(BroadcastersList broadcasters) {
        this.broadcasters = broadcasters;
    }

    public SongsList getSongs() {
        return songs;
    }

    public void setSongs(SongsList songs) {
        this.songs = songs;
    }

    public ArrayList<Show> getShows() {
        return shows;
    }

    public void setShows(ArrayList<Show> shows) {
        this.shows = shows;
    }
    
}
