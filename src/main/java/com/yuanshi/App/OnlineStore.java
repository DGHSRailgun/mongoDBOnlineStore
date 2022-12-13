package com.yuanshi.App;

import com.mongodb.BasicDBObject;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.yuanshi.Config.MongoDBConfig;
import com.yuanshi.Printer.Printer;
import com.yuanshi.utils.GetInfo;
import org.bson.BSONObject;
import org.bson.Document;


import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

public class OnlineStore implements Serializable {

    private MongoDBConfig mongoDBConfig = new MongoDBConfig();


    public void buildConnection() {
        mongoDBConfig.createMongoConnection("localhost:27017", "onlineStoreTest");
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

            /* Operation 6 */
            if (Objects.equals(command, "6")) {

                /* Enter order ID */
                Printer.printEnterProductID();
                Integer productID = Integer.parseInt(sc.next());

                /* Get collection */
                collection = mongoDBConfig.getCollection("item_product_orders");

                /* Query operations*/
                BasicDBObject item = new BasicDBObject("product_id", productID);

                FindIterable<Document> documents = collection.find(item);

                /* Output result */
                for (Document document: documents) {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    GetInfo.getProductInfo(document);
                    GetInfo.getOrderInfo(document);
                    GetInfo.getItemInfo(document);
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                }

                continue;
            }

            /* Operation 7 */
            if (Objects.equals(command, "7")) {

                /* Enter order ID */
                Printer.printEnterSupplierID();
                Integer supplierID = Integer.parseInt(sc.next());

                /* Get collection */
                collection = mongoDBConfig.getCollection("item_product_orders");

                /* Query operations*/
                BasicDBObject item = new BasicDBObject("supplier_id", supplierID);

                FindIterable<Document> documents = collection.find(item);

                /* Output result */
                for (Document document: documents) {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    GetInfo.getSupplierInfo(document);
                    GetInfo.getProductInfo(document);
                    GetInfo.getCategoryInfo(document);
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                }

                continue;
            }

            /* Operation 8 */
            if (Objects.equals(command, "8")) {
                Printer.printEnterPlaceAnOrder();

                /* To record the order information */
                Map<String, Object> ordersMap = new HashMap<>();
                Map<String, Object> map = new HashMap<>();
                List<Map> list = new ArrayList<>();

                /* Get collections */
                MongoCollection collectionItem = mongoDBConfig.getCollection("item_product_orders");
                MongoCollection collectionProduct = mongoDBConfig.getCollection("product_category_supplier");
                MongoCollection collectionOrders = mongoDBConfig.getCollection("orders_customer_payment_delivery_carrier");

                /* Get the largest orders id and generate self-increasing id(add one) for new item */
                AggregateIterable<Document> maxOrdersID = collectionOrders.aggregate(Arrays.asList(
                        new Document("$group", new Document("_id", null).append("lastItem", new Document("$last", "$$ROOT"))),
                        new Document("$project", new Document("id","$lastItem.id"))
                ));


                Integer currentMaxOrdersID = null;
                Integer newMaxOrdersID = null;

                try {
                    for (Document dbObj: maxOrdersID) {
                        currentMaxOrdersID = Integer.parseInt(dbObj.get("id").toString());

                    }

                    if (Objects.equals(currentMaxOrdersID, null)) {
                        throw new NullPointerException();
                    }
                    newMaxOrdersID = currentMaxOrdersID + 1; //Self-increasing

                }catch (RuntimeException e) {
                    e.printStackTrace();
                }

                System.out.println(newMaxOrdersID);

                /* Inserting One Order*/

                ordersMap.put("id", newMaxOrdersID);
                Printer.printEnterTotalPrice(); //Enter total price
                Float totalPrice = Float.parseFloat(sc.next());
                sc.nextLine();
                ordersMap.put("totalPrice", totalPrice);

                Calendar calendar = Calendar.getInstance();  //Generate date automatically
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = formatter.format(calendar.getTime());
                ordersMap.put("date",date);

                Printer.printEnterSaleDate(); //Enter sale date
                String saleDate = sc.nextLine();
                ordersMap.put("saleDate", saleDate);

                Printer.printCustomerID(); //Enter customer id
                Integer customer_id = Integer.parseInt(sc.next());
                sc.nextLine();
                ordersMap.put("customer_id", customer_id);

                Printer.printCustomerName(); //Enter customer name
                String customer_name = sc.nextLine();
                ordersMap.put("customer_name", customer_name);

                Printer.printCustomerContacts(); //Enter customer contacts
                String customer_contacts = sc.nextLine();
                ordersMap.put("customer_contacts", customer_contacts);

                Printer.printPaymentID(); //Enter payment id
                Integer payment_id = Integer.parseInt(sc.next());
                sc.nextLine();
                ordersMap.put("payment_id", payment_id);

                Printer.printPaymentDate(); //Enter payment date
                String paymentDate = sc.nextLine();
                ordersMap.put("paymentDate", paymentDate);

                Printer.printCarrierID(); //Enter customer id
                Integer carrier_id = Integer.parseInt(sc.next());
                sc.nextLine();
                ordersMap.put("carrier_id", carrier_id);

                Printer.printCarrierName(); //Enter customer name
                String carrier_name = sc.nextLine();
                ordersMap.put("carrier_name", carrier_name);

                Printer.printCarrierContacts(); //Enter customer contacts
                String carrier_contacts = sc.nextLine();
                ordersMap.put("carrier_contacts", carrier_contacts);

                Printer.printDeliveryDate(); //Enter the delivery date
                String deliveryDate = sc.nextLine();
                ordersMap.put("deliveryDate", deliveryDate);

                /* Creating the order (update the order collection) */
                try {
                    collectionOrders.insertOne(new Document(ordersMap));
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }

                /* End creating (inserting new order and creating items)*/

                /* Creating items (add products) */
                /* Get the largest item id and generate self-increasing id(add one) for new item */
                AggregateIterable<Document> maxItemID = collectionItem.aggregate(Arrays.asList(
                        new Document("$group", new Document("_id", null).append("lastItem", new Document("$last", "$$ROOT"))),
                        new Document("$project", new Document("id","$lastItem.id"))
                ));
                Integer currentMaxItemID = null;
                Integer newMaxItemID = null;
                try {
                    for (Document dbObj: maxItemID) {
                        currentMaxItemID = Integer.parseInt(dbObj.get("id").toString());
                    }

                    if (Objects.equals(currentMaxItemID, null)) {
                        throw new NullPointerException();
                    }
                    newMaxItemID = currentMaxItemID + 1; //Self-increasing and avoiding entering the same item ID
                }catch (RuntimeException e) {
                    e.printStackTrace();
                }



                /* One order can have many products (creating multiple items) */
                while (true) {

                    /* put the new item id into map */
                    map.put("id", newMaxItemID);

                    /* Enter quantity*/
                    Printer.printEnterQuantity();
                    Integer quantity = Integer.parseInt(sc.next());
                    map.put("quantity", quantity);

                    /* Select a product */
                    Printer.printSelectProduct();
                    Integer productID = Integer.parseInt(sc.next());
                    BasicDBObject product = new BasicDBObject("product_id", productID);

                    /* Get the product information and put them into the map*/
                    FindIterable<Document> documents = collectionProduct.find(product);
                    for (Document document: documents) {
                        map.put("product_id", document.get("id"));
                        map.put("price", document.get("price"));
                        map.put("description", document.get("description"));
                        map.put("category_id", document.get("category_id"));
                        map.put("category_description", document.get("category_description"));
                        map.put("supplier_id", document.get("supplier_id"));
                        map.put("supplier_name", document.get("supplier_name"));
                        map.put("supplier_contacts", document.get("supplier_contacts"));
                    }



                    /* Put item id into map*/
                    map.put("id", newMaxItemID);

                    /*  */



                }






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
