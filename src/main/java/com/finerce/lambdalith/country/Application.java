package com.finerce.lambdalith.country;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.finerce.lambdalith.country.controller.CountryController;

@SpringBootApplication
//We use direct @Import instead of @ComponentScan to speed up cold starts
//@ComponentScan("com.finerce")
//@Import({CountryController.class})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
