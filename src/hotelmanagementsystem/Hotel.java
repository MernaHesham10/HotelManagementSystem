/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import java.util.Scanner;
import hotelmanagementsystem.*;

/**
 *
 * @author DELL
 */
public class Hotel {

    static CapacityOfRoom ob = new CapacityOfRoom();
    static Scanner sc = new Scanner(System.in);

    static void CustDetails(int i, int rn) {
        String name, contact, gender;
        String name2 = null, contact2 = null;
        String gender2 = "";
        System.out.print("\nEnter customer name: ");
        name = sc.next();
        System.out.print("Enter contact number: ");
        contact = sc.next();
        System.out.print("Enter gender: ");
        gender = sc.next();
        if (i < 3) {
            System.out.print("Enter second customer name: ");
            name2 = sc.next();
            System.out.print("Enter contact number: ");
            contact2 = sc.next();
            System.out.print("Enter gender: ");
            gender2 = sc.next();
        }

        switch (i) {
            case 1:
                ob.arr1[rn] = new DoubleRoom(name, contact, gender, name2, contact2, gender2);
                break;
            case 2:
                ob.arr2[rn] = new DoubleRoom(name, contact, gender, name2, contact2, gender2);
                break;
            case 3:
                ob.arr3[rn] = new SingleRoom(name, contact, gender);
                break;
            case 4:
                ob.arr4[rn] = new SingleRoom(name, contact, gender);
                break;
            default:
                System.out.println("Wrong option");
                break;
        }
    }

