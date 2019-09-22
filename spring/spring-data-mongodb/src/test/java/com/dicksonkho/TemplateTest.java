package com.dicksonkho;

import com.dicksonkho.config.MongoConfig;
import com.dicksonkho.domain.Shop;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Dickson Kho May 6, 2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MongoConfig.class})
public class TemplateTest {

    @Autowired
    MongoOperations mongoOperation;

    @Test
    public void testCRUDRecordWithTemplate() {
        Shop shop = new Shop("muimui", "Taming Jaya");
        mongoOperation.save(shop);
        Assert.assertNotNull(shop.getId());

        Shop insertedShop = mongoOperation.findOne(new Query(where("shopName").is("muimui")), Shop.class);
        Assert.assertEquals(shop.getId(), insertedShop.getId());

        insertedShop.setShopName("newmui");
        mongoOperation.save(insertedShop);
        Shop updatedShop = mongoOperation.findOne(new Query(where("shopName").is("newmui")), Shop.class);
        Assert.assertEquals(shop.getId(), updatedShop.getId());

        mongoOperation.dropCollection("shop");
    }
}
