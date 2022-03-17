/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class HotelManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //Create File as Database to save records in it
            File file = new File("DatabaseOfHotelManagementSystem");
            if (file.exists()) {
                FileInputStream fin = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fin);
                Hotel.ob = (CapacityOfRoom) ois.readObject();
            }
            Scanner sc = new Scanner(System.in);
            int EnteredUserchoice, EnteredUserchoice2;
            char wantToContinue;
            MainMenu:
            do {

                System.out.println("\nSelect What Do You Want To Do :\n1.Display Details odf Room  \n2.Display if there's a Room Available \n3.Book Room\n4.Order Food\n5.Checkout \n6.Exit\n");
                EnteredUserchoice = sc.nextInt();
                switch (EnteredUserchoice) {

                    //Luxuries Of Room
                    case 1:
                        System.out.println("\nChoose Room Type :\n1.Luxury Single Bedroom\n2.Deluxe Single Bedroom\n3.Luxury Double Bedroom\n4.Deluxe Double Bedroom\n");
                        EnteredUserchoice2 = sc.nextInt();
                        Hotel.RoomLuxuries(EnteredUserchoice2);
                        break;

                    //Check availability Of Room   
                    case 2:
                        System.out.println("\nChoose Room Type :\n1.Luxury Single Bedroom\n2.Deluxe Single Bedroom\n3.Luxury Double Bedroom\n4.Deluxe Double Bedroom\n");
                        EnteredUserchoice2 = sc.nextInt();
                        Hotel.CheckavailabilityRoom(EnteredUserchoice2);
                        break;

                    //Room Booking    
                    case 3:
                        System.out.println("\nChoose Room Type :\n1.Luxury Single Bedroom\n2.Deluxe Single Bedroom\n3.Luxury Double Bedroom\n4.Deluxe Double Bedroom\n");
                        EnteredUserchoice2 = sc.nextInt();
                        Hotel.RoomBooking(EnteredUserchoice2);
                        break;

                    //Check if Room is Found Or Not if Found then it can Order Food   
                    case 4:
                        System.out.print("Room Number: ");
                        EnteredUserchoice2 = sc.nextInt();
                        if (EnteredUserchoice2 > 60) {
                            System.out.println("Room doesn't Found");
                        } else if (EnteredUserchoice2 > 40) {
                            Hotel.OrderFood(EnteredUserchoice2 - 41, 4);
                        } else if (EnteredUserchoice2 > 30) {
                            Hotel.OrderFood(EnteredUserchoice2 - 31, 3);
                        } else if (EnteredUserchoice2 > 10) {
                            Hotel.OrderFood(EnteredUserchoice2 - 11, 2);
                        } else if (EnteredUserchoice2 > 0) {
                            Hotel.OrderFood(EnteredUserchoice2 - 1, 1);
                        } else {
                            System.out.println("Room doesn't Found");
                        }
                        break;

                    //Check if Room is Found Or Not if Found then it can Order Food   
                    case 5:
                        System.out.print("Room Number: ");
                        EnteredUserchoice2 = sc.nextInt();
                        if (EnteredUserchoice2 > 60) {
                            System.out.println("Room Doesn't Found");
                        } else if (EnteredUserchoice2 > 40) {
                            Hotel.Deallocating(EnteredUserchoice2 - 41, 4);
                        } else if (EnteredUserchoice2 > 30) {
                            Hotel.Deallocating(EnteredUserchoice2 - 31, 3);
                        } else if (EnteredUserchoice2 > 10) {
                            Hotel.Deallocating(EnteredUserchoice2 - 11, 2);
                        } else if (EnteredUserchoice2 > 0) {
                            Hotel.Deallocating(EnteredUserchoice2 - 1, 1);
                        } else {
                            System.out.println("Room doesn't exist");
                        }
                        break;
                        
                    //Exit from Application    
                    case 6:
                        break MainMenu;
                        
                    default:
                        System.out.println("Please Select From Menu");
                }
                System.out.println("\nDo You Want To Do Anthing Else(Y/N): ");
                wantToContinue = sc.next().charAt(0);
                if (!(wantToContinue == 'y' || wantToContinue == 'Y' || wantToContinue == 'n' || wantToContinue == 'N')) {
                    System.out.println("Invalid Selected");
                    System.out.println("\nDo You Want To Do Anthing Else(Y/N): ");
                    wantToContinue = sc.next().charAt(0);
                }

            } while (wantToContinue == 'y' || wantToContinue == 'Y');

            Thread thread = new Thread(new Write(Hotel.ob));
            thread.start();
        } catch (Exception e) {
            System.out.println("Please Select From Menu");
        }
    }
}
