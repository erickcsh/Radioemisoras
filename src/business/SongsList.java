/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.Song;
import data.SongContainer;
import java.util.ArrayList;

/**
 * Handles a list of SongContainers
 * @author erick
 */
public class SongsList {
    
    private ArrayList<SongContainer> list;
    
    /*
     * Creates a new SongsList with an empty list
    */
    public SongsList() {
        this.list = new ArrayList<SongContainer>();
    }
    
    /*
     * Add a songContainer to the list
     * @params songType the songContainer to add
     * @return true if the songContainer was added
    */
    public boolean add(SongContainer songType) {
        if(songType.isValid()) {
            this.list.add(songType);
            return true;
        } else {
            return false;
        }
    }
    
    /*
     * Adds a list of songContainers to the list
     * @params songContainerList the songContainers to add
     * @return true if the songContainers were added
    */
    public void addAll(ArrayList<SongContainer> songContainerList) {
        this.list.addAll(songContainerList);
    }
    
    /*
     * Selects the songContainer with index
     * @params int the index of the desired songContainer
     * @return the songContainer in the index position
    */
    public SongContainer get(int index) {
        return this.list.get(index);
    }
    
    /*
     * Find all Songs that have a genre and converts them to string
     * @params genre the genre to select the songs
     * @return a string of all of the songs that match the genre
    */
    public String findAllByGenre(String genre) {
        ArrayList<Song> matcherSongs;
        String results = "";
        for(SongContainer container : this.list) {
            matcherSongs = container.findByMusicalGenre(genre);
            for(Song song : matcherSongs) {
                results += song.toString() + 
                        "Álbum: " + container.getAlbumName() + "\n\n";
            }
        }
        setNoResultsMessage(results);
        return results;
    }
    
    /*
     * Find all Songs that have a singer and converts them to string
     * @params singer the singer to select the songs
     * @return a string of all of the songs that match the singer
    */
    public String findAllBySinger(String singer) {
        ArrayList<Song> matcherSongs;
        String results = "";
        for(SongContainer container : this.list) {
            matcherSongs = container.findBySinger(singer);
            for(Song song : matcherSongs) {
                results += song.toString() + 
                        "Álbum: " + container.getAlbumName() + "\n\n";
            }
        }
        setNoResultsMessage(results);
        return results;
    }
    
    @Override
    public String toString() {
        String stringObject = "";
        for(int i = 0; i < this.list.size(); i++) {
            SongContainer container = this.list.get(i);
            stringObject += "ID: " + i + "\n" + container.toString() + "\n";
        }
        return stringObject;
    }
    
    private void setNoResultsMessage(String results) {
        if(results.isEmpty()) {
            results = "No se encontraron resultados para la búsqueda";
        }
    }
        
    // Getters

    public ArrayList<SongContainer> getList() {
        return list;
    }
    
}
