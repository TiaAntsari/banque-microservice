package ma.adria.ensa.services;

import java.util.List;

import ma.adria.ensa.entities.Role;

public interface RoleService {
	public Role saveRole(Role r);

	public void deleteRoleByRoleName(String roleName);

	public void deleteRoleByIdRole(int idRole);

	public List<Role> findAllRoles();

	public Role findRoleByRoleName(String roleName);
}
