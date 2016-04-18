/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.Broadcaster;
import java.util.ArrayList;

/**
 *
 * Manages a list of broadcasters, can add and get information of them
 * @author erick
 */
public class BroadcastersList {
    
    protected ArrayList<Broadcaster> list;
    
    /*
     * Createa a new BroadcasterList with an empty collection
    */
    public BroadcastersList() {
        this.list = new ArrayList<Broadcaster>();
    }
    
    /*
     * Adds a broadcaster to the list
     * @params broadcaster the broadcaster to add
    */
    public boolean add(Broadcaster broadcaster) {
        if(broadcaster.isValid()) {
            this.list.add(broadcaster);
            return true;
        } else {
            return false;
        }
    }
    
    /*
     * Selects a broadcaster from the list
     * @params index the index of the desired broadcaster in the list
     * @return the broadcaster in the index position
    */
    public Broadcaster get(int index) {
        return this.list.get(index);
    }
    /*
     * Selects a broadcaster from the list with the correponding id
     * @params id the id of the desired broadcaster in the list
     * @return the broadcaster with the id selected
    */
    public Broadcaster getById(String id) {
        for(Broadcaster broadcaster : this.list) {
            if(broadcaster.getId().equals(id)) {
                return broadcaster;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        String listAsString = "";
        for(Broadcaster broadcaster : list) {
            listAsString += broadcaster.toString();
        }
        return listAsString;
    }
    
    // Getter

    public ArrayList<Broadcaster> getList() {
        return list;
    }
    
}
