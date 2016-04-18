/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.Broadcaster;
import business.BroadcastersList;
import business.EmailSender;
import business.PlaylistGenerator;
import data.RadioStation;
import data.Show;
import java.util.ArrayList;

/**
 * Manages all operations on show
 * @author erick
 */
public class ShowController {
    
    private RadioStation station;
    private Show selectedShow;
    
    public ShowController(RadioStation station) {
        this.station = station;
    }
    
    public boolean newShow(String name, String duration, String schedule, String musicalGenre, Object broadcaster) {
        try {
            Show show = new Show(name, schedule, Integer.parseInt(duration), musicalGenre, (Broadcaster) broadcaster);
            if(show.isValid()) {
                station.addShow(show);
                return true;
            } else {
                return false;
            }
        } catch(Exception e) {
            return false;
        }
    }
    
    public boolean editShow(String name, String duration, String schedule, String musicalGenre, Object broadcaster) {
        try {
            Show show = new Show(name, schedule, Integer.parseInt(duration), musicalGenre, (Broadcaster) broadcaster);
            if(show.isValid()) {
                this.selectedShow.edit(name, schedule, Integer.parseInt(duration), musicalGenre, (Broadcaster)broadcaster);
                return true;
            } else {
                return false;
            }   
        } catch(Exception e) {
            return false;
        }
    }
    
    public boolean selectShow(String id) {
        try {
            int idAsInt = Integer.parseInt(id);
            Show show = this.station.getShow(idAsInt);
            if(show != null) {
                this.selectedShow = show;
                return true;
            } else {
                return false;
            }
        } catch(Exception e) {
            return false;
        }
    }
    
    public String getPlaylistForSelectedShow() {
        String playlist = PlaylistGenerator.generateRandomPlaylist(this.selectedShow, this.station.getSongs());
        EmailSender.sendEmail(this.selectedShow.getBroadcaster().getEmail(), playlist);
        return playlist;
    }
    
    public String displayList() {
        String displayList = "";
        String showAsString = "";
        ArrayList<Show> shows = this.station.getShows();
        for(int i = 0; i < shows.size(); i++) {
            showAsString = "ID: " + i + "\n" + shows.get(i).toString() + "\n";
            displayList += showAsString;
        }
        return displayList;
    }
    
    public void cleanSelectedShow() {
        this.selectedShow = null;
    }
    
    public ArrayList<Broadcaster> broadcastersOptions() {
        return this.station.getBroadcasters().getList();
    }
    
    // Getters and setters

    public Show getSelectedShow() {
        return selectedShow;
    }

    public void setSelectedShow(Show selectedShow) {
        this.selectedShow = selectedShow;
    }
    
}
