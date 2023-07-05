package com.nasa.prueba.aspirante;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class NasaApoloApplicationTests {

	@Test
	void contextLoads() {
		NasaApoloApplication.main(new String[] {});
		assertTrue(true);
	}

}
