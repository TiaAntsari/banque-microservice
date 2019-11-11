package ma.adria.ensa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.adria.ensa.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	public Role findByRole(String roleName);

	public Role findByIdRole(int idRole);

}
