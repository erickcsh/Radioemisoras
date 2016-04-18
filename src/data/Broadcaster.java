/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author erick
 */
public class Broadcaster {
    
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
   
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String birthdate;

    public Broadcaster(String id, String name, String email, String phone, String address, String birthdate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.birthdate = birthdate;
    }
    
    /*
     * Edit the attributes of a broadcaster
     * @param id the broadcaster id
     * @param name the broadcaster name
     * @param email the broadcaster email
     * @param phone the broadcaster phone
     * @param address the broadcaster address
     * @param birthdate the broadcaster birthdate
    */
    public void edit(String id, String name, String email, String phone, String address, String birthdate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.birthdate = birthdate;
    }
    
    /*
     * Define if a broadcaster has valid attributes
     * @return true if is valid, false if not
    */
    public boolean isValid() {
        return !anyPropertyEmpty() && validEmail() && validPhone();
    }
    
    private boolean validEmail() {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
        return matcher.find();
    }
    
    private boolean validPhone() {
        return phone.length() == 8;
    }
    
    private boolean anyPropertyEmpty() {
        String[] properties = {id, name, email, phone, address, birthdate};
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
        stringObject = "Locutor\n" + 
                 "Id=" + id + 
                 "\n  - Nombre=" + name + 
                 "\n  - Correo=" + email + 
                 "\n  - Tel=" + phone + 
                 "\n  - Dirección=" + address + 
                 "\n  - Fecha de nacimiento=" + birthdate + "\n";
        
        return stringObject;          
    }
    
    /*
     * Getters and Setters
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }    
    
}
