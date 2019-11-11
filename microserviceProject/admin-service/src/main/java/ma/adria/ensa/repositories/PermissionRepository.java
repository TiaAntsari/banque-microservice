package ma.adria.ensa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.adria.ensa.entities.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {
	public Permission findByOperation(String operation);

	public Permission findByIdPermission(int idPermission);
}
