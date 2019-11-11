package ma.adria.ensa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.adria.ensa.entities.Role;
import ma.adria.ensa.services.RoleService;

@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping("/roles")
	public List<Role> getAllRoles() {
		return roleService.findAllRoles();
	}

	@PostMapping("/roles")
	public Role saveRole(Role r) {
		return roleService.saveRole(r);
	}

	@DeleteMapping("/roles:{idRole}")
	public void deleteByIdRole(int idRole) {
		roleService.deleteRoleByIdRole(idRole);
	}
}
