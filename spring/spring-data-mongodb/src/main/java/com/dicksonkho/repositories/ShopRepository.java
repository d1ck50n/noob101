package com.dicksonkho.repositories;

import java.math.BigInteger;
import java.util.List;
import com.dicksonkho.domain.Shop;
import org.springframework.data.repository.Repository;

/**
 *
 * @author Dickson Kho May 4, 2015
 */
public interface ShopRepository extends Repository<Shop, BigInteger> {

    Shop save(Shop shop);

    Shop findByShopName(String shopName);

    Shop findOne(BigInteger id);

    Shop findByShopNameStartingWith(String shopName);

    List<Shop> deleteByShopName(String shopName);

}
