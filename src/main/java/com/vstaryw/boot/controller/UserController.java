package com.vstaryw.boot.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vstaryw.boot.entity.User;
import com.vstaryw.boot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuw on 2016/10/18.
 */
@RestController
@RequestMapping("/user")
public class UserController {




    @Autowired
    private IUserService userService;

    /**
     * 增删改查 CRUD
     */
    @RequestMapping("/test1")
    public User test1() {
        System.err.println("删除一条数据：" + userService.deleteById(1L));
        System.err.println("deleteAll：" + userService.deleteAll());
        System.err.println("插入一条数据：" + userService.insertSelective(new User(1L, "张三", 17, 1)));
        User user = new User("张三", 17, 1);
        boolean result = userService.insert(user);
        //自动回写的ID
        Long id = user.getId();
        System.err.println("插入一条数据：" + result + ", 插入信息：" + user.toString());
        System.err.println("查询：" + userService.selectById(id).toString());
        System.err.println("更新一条数据：" + userService.updateSelectiveById(new User(1L, "三毛", 18, 2)));
        return userService.selectById(1L);
    }

    /**
     * 插入 OR 修改
     */
    @RequestMapping("/test2")
    public User test2() {
        userService.insertOrUpdateSelective(new User(1L, "王五", 19, 3));
        return userService.selectById(1L);
    }

    /**
     * 分页 PAGE
     * 返回total
     */
    @RequestMapping("/test3")
    public Page<User> test3() {
        return userService.selectPage(new Page<User>(0,2), null);
    }


    /**
     * 分页不需要返回总数
     * @return
     */
    @RequestMapping("/test4")
    public Page<User> test4(){
        Page<User> userPage = new Page<>(0, 1);
        userPage.setSearchCount(false);
        return userService.selectPage(userPage,null);
    }

    @RequestMapping("/test5")
    public List<User> test5(){
        EntityWrapper<User> userEntityWrapper = new EntityWrapper<>(new User(),"name,age");
        userEntityWrapper.like("age","2");
        System.out.println(userEntityWrapper.getSqlSegment());
        return userService.selectList(userEntityWrapper);
    }

    @RequestMapping("/test6")
    public List<Map<String,Object>> test6(){
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("age",12);
        return userService.findUser(paramMap);
    }

    @RequestMapping("/test7")
    public String test7(){
        EntityWrapper<User> userEntityWrapper = new EntityWrapper<>(new User(),"name,age");
        userEntityWrapper.where("name={0}", "'zhangsan'").and("id=1")
                .orNew("status={0}", "0").or("status=1")
                .notLike("nlike", "notvalue")
                .andNew("new=xx").like("hhh", "ddd")
                .andNew("pwd=11").isNotNull("n1,n2").isNull("n3")
                .groupBy("x1").groupBy("x2,x3")
                .having("x1=11").having("x3=433")
                .orderBy("dd").orderBy("d1,d2");
        return userEntityWrapper.getSqlSegment();
    }

}
