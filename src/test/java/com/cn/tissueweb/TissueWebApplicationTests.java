package com.cn.tissueweb;

import com.cn.entities.Product;
import com.cn.entities.User;
import com.cn.service.ProductService;
import com.cn.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TissueWebApplicationTests {

    @Test
    public void contextLoads() {
        UserService userService = new UserService();
        Map<String,Object> query = new HashMap<>();
        List<User> userList = userService.fetchList(query,null,null);
        if(CollectionUtils.isNotEmpty(userList)){
            userList.stream().forEach(System.out::println);
        }
    }

    @Test
    public void testCreateProduct(){
        ProductService productService = new ProductService();
        Product product = new Product();
        product.setName("JavaScript");
        product.setPrice(40.0);
        product.setTitle("JavaScript精通");
        productService.saveOrUpdate(product);
    }

}
