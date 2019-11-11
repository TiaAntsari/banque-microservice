package ma.adria.ensa.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.adria.ensa.entities.UsersRoles;
import ma.adria.ensa.services.UsersRolesService;

@RestController
public class UsersRolesController {

	private UsersRolesService usersRolesService;

	@PostMapping("/usersRoles")
	public ResponseEntity<?> addRoleToUser(@RequestBody UsersRoles usersRoles) {
		System.out.println("2222222222***************************###################" + usersRoles.getUsername()
				+ " #####**************************########### " + usersRoles.getRole()
				+ " ##########***********************");

		// usersRolesService.addRoleToUser(usersRoles.getUsername(),
		// usersRoles.getRole());
		usersRolesService.addRoleToUser("zeefzfze", "PROF");

		return ResponseEntity.ok().build();
	}
}
