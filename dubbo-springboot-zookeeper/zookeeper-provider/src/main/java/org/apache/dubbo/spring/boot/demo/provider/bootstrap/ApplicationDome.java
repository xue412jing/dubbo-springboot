package org.apache.dubbo.spring.boot.demo.provider.bootstrap;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.spring.boot.demo.provider.service.DefaultDemoService;

import com.york.springboot.api.DemoService;

public class ApplicationDome {
public static void main(String[] args) {
	DemoService demoService = new DefaultDemoService();
	ApplicationConfig application = new ApplicationConfig();
	application.setName("dubbo-registry-zookeeper-provider-sample");
	// 连接注册中心配置
	RegistryConfig registry = new RegistryConfig();
	registry.setAddress("zookeeper://127.0.0.1:2181");
	// 服务提供者协议配置
	ProtocolConfig protocol = new ProtocolConfig();
	protocol.setName("dubbo");
	protocol.setPort(-1);
	protocol.setThreads(200);
	
	ServiceConfig<DemoService> service = new ServiceConfig<DemoService>(); // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
	service.setApplication(application);
	service.setRegistry(registry); // 多个注册中心可以用setRegistries()
	service.setProtocol(protocol); // 多个协议可以用setProtocols()
	service.setInterface(DemoService.class);
	service.setRef(demoService);
	service.setVersion("1.0.0");
	 
	// 暴露及注册服务
	service.export();
}
}
