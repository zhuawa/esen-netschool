package com.esen.netschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.esen",exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class NetschoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetschoolApplication.class, args);
	}
}
