package com.cn.tissueweb;

import com.cn.entities.Product;
import com.cn.entities.ProviderProduct;
import com.cn.entities.User;
import com.cn.service.ProductService;
import com.cn.service.UserService;
import com.cn.util.Json;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TissueWebApplicationTests {

    private static List<ProviderProduct> providerProducts;
    private static Integer providerIdA = 1002;
    private static Integer levelA = 3;
    private static Integer providerIdB = 1004;
    private static Integer levelB = 1;

    static {
        providerProducts = Arrays.asList(
                new ProviderProduct(1, 1001, 1),
                new ProviderProduct(2, 1002, 2),
                new ProviderProduct(3, 1003, 3),
                new ProviderProduct(4, 1004, 5)
        );
    }

    @Test
    public void test() {
        Map<Integer, Integer> result = new HashMap<>();
        for (ProviderProduct providerProduct : providerProducts) {
            result.put(providerProduct.getProviderId(), providerProduct.getLevel());
        }
        result.put(providerIdA, levelA);
        result.put(providerIdB, levelB);
        compareByProviderProductLevel(result);
        Map<Integer,Integer> sortMap = new LinkedHashMap<>();
        System.out.println(result.entrySet().stream().sorted((o1, o2) -> o1.getValue().compareTo(o2.getValue())).limit(1).findFirst().get().getKey());
        System.out.println(result);
    }

    public Map<Integer,Integer> compareByProviderProductLevel(Map<Integer,Integer> result) {
        for(Integer parentKey : result.keySet()){
            Integer parentValue = result.get(parentKey);
            if(parentKey.intValue() == providerIdA.intValue() || parentKey.intValue() == providerIdB.intValue()){
                continue;
            }
            for(Integer childKey : result.keySet()){
                if(childKey.intValue() == parentKey.intValue()){
                    continue;
                }
                Integer childValue = result.get(childKey);
                if(parentValue.equals(childValue)){
                    childValue++;
                    result.put(parentKey,childValue);
                    if(result.containsValue(childValue)){
                        compareByProviderProductLevel(result);
                    }
                }
            }
        }
        return result;
    }

    @Test
    public void contextLoads() {
        UserService userService = new UserService();
        Map<String, Object> query = new HashMap<>();
        List<User> userList = userService.fetchList(query, null, null);
        if (CollectionUtils.isNotEmpty(userList)) {
            userList.stream().forEach(System.out::println);
        }
    }

    @Test
    public void testCreateProduct() {
        ProductService productService = new ProductService();
        Product product = new Product();
        product.setName("JavaScript");
        product.setPrice(40.0);
        product.setTitle("JavaScript精通");
        productService.saveOrUpdate(product);
    }


}
