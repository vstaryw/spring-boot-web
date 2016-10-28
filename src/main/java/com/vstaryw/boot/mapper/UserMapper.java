package com.vstaryw.boot.mapper;

/**
 * Created by yuw on 2016/10/25.
 */

import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.vstaryw.boot.entity.User;

import java.util.List;
import java.util.Map;

/**
 *
 * User 表数据库控制层接口
 *
 */
public interface UserMapper extends AutoMapper<User> {

    /**
     * 自定义注入方法
     */
    int deleteAll();

    List<Map<String,Object>> findUser(Map<String,Object> map);

}
