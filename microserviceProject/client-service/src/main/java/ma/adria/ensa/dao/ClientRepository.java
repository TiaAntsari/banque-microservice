package ma.adria.ensa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.adria.ensa.entities.Client;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long> {

}
