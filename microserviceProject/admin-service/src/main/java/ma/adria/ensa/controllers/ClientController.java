package ma.adria.ensa.controllers;

import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.adria.ensa.entities.Client;
import ma.adria.ensa.repositories.ClientRepository;
import ma.adria.ensa.services.ClientService;

@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping("/etudiants")
	public Collection<Client> getAllEtudiants() {
		return clientService.findAll();
	}

	@PostMapping("/etudiants")
	public Client saveEtudiant(@RequestBody Client e) {
		return clientService.save(e);
	}

	// @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)

	@GetMapping("/etudiant/{id}")
	ResponseEntity<?> getGroup(@PathVariable Long id) {
		Optional<Client> client = clientRepository.findById(id);
		return client.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	// @PostMapping("/etudiants")
	// ResponseEntity<Client> createEtudiant(@Valid @RequestBody Client
	// etudiant) throws URISyntaxException {
	// // log.info("Request to create group: {}", group);
	// Client result = clientRepository.save(etudiant);
	// return ResponseEntity.created(new URI("/etudiants" +
	// result.getIdEtudiant())).body(result);
	// }

	@PutMapping("/etudiant/{id}")
	ResponseEntity<Client> updateEtudiant(@Valid @RequestBody Client client) {
		// log.info("Request to update group: {}", group);
		Client result = clientRepository.save(client);
		return ResponseEntity.ok().body(result);
	}

	@DeleteMapping("/etudiant/{id}")
	public ResponseEntity<?> deleteEtudiant(@PathVariable Long id) {
		// log.info("Request to delete group: {}", id);
		clientRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
