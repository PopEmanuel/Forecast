package com.pop.forecast;

import com.pop.forecast.controller.ForecastController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableFeignClients("com.pop.forecast.client")
@ImportAutoConfiguration({FeignAutoConfiguration.class})
@RestController
public class ForecastApplication {

	public static void main(String[] args) {
			SpringApplication.run(ForecastApplication.class, args);
	}
	@GetMapping(path = "/hello")
	public ResponseEntity<?> hello() {
		return ResponseEntity.ok().build();
	}
}
