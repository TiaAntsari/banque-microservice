package ma.adria.ensa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.adria.ensa.entities.Forms;

public interface FormsRepository extends JpaRepository<Forms, Integer> {
	public Forms findByType(String type);

	public Forms findByIdForms(int idForms);
}
