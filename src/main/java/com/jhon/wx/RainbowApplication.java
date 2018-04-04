package com.jhon.wx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jhon.wx.mapper")
public class RainbowApplication {

	public static void main(String[] args) {
		SpringApplication.run(RainbowApplication.class, args);
	}

}
