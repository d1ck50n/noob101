package com.dicksonkho;

import java.util.List;
import com.dicksonkho.config.MongoConfig;
import com.dicksonkho.domain.Shop;
import com.dicksonkho.repositories.ShopRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Dickson Kho May 4, 2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MongoConfig.class})
public class RepositoryTest {

    @Autowired
    private ShopRepository repository;

    @Test
    public void testCRUDRecordWithRepository() {
        Shop shop = new Shop("muimui", "Taming Jaya");
        repository.save(shop);
        Assert.assertNotNull(shop.getId());

        Shop shopByShopName = repository.findByShopName("muimui");
        Assert.assertEquals(shop.getId(), shopByShopName.getId());

        Shop shopByNameStartWith = repository.findByShopNameStartingWith("mui");
        Assert.assertEquals(shop.getId(), shopByNameStartWith.getId());

        List<Shop> deletedShopList = repository.deleteByShopName("muimui");
        Assert.assertEquals(1, deletedShopList.size()); // 1 record deleted

        Shop recheckTheShop = repository.findByShopName("muimui");
        Assert.assertNull(recheckTheShop);

    }
}
