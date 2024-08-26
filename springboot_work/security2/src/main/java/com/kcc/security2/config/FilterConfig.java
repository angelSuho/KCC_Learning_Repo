package com.kcc.security2.config;

import com.kcc.security2.filter.MyFilter02;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

//    @Bean
    public FilterRegistrationBean<MyFilter02> filter02() {
        FilterRegistrationBean<MyFilter02> bean =
                new FilterRegistrationBean<>(new MyFilter02());
        bean.addUrlPatterns("/*");
        bean.setOrder(0);
        return bean;
    }
}
