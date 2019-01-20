package com.yanfu;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@ComponentScan(basePackages = "com.yanfu")
@MapperScan("com.yanfu.dao")
@EnableSwagger2
public class DroolsSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroolsSpringApplication.class, args);
	}
	@Bean
	public KieContainer kieContainer() {
		return KieServices.Factory.get().getKieClasspathContainer();
	}

}

