package com.ahmetyuzun.demo.log;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
/**
 * Bu Sinifimizda hangi endpointe istek geldiginde tutulmasını ayarlarız.
 */
@Configuration
public class WebMvcConfigurer implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer {


    private final RequestInterceptor requestInterceptor;


    public WebMvcConfigurer(RequestInterceptor requestInterceptor) {
        this.requestInterceptor = requestInterceptor;
    }

    /**
     *
     * @param registry gelen istegin bilgilerini icerir.
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestInterceptor)
                .addPathPatterns("/character/**")
                .addPathPatterns("/episode/**");
    }

}
