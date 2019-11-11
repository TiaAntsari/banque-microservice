package ma.adria.ensa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.adria.ensa.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsername(String username);

	public User findByIdUser(Long idUser);
}
