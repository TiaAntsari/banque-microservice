package ma.adria.ensa.services;

import java.util.Collection;

import ma.adria.ensa.entities.Role;

public interface UsersRolesService {
	public void addRoleToUser(String username, String roleName);

	public Collection<Role> findRoleByUsername(String username);

	public void removeRoleToUser(String username, String roleName);

}
