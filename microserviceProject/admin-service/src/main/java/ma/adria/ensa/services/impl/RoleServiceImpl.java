package ma.adria.ensa.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.adria.ensa.entities.Role;
import ma.adria.ensa.repositories.RoleRepository;
import ma.adria.ensa.services.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role saveRole(Role r) {
		return roleRepository.save(r);
	}

	@Override
	public void deleteRoleByRoleName(String roleName) {
		Role role = roleRepository.findByRole(roleName);
		roleRepository.delete(role);
	}

	@Override
	public void deleteRoleByIdRole(int idRole) {
		Role role = roleRepository.findByIdRole(idRole);
		roleRepository.delete(role);
	}

	@Override
	public List<Role> findAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Role findRoleByRoleName(String roleName) {
		return roleRepository.findByRole(roleName);
	}

}
