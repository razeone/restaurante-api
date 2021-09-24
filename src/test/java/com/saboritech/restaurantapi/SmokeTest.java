package com.saboritech.restaurantapi;

import static org.assertj.core.api.Assertions.assertThat;

import com.saboritech.restaurantapi.controllers.PlatilloController;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private PlatilloController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
