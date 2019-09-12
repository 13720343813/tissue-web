package com.cn.service;

import com.cn.entities.Product;

import java.util.List;
import java.util.Map;

public class ProductService extends RestBasicService {
    private final static String FETCH_LIST = "/product/fetchList";
    private final static String SAVE_OR_UPDATE = "/product/saveOrUpdate";

    public ProductService() {
        setServiceAddress("http://127.0.0.1:8081");
        setServiceToken("tissue");
    }

    public List<Product> fetchList(Map<String, Object> query, Map<String, Object> sort, Map<String, Object> pagination) {
        setServiceEntry(FETCH_LIST);
        setServiceRequestQuery(query, sort, pagination);
        return (List<Product>) requestList(Product.class);
    }

    public Boolean saveOrUpdate(Product product) {
        setServiceEntry(SAVE_OR_UPDATE);
        setServiceRequestCreate(product);
        Object isSuccess = request();
        return checkSuccess() && null == isSuccess ? false : (Boolean) isSuccess;
    }
}
