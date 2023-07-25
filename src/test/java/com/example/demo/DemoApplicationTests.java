package com.example.demo;

import com.example.demo.business.Personne;
import com.example.demo.dao.PersonneRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	PersonneRepository personneRepository;

	@Test
	void savePersonne() {
		Personne alain = new Personne("Alain", "Delon");

		personneRepository.save(alain);

	}

}
