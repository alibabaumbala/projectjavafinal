package com.example.demo.cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class CloudinaryConfig {
    @Bean
    public CommonsMultipartResolver multipartResolver()
    {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }

    @Bean
    public Cloudinary cloudinary()
    {
        Cloudinary c = new Cloudinary(ObjectUtils.asMap(
                "cloud_name","dnqk5fjla",
                "api_key","149557243487116",
                "api_secret","n9moDShH0IrWNmotU4l5EWdhSuI",
                "secure",true));
        return c;
    }
}
