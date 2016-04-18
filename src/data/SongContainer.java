/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 * Abstract class that defines the basic structure of a song container (CD, File)
 * @author erick
 */
public abstract class SongContainer {
    
    protected String albumName;
    protected String singer;
    protected String musicalGenre;
    protected String location;
    protected ArrayList<Song> songs;
    
     /*
     * Determines if container attributes are valid
     * @returns true if is valid
    */
    public abstract boolean isValid();
    
     /*
     * Determines if has at least 1 song with the genre passed
     * @param musicalGenre the genre to compare
     * @returns true if has 1 song with matching genre
    */
    public abstract boolean hasSongWithGenre(String musicalGenre);
    
     /*
     * Returns all the song that match a singer
     * @param singer the singer to compare
     * @returns the list of songs with the passed singer
    */
    public abstract ArrayList<Song> findBySinger(String singer);
    
     /*
     * Returns all the song that match a genre
     * @param musicalGenre the genre to compare
     * @returns the list of songs with the passed genre
    */
    public abstract ArrayList<Song> findByMusicalGenre(String musicalGenre);


    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getMusicalGenre() {
        return musicalGenre;
    }

    public void setMusicalGenre(String musicalGenre) {
        this.musicalGenre = musicalGenre;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
    
}
