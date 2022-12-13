package com.yuanshi.Printer;

import java.io.Serializable;

public class Printer implements Serializable {

    public static void printOperationInstructions() {
        System.out.println("*******************************************************************************************");
        System.out.println("*******************************************************************************************");
        System.out.println("Please enter the operation index(The operation indexes corresponds to the onlinestore-queries.info): ");
        System.out.println("1) Operation 1");
        System.out.println("2) Operation 2");
        System.out.println("3) Operation 3");
        System.out.println("4) Operation 4");
        System.out.println("5) Operation 5");
        System.out.println("6) Operation 6");
        System.out.println("7) Operation 7");
        System.out.println("8) Operation 8");
        System.out.println("9) Operation 9");
        System.out.println("10) Operation 10");
        System.out.println("Enter exit to close the database connection and finish the operations!");
        System.out.println("*******************************************************************************************");
        System.out.println("*******************************************************************************************");
    }

    public static void printEnterOrderID() {
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("Please enter the order id: ");
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////");
    }

    public static void printEnterCustomerID() {
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("Please enter the customer id: ");
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////");
    }

    public static void endOperationInstruction() {
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("Database disconnected! Exit the system!");
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////");
    }



}
