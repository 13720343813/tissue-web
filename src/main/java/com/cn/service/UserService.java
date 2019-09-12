package com.cn.service;

import com.cn.entities.User;

import java.util.List;
import java.util.Map;

public class UserService extends RestBasicService {

    private final static String FETCH_LIST = "/user/fetchList";

    public UserService() {
        setServiceAddress("http://127.0.0.1:8081");
        setServiceToken("tissue");
    }


    public List<User> fetchList(Map<String, Object> query, Map<String, Object> sort, Map<String, Object> pagination) {
        setServiceEntry(FETCH_LIST);
        setServiceRequestQuery(query, sort, pagination);
        List<User> userList = (List<User>) requestList(User.class);
        return userList;
    }

}
