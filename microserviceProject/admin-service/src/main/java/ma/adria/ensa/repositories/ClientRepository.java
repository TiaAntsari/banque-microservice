package ma.adria.ensa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.adria.ensa.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	public Client findByIdEtudiant(Long idEtudiant);
}
