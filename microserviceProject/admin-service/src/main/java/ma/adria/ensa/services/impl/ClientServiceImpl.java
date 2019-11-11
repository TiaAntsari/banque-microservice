package ma.adria.ensa.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.adria.ensa.entities.Client;
import ma.adria.ensa.repositories.ClientRepository;
import ma.adria.ensa.services.ClientService;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client save(Client e) {
		return clientRepository.save(e);
	}

	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	@Override
	public void deleteEtudiantByIdEtudiant(long idEtudiant) {
		Client client = clientRepository.findByIdEtudiant(idEtudiant);
		clientRepository.delete(client);

	}
}
