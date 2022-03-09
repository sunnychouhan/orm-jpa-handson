package com.jpa.handson;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class OrmJpaHandsonApplicationTests {

	@Autowired
	WebApplicationContext webApplicationContext;

	@Test
	void contextLoads() {
	}

}
