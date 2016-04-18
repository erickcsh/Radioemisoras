/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 * Manage show info
 * @author erick
 */
public class Show {
    
    private String name;
    private String schedule;
    private int durationInMinutes;
    private String musicalGenre;
    private Broadcaster broadcaster;

    public Show(String name, String schedule, int durationInMinutes, String musicalGenre, Broadcaster broadcaster) {
        this.name = name;
        this.schedule = schedule;
        this.durationInMinutes = durationInMinutes;
        this.musicalGenre = musicalGenre;
        this.broadcaster = broadcaster;
    }
    
    /*
     * Edit the attributes of a show
     * @param name the show name
     * @param schedule the ashow schedule
     * @param musicalGenre the show musicalGenre
     * @param durationInMinutes the show duration
     * @param broadcaster the show broadcaster
    */
    public void edit(String name, String schedule, int durationInMinutes, String musicalGenre, Broadcaster broadcaster) {
        this.name = name;
        this.schedule = schedule;
        this.durationInMinutes = durationInMinutes;
        this.musicalGenre = musicalGenre;
        this.broadcaster = broadcaster;
    }
    
    /*
     * Determines if show is valid
     * @returns true if is valid
    */
    public boolean isValid() {
        return !anyPropertyEmpty() && validDuration() && validBroadcaster();
    }
    
    private boolean validDuration() {
        return durationInMinutes > 0;
    }
    
    private boolean validBroadcaster() {
        return broadcaster != null;
    }
    
    private boolean anyPropertyEmpty() {
        String[] properties = {name, schedule, musicalGenre};
        for(String property : properties) {
            if(property.isEmpty() || property == null) {
                System.out.print(property);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String stringObject ="";
        stringObject = "\n  - Nombre=" + name + 
                 "\n  - Horario=" + schedule + 
                 "\n  - Duración=" + durationInMinutes + 
                 "\n  - Género=" + musicalGenre + 
                 "\n  - Locutor=" + broadcaster.getName() + "\n";
        
        return stringObject;          
    }

    /*
     * Getters and Setters
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public String getMusicalGenre() {
        return musicalGenre;
    }

    public void setMusicalGenre(String musicalGenre) {
        this.musicalGenre = musicalGenre;
    }

    public Broadcaster getBroadcaster() {
        return broadcaster;
    }

    public void setBroadcaster(Broadcaster broadcaster) {
        this.broadcaster = broadcaster;
    }
    
    
}
