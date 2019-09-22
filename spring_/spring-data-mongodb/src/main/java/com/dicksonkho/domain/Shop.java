package com.dicksonkho.domain;

import java.math.BigInteger;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Dickson Kho
 */
@Document
public class Shop {

    @Id
    private BigInteger id;
    private String shopName;
    private String address;

    public Shop() {
    }

    public Shop(String shopName, String address) {
        this.shopName = shopName;
        this.address = address;
    }

    public BigInteger getId() {
        return id;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
