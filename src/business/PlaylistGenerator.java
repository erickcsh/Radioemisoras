/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.filter;
import data.Show;
import data.Song;
import data.SongContainer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Generates a playlist that lasts at least 5 minutes less than the show duration
 * @author erick
 */
public class PlaylistGenerator {
     
    private static final int EMPTY_PLAYLIST_TIME = 5;
    
    /*
     * Generates a playlist for the show matching the genre and
     * last at least 5 minutes less than the show duratio
     * @params show the show for which the playlist is going to be generates
     * @params songsList the lists from where the songs from the playlist are being selected
     * @return a string that sumarizes the selected songs
    */
     public static String generateRandomPlaylist(Show show, SongsList songsList) {
        String result = "Playlist for " + show.getName() + "\n";
        int duration = show.getDurationInMinutes();
        String musicalGenre = show.getMusicalGenre();
        result += generateRandomPlaylist(songsList.getList(), duration, musicalGenre);
        return result;
     }
     
    /*
     * Generates a playlist for the show matching the genre and
     * last at least 5 minutes less than the show duration
     * @params songContainerList the song container collection
     * @params duration the max duration of the playlist
     * @params musicalGenre the genre of the songs in the playlist
     * @return a string that sumarizes the selected songs
    */
    private static String generateRandomPlaylist(ArrayList<SongContainer> songContainerList, int duration, String musicalGenre) {
        int totalDuration = 0;
        String result = "";
        ArrayList<Song> songs;
        List<SongContainer> containers = filterRandomSongContainersByGenre(songContainerList, musicalGenre);
        for(SongContainer container : containers) {
            songs = container.findByMusicalGenre(musicalGenre);
            Collections.shuffle(songs);
            for(Song song : songs) {
                if(isSongValidForPlaylist(song, totalDuration, duration)) {
                    result += "Album: " + container.getAlbumName() + "\n" +
                            song.toString() + 
                            "Ubicación: " + container.getLocation() + "\n";
                    totalDuration += song.getDurationInMinutes();
                    break;
                }
            }
        }
        
        return result;
    }
    
    /*
     * Selects the song containers that has songs with a particular genre
     * @params songContainerList the song container collection
     * @params genre the genre to select the containers
     * @return the list of the containers that has a song with the genre
    */
    private static List<SongContainer> filterRandomSongContainersByGenre(ArrayList<SongContainer> songContainerList, String genre) {
        List<SongContainer> containers = filter(having(on(SongContainer.class).hasSongWithGenre(genre)), songContainerList);
        Collections.shuffle(containers);
        return containers;
    }
    
    /*
     * Validates if the song duration plus the accumulated duration
     * is shorter than the playlist max duration - 5 minutes
     * @params Song the song to validate
     * @params accumulatedDuration the  duration of the songs in the playlist
     * @params maxDuration the maxDuration of the playlist
     * @return true if song can be added, false if not
    */
    private static boolean isSongValidForPlaylist(Song song, int accumulatedDuration, int maxDuration) {
        return song.getDurationInMinutes() + accumulatedDuration < maxDuration - EMPTY_PLAYLIST_TIME;
    }
    
}
