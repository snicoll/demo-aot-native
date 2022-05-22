package com.example.demo;

import com.example.demo.hello.HelloService;
import com.example.demo.hello.SimpleHelloService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
class DemoConfiguration {

	@Bean
	HelloService helloService() {
		return new SimpleHelloService();
	}

}
