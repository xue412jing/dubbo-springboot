package org.apache.dubbo.spring.boot.demo.consumer.bootstrap.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.york.springboot.api.DemoService;

@RestController
@RequestMapping("consumer")
public class ConsumerController {
//	 @Reference(version = "1.0.0", url = "dubbo://127.0.0.1:12345")
	@Reference(version = "${demo.service.version}")
	    private DemoService demoService;
	@GetMapping("sayhello")
	 public String sayhello() {
		 return  demoService.sayHello("mercyblitz");
	 }
}