    //Room Booking
    static void RoomBooking(int i) {
        int j;
        int RoomNumber;
        System.out.println("\nSelect Room Number From : ");
        switch (i) {
            case 1:
                for (j = 0; j < ob.arr3.length; j++) {
                    if (ob.arr3[j] == null) {
                        System.out.print(j + 31 + ",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try {
                    RoomNumber = sc.nextInt();
                    RoomNumber = RoomNumber - 31;
                    if (ob.arr3[RoomNumber] != null) {
                        throw new NotAvailableRooms();
                    }
                    CustDetails(i, RoomNumber);
                } catch (Exception e) {
                    System.out.println("Invalid Choice");
                    return;
                }
                break;
            case 2:
                for (j = 0; j < ob.arr4.length; j++) {
                    if (ob.arr4[j] == null) {
                        System.out.print(j + 41 + ",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try {
                    RoomNumber = sc.nextInt();
                    RoomNumber = RoomNumber - 41;
                    if (ob.arr4[RoomNumber] != null) {
                        throw new NotAvailableRooms();
                    }
                    CustDetails(i, RoomNumber);
                } catch (Exception e) {
                    System.out.println("Invalid Choice");
                    return;
                }
                break;
            case 3:
                for (j = 0; j < ob.arr1.length; j++) {
                    if (ob.arr1[j] == null) {
                        System.out.print(j + 1 + ",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try {
                    RoomNumber = sc.nextInt();
                    RoomNumber--;
                    if (ob.arr1[RoomNumber] != null) {
                        throw new NotAvailableRooms();
                    }
                    CustDetails(i, RoomNumber);
                } catch (Exception e) {
                    System.out.println("Invalid Choice");
                    return;
                }
                break;
            case 4:
                for (j = 0; j < ob.arr2.length; j++) {
                    if (ob.arr2[j] == null) {
                        System.out.print(j + 11 + ",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try {
                    RoomNumber = sc.nextInt();
                    RoomNumber = RoomNumber - 11;
                    if (ob.arr2[RoomNumber] != null) {
                        throw new NotAvailableRooms();
                    }
                    CustDetails(i, RoomNumber);
                } catch (Exception e) {
                    System.out.println("Invalid Choice");
                    return;
                }
                break;

            default:
                System.out.println("Please Select From Menu");
                break;
        }
        System.out.println("The Room Has Been Booked Successfully.");
    }

    //Luxuries of Room
    static void RoomLuxuries(int i) {
        switch (i) {
            case 1:
                System.out.println("Single Beds Number:  1\nAC : Yes\nFree Breakfast : Yes\nCost For Day:2200");
                break;
            case 2:
                System.out.println("Single Beds Number:  1\nAC : No\nFree Breakfast : Yes\nCost For Day:1200");
                break;
            case 3:
                System.out.println("Double Beds Number:  1\nAC : Yes\nFree Breakfast : Yes\nCost For Day:4000");
                break;
            case 4:
                System.out.println("Double Beds Number:  1\nAC : No\nFree Breakfast : Yes\nCost For Day:3000");
                break;
            default:
                System.out.println("Please Select From Menu");
                break;
        }
    }

    //Check availability of Room In Hotel 
    static void CheckavailabilityRoom(int i) {
        int j, NoOfRoomAvailable = 0;
        switch (i) {
            case 1:
                for (j = 0; j < ob.arr3.length; j++) {
                    if (ob.arr3[j] == null) {
                        NoOfRoomAvailable++;
                    }
                }
                break;
            case 2:
                for (j = 0; j < ob.arr4.length; j++) {
                    if (ob.arr4[j] == null) {
                        NoOfRoomAvailable++;
                    }
                }
                break;
            case 3:
                for (j = 0; j < 10; j++) {
                    if (ob.arr1[j] == null) {
                        NoOfRoomAvailable++;
                    }
                }
                break;
            case 4:
                for (j = 0; j < ob.arr2.length; j++) {
                    if (ob.arr2[j] == null) {
                        NoOfRoomAvailable++;
                    }
                }
                break;

            default:
                System.out.println("Please Select From Menu");
                break;
        }
        System.out.println("Number Of Room Available: " + NoOfRoomAvailable);
    }

    //Billing
    static void Billing(int RoomNumber, int TypeOfRoom) {
        double amount = 0;
        String[] FoodMenu = {"Sandwich", "Pasta", "Noodles", "Coke"};
        System.out.println("\n---------");
        System.out.println(" Bill: ");
        System.out.println("---------");

        switch (TypeOfRoom) {

            case 1:
                amount += 2200;
                System.out.println("Room Cost = " + 2200);
                System.out.println("\nFood Cost = ");
                System.out.println("===============");
                System.out.println("Item   Quantity    Total Price");
                System.out.println("-------------------------");
                for (Food obb : ob.arr3[RoomNumber].foodMenu) {
                    amount += obb.cost;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format, FoodMenu[obb.itemNo - 1], obb.quantity, obb.cost);
                }
                break;
            case 2:
                amount += 1200;
                System.out.println("Room Cost =  " + 1200);
                System.out.println("\nFood Cost =  ");
                System.out.println("===============");
                System.out.println("Item   Quantity    Total Price");
                System.out.println("-------------------------");
                for (Food obb : ob.arr4[RoomNumber].foodMenu) {
                    amount += obb.cost;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format, FoodMenu[obb.itemNo - 1], obb.quantity, obb.cost);
                }
                break;
                
            case 3:
                amount += 4000;
                System.out.println("\nRoom Cost =  " + 4000);
                System.out.println("\n===============");
                System.out.println("Food Cost =  ");
                System.out.println("===============");
                System.out.println("Item   Quantity    Total Price");
                System.out.println("-------------------------");
                for (Food obb : ob.arr1[RoomNumber].foodMenu) {
                    amount += obb.cost;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format, FoodMenu[obb.itemNo - 1], obb.quantity, obb.cost);
                }

                break;
            case 4:
                amount += 3000;
                System.out.println("Room Cost = " + 3000);
                System.out.println("\nFood Cost = ");
                System.out.println("===============");
                System.out.println("Item   Quantity    Total Price");
                System.out.println("-------------------------");
                for (Food obb : ob.arr2[RoomNumber].foodMenu) {
                    amount += obb.cost;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format, FoodMenu[obb.itemNo - 1], obb.quantity, obb.cost);
                }
                break;
            default:
                System.out.println("Not valid Entered");
        }
        System.out.println("\nTotal Amount = " + amount);
    }

    //Deallocate
    static void Deallocating(int RoomNumber, int TypeOfRoom) {
        int j;
        char checkOutDecision;
        switch (TypeOfRoom) {
            case 1:
                if (ob.arr3[RoomNumber] != null) {
                    System.out.println("Number In Room: " + ob.arr3[RoomNumber].guestName);
                } else {
                    System.out.println("Room IS Empty");
                    return;
                }
                System.out.println("Do You Want To Checkout(Y/N)? ");
                checkOutDecision = sc.next().charAt(0);
                if (checkOutDecision == 'y' || checkOutDecision == 'Y') {
                    Billing(RoomNumber, TypeOfRoom);
                    ob.arr3[RoomNumber] = null;
                    System.out.println("Succesfully Deallocated");
                }
                break;

            case 2:
                if (ob.arr4[RoomNumber] != null) {
                    System.out.println("Number In Room: " + ob.arr4[RoomNumber].guestName);
                } else {
                    System.out.println("Room IS Empty");
                    return;
                }
                System.out.println("Do You Want To Checkout(Y/N)? ");
                checkOutDecision = sc.next().charAt(0);
                if (checkOutDecision == 'y' || checkOutDecision == 'Y') {
                    Billing(RoomNumber, TypeOfRoom);
                    ob.arr4[RoomNumber] = null;
                    System.out.println("Succesfully Deallocated");
                }
                break;
            case 3:
                if (ob.arr1[RoomNumber] != null) {
                    System.out.println("Number In Room: " + ob.arr1[RoomNumber].guestName);
                } else {
                    System.out.println("Room IS Empty");
                    return;
                }
                System.out.println("Do You Want To Checkout(Y/N)? ");
                checkOutDecision = sc.next().charAt(0);
                if (checkOutDecision == 'y' || checkOutDecision == 'Y') {
                    Billing(RoomNumber, TypeOfRoom);
                    ob.arr1[RoomNumber] = null;
                    System.out.println("Succesfully Deallocated");
                }
                break;

            case 4:
                if (ob.arr2[RoomNumber] != null) {
                    System.out.println("Number In Room: " + ob.arr2[RoomNumber].guestName);
                } else {
                    System.out.println("Room IS Empty");
                    return;
                }
                System.out.println("Do You Want To Checkout(Y/N)? ");
                checkOutDecision = sc.next().charAt(0);
                if (checkOutDecision == 'y' || checkOutDecision == 'Y') {
                    Billing(RoomNumber, TypeOfRoom);
                    ob.arr2[RoomNumber] = null;
                    System.out.println("Succesfully Deallocated");
                }
                break;

            default:
                System.out.println("\nPlease Select From Menu : ");
                break;
        }
    }

    //Order Food
    static void OrderFood(int RoomNumber, int TypeOfRoom) {
        int i, QuantityOFSelectedFood;
        char anotherSelected;
        try {
            System.out.println("\n***********\n   Food Menu:  \n**********\n\n1.Sandwich\tCost = 50$\n2.Pasta\t\tCost = 60$\n3.Noodles\tCost = 70$\n4.Coke\t\tCost = 30$\n");
            do {
                i = sc.nextInt();
                System.out.print("Quantity Of Selected Food: ");
                QuantityOFSelectedFood = sc.nextInt();

                switch (TypeOfRoom) {
                    case 1:
                        ob.arr3[RoomNumber].foodMenu.add(new Food(i, QuantityOFSelectedFood));
                        break;
                    case 2:
                        ob.arr4[RoomNumber].foodMenu.add(new Food(i, QuantityOFSelectedFood));
                        break;
                    case 3:
                        ob.arr1[RoomNumber].foodMenu.add(new Food(i, QuantityOFSelectedFood));
                        break;
                    case 4:
                        ob.arr2[RoomNumber].foodMenu.add(new Food(i, QuantityOFSelectedFood));
                        break;
                }
                System.out.println("Anything Else(Y/N)? ");
                anotherSelected = sc.next().charAt(0);
            } while (anotherSelected == 'y' || anotherSelected == 'Y');
        } catch (NullPointerException e) {
            System.out.println("\nRoom Not Booked");
        } catch (Exception e) {
            System.out.println("Cannot be Done");
        }
    }
}
