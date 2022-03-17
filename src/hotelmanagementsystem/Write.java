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
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Write implements Runnable {

    CapacityOfRoom ob;

    Write(CapacityOfRoom ob) {
        this.ob = ob;
    }

    @Override
    public void run() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("DatabaseOfHotelManagementSystem");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(ob);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println("Error!, In Writing: " + e);
        }
    }

}
