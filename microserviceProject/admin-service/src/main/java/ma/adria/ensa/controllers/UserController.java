package ma.adria.ensa.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.adria.ensa.entities.User;
import ma.adria.ensa.services.UserService;
import ma.adria.ensa.services.UsersRolesService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UsersRolesService usersRolesService;

	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		user.setActivated(true);
		// usersRolesService.addRoleToUser(user.getUsername(), "PROF");
		return userService.saveUser(user);
	}

	@GetMapping(value = "/users")
	public List<User> getAllUsers(Model model) {
		return userService.findAllUsers();
	}

	@GetMapping(value = "/users/{idUser}")
	public User getUserById(@PathVariable long idUser) {
		// System.out.println("******************************" + idUser +
		// "**************************************");
		return userService.findUserById(idUser);
	}

	@PutMapping(value = "/users/{idUser}")
	public User updateUser(@PathVariable long idUser, @RequestBody User user) {
		User u = userService.findUserById(idUser);
		u.setUsername(user.getUsername());
		u.setPassword(user.getPassword());
		return userService.saveUser(u);
	}

	@DeleteMapping(value = "/users/{idUser}")
	public void deleteByIdUser(@PathVariable long idUser) {
		userService.deleteUserById(idUser);
	}

	// @Secured(value = { "ROLE_ADMIN", "ROLE_SCOLARITE" })

	/*
	 * @RequestMapping(value = "/findUsers") public String g(Model model) {
	 * List<User> users = userService.findAllUsers();
	 * model.addAttribute("listUsers", users); return "users"; }
	 */

	/*
	 * @PostUpdate("/update/users/{idUser}") public User updateUser(@PathVariable
	 * long idUser) { User u = userService.findUserById(idUser); return
	 * userService.saveUser(user); }
	 */

	/*
	 * @RequestMapping(value = "/addRoleToUser") public void addRoleToUser(String
	 * username, String role) { usersRolesService.addRoleToUser(username, role); }
	 */

	// solution 1 A ameliorer
	@GetMapping("/userConnected")
	public User getLogedUser1(HttpSession session) {
		SecurityContext securityContext = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
		String username = securityContext.getAuthentication().getName();

		User user = new User();
		user = userService.findUserByUsername(username);
		return user;
	}

	// solution 3 A ameliorer
	@GetMapping("/getLogedUser")
	public Map<String, Object> getLogedUser(HttpSession session) {
		SecurityContext securityContext = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
		String username = securityContext.getAuthentication().getName();
		List<String> roles = new ArrayList<>();
		for (GrantedAuthority ga : securityContext.getAuthentication().getAuthorities()) {

			roles.add(ga.getAuthority());
		}
		Map<String, Object> params = new HashMap<>();
		params.put("username", username);
		params.put("roles", roles);

		return params;

		/*
		 * 
		 * 
		 * user = securityContext.getAuthentication() ; listRoles = user.getRoles() ;
		 * 
		 * foms.findByName().getRoles ;
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

	}

}
