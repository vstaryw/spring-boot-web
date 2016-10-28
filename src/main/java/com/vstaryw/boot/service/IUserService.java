package com.vstaryw.boot.service;

import com.baomidou.framework.service.ISuperService;
import com.vstaryw.boot.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by yuw on 2016/10/25.
 */
public interface IUserService extends ISuperService<User> {
    boolean deleteAll();

    List<Map<String,Object>> findUser(Map<String,Object> map);
}
