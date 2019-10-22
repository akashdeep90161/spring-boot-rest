package com.akash.springboot.demo.config;

import com.akash.springboot.demo.filter.MyNewFilter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilterConfig {

    @Bean
    public FilterRegistrationBean<MyNewFilter> RegistrationBean() {
         FilterRegistrationBean<MyNewFilter> registrationBean=new FilterRegistrationBean<>();
         registrationBean.setFilter(new MyNewFilter());
         registrationBean.addUrlPatterns("/customers/*");
        return registrationBean;
    }
}
