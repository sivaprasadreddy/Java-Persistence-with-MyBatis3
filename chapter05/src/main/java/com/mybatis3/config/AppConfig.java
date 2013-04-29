package com.mybatis3.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Siva
 *
 */
@Configuration
@MapperScan("com.mybatis3.mappers")
public class AppConfig
{

}
