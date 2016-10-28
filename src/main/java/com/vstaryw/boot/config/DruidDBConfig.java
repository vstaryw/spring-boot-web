package com.vstaryw.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.vstaryw.boot.properties.DBConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by yuw on 2016/10/25.
 */
@Configuration
public class DruidDBConfig {

    private Logger logger = LoggerFactory.getLogger(DruidDBConfig.class);

    @Autowired
    public DBConfig dBConfig;

    @Primary //@Primary表示这里定义的DataSource将覆盖其他来源的DataSource
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setUrl(dBConfig.getUrl());
        dataSource.setUsername(dBConfig.getUsername());
        dataSource.setPassword(dBConfig.getPassword());
        dataSource.setDriverClassName(dBConfig.getDriverClassName());

        //configuration
        dataSource.setInitialSize(dBConfig.getInitialSize());
        dataSource.setMinIdle(dBConfig.getMinIdle());
        dataSource.setMaxActive(dBConfig.getMaxActive());
        dataSource.setMaxWait(dBConfig.getMaxWait());
        dataSource.setTimeBetweenConnectErrorMillis(dBConfig.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(dBConfig.getTimeBetweenEvictionRunsMillis());
        dataSource.setValidationQuery(dBConfig.getValidationQuery());
        dataSource.setTestWhileIdle(dBConfig.isTestWhileIdle());
        dataSource.setTestOnBorrow(dBConfig.isTestOnBorrow());
        dataSource.setTestOnReturn(dBConfig.isTestOnReturn());
        dataSource.setPoolPreparedStatements(dBConfig.isPoolPreparedStatements());
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(dBConfig.getMaxPoolPreparedStatementPerConnectionSize());

        try{
            dataSource.setFilters(dBConfig.getFilters());
        }catch (SQLException e){
            logger.error("druid configuration initialization filter",e);
        }
        dataSource.setConnectionProperties(dBConfig.getConnectionProperties());
        return dataSource;
    }

}
