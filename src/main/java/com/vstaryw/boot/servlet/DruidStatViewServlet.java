package com.vstaryw.boot.servlet;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * Created by yuw on 2016/10/18.
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/druid/*",initParams = {
        @WebInitParam(name="loginUsername",value = "root"),
        @WebInitParam(name="loginPassword",value = "root")
    }
)
public class DruidStatViewServlet extends StatViewServlet {
}
