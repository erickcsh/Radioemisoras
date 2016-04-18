/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.Broadcaster;
import business.BroadcastersList;

/**
 * Manages the broadcaster
 * @author erick
 */
public class BroadcasterController {
    
    private BroadcastersList broadcasters;
    private Broadcaster selectedBroadcaster;
    
    public BroadcasterController(BroadcastersList broadcasters) {
        this.broadcasters = broadcasters;
    }
    
    public BroadcasterController() {
        this.broadcasters = new BroadcastersList();
    }
    
    public boolean newBroadcaster(String id, String name, String email, String phone,
            String address, String birthdate) {
        Broadcaster broadcaster = new Broadcaster(id, name, email, phone, address, birthdate);
        return this.broadcasters.add(broadcaster);
    }
    
    public boolean editBroadcaster(String id, String name, String email, String phone,
            String address, String birthdate) {
        Broadcaster broadcaster = new Broadcaster(id, name, email, phone, address, birthdate);
        if(broadcaster.isValid()) {
            this.selectedBroadcaster.edit(id, name, email, phone, address, birthdate);
            return true;
        } else {
            return false;
        }
    }
    
    public String displayList() {
        return this.broadcasters.toString();
    }
    
    public boolean selectBroadcaster(String id) {
        Broadcaster broadcaster = this.broadcasters.getById(id);
        if(broadcaster != null) {
            this.selectedBroadcaster = broadcaster;
            return true;
        } else {
            return false;
        }
    }
    
    public void cleanSelectedBroadcaster() {
        this.selectedBroadcaster = null;
    }
    
    // Getters and Setters

    public Broadcaster getSelectedBroadcaster() {
        return selectedBroadcaster;
    }

    public void setSelectedBroadcaster(Broadcaster selectedBroadcaster) {
        this.selectedBroadcaster = selectedBroadcaster;
    }
    
}
