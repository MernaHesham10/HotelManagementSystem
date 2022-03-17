/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

/**
 *
 * @author DELL
 */
import java.io.Serializable;
import java.util.ArrayList;

public class SingleRoom implements Serializable {

    String guestName;
    String guestContact;
    String guestGender;
    ArrayList<Food> foodMenu = new ArrayList<>();

    SingleRoom() {
        this.guestName = "";
    }

    SingleRoom(String name, String contact, String gender) {
        this.guestName = name;
        this.guestContact = contact;
        this.guestGender = gender;
    }
}
