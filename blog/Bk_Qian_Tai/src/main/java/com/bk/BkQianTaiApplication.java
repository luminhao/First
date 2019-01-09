package com.bk;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.github.pagehelper.PageHelper;

@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.bk.dao")
public class BkQianTaiApplication /*extends SpringBootServletInitializer*/{

	public static void main(String[] args) {
		SpringApplication.run(BkQianTaiApplication.class, args);
	}

/*	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(this.getClass());
	}*/
	
	/**
	 * 配置mybatis的分页插件pageHelper
	 * @return
	 */
/*	@Bean
	public PageHelper pageHelper(){
	          PageHelper pageHelper = new PageHelper();
	          Properties properties = new Properties();
	         properties.setProperty("offsetAsPageNum","true");
	          properties.setProperty("rowBoundsWithCount","true");
	          properties.setProperty("reasonable","true");
	          properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
	         pageHelper.setProperties(properties);
	         return pageHelper;
     }*/
/*	  @Bean
	    public HttpMessageConverters fastJsonConfigure(){
	        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
	        FastJsonConfig fastJsonConfig = new FastJsonConfig();
	        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
	        //日期格式化
	        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
	        converter.setFastJsonConfig(fastJsonConfig);
	        return new HttpMessageConverters(converter);
	    }*/
}
