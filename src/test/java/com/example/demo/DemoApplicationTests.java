package com.example.demo;

import com.example.demo.business.Personne;
import com.example.demo.dao.PersonneRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	PersonneRepository personneRepository;

	@Test
	void savePersonne() {
		Personne alain = new Personne("Alain", "Delon");

		personneRepository.save(alain);
		System.out.println(personneRepository.getClass());

	}

	@Test
	void findAllPersonne() {
		List<Personne> personnes = personneRepository.findAll();

		for (Personne p : personnes){
			System.out.println(p);
		}
	}

	@Test
	void findOnePersonne(){
		Integer id = 2;

		Optional<Personne> optional = personneRepository.findById(id);
		if(optional.isPresent()){
			Personne personne = optional.get();
			System.out.println(personne);
		}
		else {
			System.out.println("id non trouvé");
		}
	}

	@Test
	void updatePersonne(){
		Optional<Personne> optional = personneRepository.findById(2);
		if(optional.isPresent()) {
			Personne personne = optional.get();
			personne.setPrenom("Michel");
			personne.setNom("Polnaref");
			personneRepository.save(personne);
		}
	}
}
