package ma.adria.ensa.services.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.adria.ensa.entities.Role;
import ma.adria.ensa.entities.User;
import ma.adria.ensa.repositories.RoleRepository;
import ma.adria.ensa.repositories.UserRepository;
import ma.adria.ensa.services.UsersRolesService;

@Service
@Transactional
public class UsersRolesServiceImpl implements UsersRolesService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void addRoleToUser(String username, String roleName) {
		System.out.println("11111111111111111");
		Role role = roleRepository.findByRole(roleName);
		System.out.println("22222222222");
		User user = userRepository.findByUsername(username);
		System.out.println("3333333333");
		user.getRoles().add(role);
		System.out.println("444444444");
	}

	@Override
	public Collection<Role> findRoleByUsername(String username) {
		User user = userRepository.findByUsername(username);
		Collection<Role> roles = user.getRoles();
		return roles;
	}

	@Override
	public void removeRoleToUser(String username, String roleName) {
		Role role = roleRepository.findByRole(roleName);
		User user = userRepository.findByUsername(username);
		user.getRoles().remove(role);
	}

}
