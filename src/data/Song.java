/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 * Manages all the songs info
 * @author erick
 */
public class Song {
    
    private String name;
    private String musicalGenre;
    private String singer;
    private int durationInMinutes;
    
    public Song(String name, String musicalGenre, String singer, int durationInMinutes) {
        this.name = name;
        this.musicalGenre = musicalGenre;
        this.singer = singer;
        this.durationInMinutes = durationInMinutes;
    }
    
    /*
     * Edit the attributes of a show
     * @param name the song name
     * @param musicalGenre the song musicalGenre
     * @param singer the song singer
     * @param durationInMinutes the song duration
    */
    public void edit(String name, String musicalGenre, String singer, int durationInMinutes) {
        this.name = name;
        this.musicalGenre = musicalGenre;
        this.singer = singer;
        this.durationInMinutes = durationInMinutes;
    }
    
     /*
     * Determines if song attributes are valid
     * @returns true if is valid
    */
    public boolean isValid() {
        return !anyPropertyEmpty() && validDuration();
    }
    
    private boolean validDuration() {
        return durationInMinutes > 0;
    }
    
    private boolean anyPropertyEmpty() {
        String[] properties = {name, singer, musicalGenre};
        for(String property : properties) {
            if(property.isEmpty() || property == null) {
                System.out.print(property);
                return true;
            }
        }
        return false;
    }
    
    /*
     * Determines if song is of a genre
     * @params musicalGenre the genre to compar
     * @returns true if is of the same genre, false if not
    */
    public boolean isGenre(String musicalGenre) {
        return this.musicalGenre.equals(musicalGenre);
    }
    
    @Override
    public String toString() {
        String stringObject = "";
        stringObject += name + " - " + singer + "\n" +
                "Duración: " + String.valueOf(durationInMinutes)
                + " Género: " + musicalGenre + "\n";
        return stringObject;
    }
    
    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMusicalGenre() {
        return musicalGenre;
    }

    public void setMusicalGenre(String musicalGenre) {
        this.musicalGenre = musicalGenre;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
    
    
}
