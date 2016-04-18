/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 * Manages all data of a song file
 * @author erick
 */
public class SongFile extends SongContainer {
    
    public SongFile(String albumName, String singer, String musicalGenre, String location, 
            String songName, int durationInMinutes) {
        this.songs = new ArrayList<>(1);
        Song song = new Song(songName, musicalGenre, singer, durationInMinutes);
        this.albumName = albumName;
        this.location = location;
        this.musicalGenre = musicalGenre;
        this.singer = singer;
        this.songs.add(song);
    }
    
    /*
     * Edit the attributes of a song file
     * @param albumName the album name
     * @param singer the song singer
     * @param musicalGenre the musicalGenre 
     * @param location the path of the file
     * @param songName the song name
     * @param durationInMinutes the song duration
    */
    public void edit(String albumName, String singer, String musicalGenre, String location, 
            String songName, int durationInMinutes) {
        this.getSong().edit(songName, musicalGenre, singer, durationInMinutes);
        this.albumName = albumName;
        this.location = location;
        this.musicalGenre = musicalGenre;
        this.singer = singer;
    }
    
    /*
     * Selects the song contained in the file
     * @returns the song in the file
    */
    public Song getSong() {
        return songs.get(0);
    }
    
    private boolean anyPropertyEmpty() {
        String[] properties = {albumName, singer, musicalGenre, location};
        for(String property : properties) {
            if(property.isEmpty() || property == null) {
                System.out.print(property);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean isValid() {
        return !anyPropertyEmpty() && getSong().isValid();
    }

    @Override
    public boolean hasSongWithGenre(String musicalGenre) {
        return this.musicalGenre.equals(musicalGenre);
    }
    
    @Override
    public ArrayList<Song> findBySinger(String singer) {
        if(this.getSong().getSinger().equals(singer)) {
            return this.songs;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public ArrayList<Song> findByMusicalGenre(String musicalGenre) {
        if(this.getSong().isGenre(musicalGenre)) {
            return this.songs;
        } else {
            return new ArrayList<>();
        }
    }
    
    @Override
    public String toString() {
        String stringObject = "";
        stringObject += "Archivo de Canción: \n" +
                "Álbum: " + albumName + "\n" +
                getSong().toString() +
                "Ubicación: " + location + "\n";
        return stringObject;
    }
    
    public String getSongName() {
        return getSong().getName();
    }
    
    public int getDurationInMinutes() {
        return getSong().getDurationInMinutes();
    }
    
}
