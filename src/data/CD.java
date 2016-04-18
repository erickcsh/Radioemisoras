/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.filter;
import java.util.ArrayList;
import java.util.List;


/**
 * Manages CD info extends SongContainer
 * @author erick
 */
public class CD extends SongContainer {
    
    private String year;
    private String imagePath;

    public CD() {
        this.albumName = "";
        this.singer = "";
        this.musicalGenre = "";
        this.location = "";
        this.songs = new ArrayList<>();
        this.year = "";
        this.imagePath = "";
    }
    
    public CD(ArrayList<Song> songs) {
        this.albumName = "";
        this.singer = "";
        this.musicalGenre = "";
        this.location = "";
        this.songs = songs;
        this.year = "";
        this.imagePath = "";
    }
    
    public CD(String albumName, String singer, String musicalGenre, String location, String year, String imagePath) {
        this.albumName = albumName;
        this.singer = singer;
        this.musicalGenre = musicalGenre;
        this.location = location;
        this.year = year;
        this.imagePath = imagePath;
        this.songs = new ArrayList<>();
    }
    
    /*
     * Edit the attributes of a CD
     * @param albumName the album name
     * @param musicalGenre the album singer
     * @param location the album musicalGenre
     * @param year the album location
     * @param imagePath the album image
     * @params songs the lists of cd songs
    */
    public void edit(String albumName, String singer, String musicalGenre, String location,
            String year, String imagePath, ArrayList<Song> songs) {
        this.albumName = albumName;
        this.singer = singer;
        this.musicalGenre = musicalGenre;
        this.location = location;
        this.year = year;
        this.imagePath = imagePath;
        this.songs = songs;
    }
    
    /*
     * Add a song to the CD
     * @param name the song name
     * @param musicalGenre the song genre
     * @param singer the song singer
     * @duration the song furation
     * @return true if the song was added
    */
    public boolean addSong(String name, String musicalGenre, String singer, String duration) {
        try {
            Song song = new Song(name, musicalGenre, singer, Integer.parseInt(duration));
            if(song.isValid()) {
                return this.songs.add(song);
            } else {
                return false;
            }
        } catch(Exception e) {
            return false;
        }
    }
    
    /*
     * Add songs to the CD
     * @param songs the list of songs to add
    */
    public void addSongs(ArrayList<Song> songs) {
        this.songs.addAll(songs);
    }
     
    @Override
    public boolean isValid() {
        return !anyPropertyEmpty();
    }

    @Override
    public boolean hasSongWithGenre(String musicalGenre) {
        List<Song> songsWithGenre = filter(having(on(Song.class).isGenre(musicalGenre)), this.songs);
        return !songsWithGenre.isEmpty();
    }
     
    @Override
    public ArrayList<Song> findBySinger(String singer) {
        ArrayList<Song> result = new ArrayList<>();
        for(Song song : this.songs) {
            if(song.getSinger().equals(singer)) {
                result.add(song);
            }
        }
        return result;
    }

    @Override
    public ArrayList<Song> findByMusicalGenre(String musicalGenre) {
        ArrayList<Song> result = new ArrayList<>();
        for(Song song : this.songs) {
            if(song.isGenre(musicalGenre)) {
                result.add(song);
            }
        }
        return result;
    }
    
    @Override
    public String toString() {
        String stringObject = "";
        stringObject += "Disco: " + albumName + "\n" +
                "Cantante: " + singer + "\n" +
                "Género: " + musicalGenre + "\n" +
                "Año: " + year + "\n" +
                "Ubicación: " + location + "\n" +
                "Imagen: " + imagePath + "\n" +
                "Canciones: \n";
        stringObject += songsToString();
        return stringObject;
    }
    
    public String songsToString() {
        String stringObject = "";
        for(int i = 0; i < this.songs.size(); i++) {
            Song song = this.songs.get(i);
            stringObject += (i + 1) + ". " + song.toString();
        }
        return stringObject + "\n";
    }
            
    private boolean anyPropertyEmpty() {
        String[] properties = {albumName, singer, musicalGenre, location, year};
        for(String property : properties) {
            if(property.isEmpty() || property == null) {
                System.out.print(property);
                return true;
            }
        }
        return false;
    }
    
    // Getters and setters

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
}
