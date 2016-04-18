/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.SongExcelParser;
import data.CD;
import data.Song;
import data.SongContainer;
import data.SongFile;
import business.SongsList;
import java.io.File;
import java.util.ArrayList;

/**
 * Manages all actions on the songs
 * @author erick
 */
public class SongController {
    
    private SongsList songsList;
    private SongContainer selectedSongContainer;
    private CD currentCD;
    
    public SongController(SongsList songsList) {
        this.songsList = songsList;
    }
    
    public boolean newSongFile(String albumName, String songName, String singer, 
            String duration, String musicalGenre, String location) {
        try {
            SongFile file = new SongFile(albumName, singer, musicalGenre, location,
                    songName, Integer.parseInt(duration));
            return songsList.add(file);
        } catch(Exception e) {
            return false;
        }
    }
    
    public boolean editSongFile(String albumName, String songName, String singer, 
            String duration, String musicalGenre, String location) {
        try {
            SongFile file = new SongFile(albumName, singer, musicalGenre, location,
                    songName, Integer.parseInt(duration));
            if(file.isValid()) {
                ((SongFile)this.selectedSongContainer).edit(albumName, singer, musicalGenre, location,
                    songName, Integer.parseInt(duration));
                return true;
            } else {
                return false;
            }
        } catch(Exception e) {
            return false;
        }
    }
    
    public boolean newCD(String albumName, String singer, String musicalGenre, String year, String location, String imagePath) {
        this.setCurrentCDInfo(albumName, singer, musicalGenre, year, location, imagePath);
        return this.songsList.add(this.currentCD);
    }

    public boolean editCD(String albumName, String singer, String musicalGenre, String year, String location, String imagePath) {
        this.setCurrentCDInfo(albumName, singer, musicalGenre, year, location, imagePath);
        if(this.currentCD.isValid()) {
            ((CD)this.selectedSongContainer).edit(albumName, singer, musicalGenre, location,
                    year, imagePath, this.currentCD.getSongs());
            return true;
        } else {
            return false;
        }
    }
    
    public void setCurrentCD() {
        if(this.selectedSongContainer instanceof CD) {
            ArrayList<Song> songs = new ArrayList<Song>(((CD)this.selectedSongContainer).getSongs());
            this.currentCD = new CD(songs);
        } else {
            this.currentCD = new CD();
        }
    }
    
    public boolean addSongToCurrentCD(String name, String musicalGenre, String singer, String duration) {
        return this.currentCD.addSong(name, musicalGenre, singer, duration);
    }
    
    public boolean selectSongContainer(String id) {
        try {
            int idAsInt = Integer.parseInt(id);
            SongContainer container = this.songsList.get(idAsInt);
            if(container != null) {
                this.selectedSongContainer = container;
                return true;
            } else {
                return false;
            }
        } catch(Exception e) {
            return false;
        }
    }
    
    public String searchSongsBySinger(String singer) {
        return this.songsList.findAllBySinger(singer);
    }
    
    public String searchSongsByGenre(String genre) {
        return this.songsList.findAllByGenre(genre);
    }
    
    public String displayList() {
        return this.songsList.toString();
    }
    
    public String currentCDSongsList() {
        return this.currentCD.songsToString();
    }
         
    public void cleanSelectedSongContainer() {
        this.selectedSongContainer = null;
    }
    
    public void cleanCurrentCD() {
        this.currentCD = null;
    }
    
    private void setCurrentCDInfo(String albumName, String singer, String musicalGenre, String year, String location, String imagePath) {
        currentCD.setAlbumName(albumName);
        currentCD.setSinger(singer);
        currentCD.setMusicalGenre(musicalGenre);
        currentCD.setYear(year);
        currentCD.setLocation(location);
        currentCD.setImagePath(imagePath);
    }
    
    public void importSongFiles(File fileSelected) {
        SongExcelParser parser = new SongExcelParser();
        ArrayList<SongContainer> songFiles = parser.fileToSongFiles(fileSelected);
        this.songsList.addAll(songFiles);
    }
    
    
    public void importCDSongs(File fileSelected) {
        SongExcelParser parser = new SongExcelParser();
        ArrayList<Song> songs = parser.fileToCDSongs(fileSelected);
        this.currentCD.addSongs(songs);
    }
    
    
    public boolean exportSongs(File fileSelected) {
        SongExcelParser parser = new SongExcelParser();
        return parser.songsToFile(fileSelected, this.songsList.getList());
    }
    
    // Getters and setters

    public SongContainer getSelectedSongContainer() {
        return selectedSongContainer;
    }

    public void setSelectedSongContainer(SongContainer selectedSongContainer) {
        this.selectedSongContainer = selectedSongContainer;
    }
    
}
