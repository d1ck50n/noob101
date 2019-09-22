package com.dicksonkho;

import com.dicksonkho.config.MongoWebConfig;
import com.dicksonkho.domain.Shop;
import com.dicksonkho.repositories.ShopRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Dickson Kho May 9, 2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MongoWebConfig.class})
@WebAppConfiguration
public class SpringDataWebSupportTests {

    private MockMvc mockMvc;
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    protected WebApplicationContext webApplicationContext;

    @Autowired
    private ShopRepository repository;

    @Test
    public void getShopWithWebSupport() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        Shop shop = new Shop("muimui", "Taming Jaya");
        repository.save(shop);

        MvcResult result = mockMvc.perform(get("/shop/" + shop.getId())).andReturn();
        Shop shopResponse = mapper.readValue(result.getResponse().getContentAsString(), Shop.class);
        Assert.assertEquals("Taming Jaya", shopResponse.getAddress());

        repository.deleteByShopName("muimui");
    }
}
