package com.yuanshi.Entity;

import lombok.Data;

@Data
public class Item {
    private Integer id;
    private Integer quantity;
    private Integer product_id;
    private Float price;
    private String description;
    private Integer category_id;
    private String category_description;
    private Integer supplier_id;
    private String supplier_name;
    private String supplier_contacts;
    private Integer orders_id;
    private Float totalPrice;
    private String date;
    private String saleDate;
    private Integer customer_id;
    private String customer_name;
    private String customer_contacts;
    private Integer payment_id;
    private String paymentDate;
    private Integer carrier_id;
    private String carrier_name;
    private String carrier_contacts;
    private String datetime;

}
