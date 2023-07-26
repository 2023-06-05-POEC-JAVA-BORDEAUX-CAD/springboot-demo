package com.example.demo;

import com.example.demo.dao.AdresseRepository;
import com.example.demo.entity.Adresse;
import com.example.demo.entity.Personne;
import com.example.demo.dao.PersonneRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	PersonneRepository personneRepository;

	@Autowired
	AdresseRepository adresseRepository;

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
			personne.setNomDeFamille("Polnaref");
			personneRepository.save(personne);
		}
	}

	@Test
	void deletePersonne(){
		personneRepository.deleteById(1);
	}

	@Test
	void findByPrenom(){
		String prenom = "Michel";
		List<Personne> lesMichels = personneRepository.findAllByPrenom(prenom);
		for(Personne michel : lesMichels){
			System.out.println(michel);
		}

	}


	@Test
	void testAdresse(){
		Adresse adresse = new Adresse(12, "rue de la Mairie", "Montpellier", "34000");
		adresseRepository.save(adresse);

		Personne steven = new Personne("Steven", "Seagale");
		steven.setAdresse(adresse);
		personneRepository.save(steven);
	}

 	@Test
	void getPersonneAvecAdresse() {
		Optional<Personne> op = personneRepository.findById(5);
		if (op.isPresent()){
			Personne steven = op.get();
			System.out.println(steven);
			System.out.println(steven.getAdresse());
		}
 	}

}
