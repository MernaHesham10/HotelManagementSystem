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

public class DoubleRoom extends SingleRoom implements Serializable {

    String guestName2;
    String guestContact2;
    String guestGender2;

    DoubleRoom() {
        this.guestName = "";
        this.guestName2 = "";
    }

    DoubleRoom(String name, String contact, String gender, String name2, String contact2, String gender2) {
        this.guestName = name;
        this.guestContact = contact;
        this.guestGender = gender;
        this.guestName2 = name2;
        this.guestContact2 = contact2;
        this.guestGender2 = gender2;
    }
}
