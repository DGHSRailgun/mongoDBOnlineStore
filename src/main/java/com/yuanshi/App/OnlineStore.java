package com.yuanshi.App;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.yuanshi.Config.MongoDBConfig;
import com.yuanshi.Printer.Printer;
import com.yuanshi.utils.GetInfo;
import org.bson.Document;


import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class OnlineStore implements Serializable {

    private MongoDBConfig mongoDBConfig = new MongoDBConfig();


    public void buildConnection() {
        mongoDBConfig.createMongoConnection("localhost:27017", "onlineStore");
    }

    public void executeInstructions() {

        String command;
        Scanner sc;

        MongoCollection collection;

        while (true) {
            Printer.printOperationInstructions();
            sc = new Scanner(System.in);
            command = sc.next();

            /* Operation 1 */
            if (Objects.equals(command, "1")) {

                /* Enter order ID */
                Printer.printEnterOrderID();
                Integer orderID = Integer.parseInt(sc.next());

                /* Get collection */
                collection = mongoDBConfig.getCollection("item_product_orders");

                /* Query operations*/
                BasicDBObject item = new BasicDBObject("orders_id", orderID);

                FindIterable<Document> documents = collection.find(item);

                /* Output result */
                for (Document document: documents) {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    GetInfo.getOrderInfo(document);
                    GetInfo.getCustomerInfo(document);
                    GetInfo.getItemInfo(document);
                    GetInfo.getProductInfo(document);
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                }

                continue;
            }

            /* Operation 2 */
            if (Objects.equals(command, "2")) {

                /* Enter order ID */
                Printer.printEnterOrderID();
                Integer orderID = Integer.parseInt(sc.next());

                /* Get collection */
                collection = mongoDBConfig.getCollection("item_product_orders");

                /* Query operations*/
                BasicDBObject item = new BasicDBObject("orders_id", orderID);

                FindIterable<Document> documents = collection.find(item);

                /* Output result */
                for (Document document: documents) {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    GetInfo.getOrderInfo(document);
                    GetInfo.getCustomerInfo(document);
                    GetInfo.getPaymentInfo(document);
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                }

                continue;
            }

            /* Operation 3 */
            if (Objects.equals(command, "3")) {

                /* Enter order ID */
                Printer.printEnterCustomerID();
                Integer customerID = Integer.parseInt(sc.next());

                /* Get collection */
                collection = mongoDBConfig.getCollection("item_product_orders");

                /* Query operations*/
                BasicDBObject item = new BasicDBObject("customer_id", customerID);

                FindIterable<Document> documents = collection.find(item);

                /* Output result */
                for (Document document: documents) {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    GetInfo.getCustomerInfo(document);
                    GetInfo.getOrderInfo(document);
                    GetInfo.getDeliverDateInfo(document);
                    GetInfo.getCarrierInfo(document);
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                }

                continue;
            }

            /* Operation 4 */
            if (Objects.equals(command, "4")) {

                /* Enter order ID */
                Printer.printEnterCustomerID();
                Integer customerID = Integer.parseInt(sc.next());

                /* Get collection */
                collection = mongoDBConfig.getCollection("item_product_orders");

                /* Query operations*/
                BasicDBObject item = new BasicDBObject("customer_id", customerID);

                FindIterable<Document> documents = collection.find(item);

                /* Output result */
                for (Document document: documents) {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    GetInfo.getCustomerInfo(document);
                    GetInfo.getOrderInfo(document);
                    GetInfo.getPaymentInfo(document);
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                }

                continue;
            }

            /* Operation 5 */
            if (Objects.equals(command, "5")) {

                /* Enter order ID */
                Printer.printEnterCustomerID();
                Integer customerID = Integer.parseInt(sc.next());

                /* Get collection */
                collection = mongoDBConfig.getCollection("item_product_orders");

                /* Query operations*/
                BasicDBObject item = new BasicDBObject("customer_id", customerID);

                FindIterable<Document> documents = collection.find(item);

                /* Output result */
                for (Document document: documents) {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    GetInfo.getCustomerInfo(document);
                    GetInfo.getOrderInfo(document);
                    GetInfo.getDeliverDateInfo(document);
                    GetInfo.getItemInfo(document);
                    GetInfo.getProductInfo(document);
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                }

                continue;
            }

            





            /* Exit operation */
            if (Objects.equals(command, "exit")) {
                Printer.endOperationInstruction();
                break;
            }




        }


        mongoDBConfig.closeMongoConnection("localhost:27017");

    }





}
