package com.yuanshi.utils;

import org.bson.Document;

public class GetInfo {


    public static void getOrderInfo(Document document) {
        System.out.println("orders_id: " + document.get("orders_id"));
        System.out.println("saleDate: " + document.get("saleDate"));
        System.out.println("totalPrice: " + document.get("totalPrice"));
    }

    public static void getCustomerInfo(Document document) {
        System.out.println("customer_id: "+ document.get("customer_id"));
        System.out.println("customer_name: "+ document.get("customer_name"));
        System.out.println("customer_contacts: "+ document.get("customer_contacts"));
    }

    public static void getItemInfo(Document document) {
        System.out.println("Item id: "+ document.get("id"));
        System.out.println("quantity: "+ document.get("quantity"));
    }

    public static void getProductInfo(Document document) {
        System.out.println("product_id: " + document.get("product_id"));
        System.out.println("price: " + document.get("price"));
        System.out.println("description: " + document.get("description"));
    }

    public static void getPaymentInfo(Document document) {
        System.out.println("payment_id: " + document.get("payment_id"));
        System.out.println("paymentDate: " + document.get("paymentDate"));
    }

    public static void getDeliverDateInfo(Document document) {
        System.out.println("deliveryDate: " + document.get("deliveryDate"));
    }

    public static void getCarrierInfo(Document document) {
        System.out.println("carrier_id: "+ document.get("carrier_id"));
        System.out.println("carrier_name: "+ document.get("carrier_name"));
        System.out.println("carrier_contacts: "+ document.get("carrier_contacts"));
    }

    public static void getSupplierInfo(Document document) {
        System.out.println("supplier_id: "+ document.get("supplier_id"));
        System.out.println("supplier_name: "+ document.get("supplier_name"));
        System.out.println("supplier_contacts: "+ document.get("supplier_contacts"));
    }

    public static void getCategoryInfo(Document document) {
        System.out.println("category_id: "+ document.get("category_id"));
        System.out.println("category_description: "+ document.get("category_description"));
    }

}
