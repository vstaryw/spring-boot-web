package com.vstaryw.boot.service.impl;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.vstaryw.boot.entity.User;
import com.vstaryw.boot.mapper.UserMapper;
import com.vstaryw.boot.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by yuw on 2016/10/25.
 *  User 表数据服务层接口实现类
 */
@Service
public class UserService extends SuperServiceImpl<UserMapper,User> implements IUserService {

    @Override
    public boolean deleteAll() {
        return retBool(baseMapper.deleteAll());
    }

    @Override
    public List<Map<String, Object>> findUser(Map<String, Object> map) {
        return baseMapper.findUser(map);
    }
}
