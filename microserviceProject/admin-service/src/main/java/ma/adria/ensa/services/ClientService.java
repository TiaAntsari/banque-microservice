package ma.adria.ensa.services;

import java.util.List;

import ma.adria.ensa.entities.Client;

public interface ClientService {
	public Client save(Client e);

	public List<Client> findAll();

	public void deleteEtudiantByIdEtudiant(long idEtudiant);
}
