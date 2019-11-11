package ma.adria.ensa;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ma.adria.ensa.entities.Role;
import ma.adria.ensa.entities.User;
import ma.adria.ensa.services.RoleService;
import ma.adria.ensa.services.UserService;
import ma.adria.ensa.services.UsersRolesService;

@SpringBootApplication
public class EnaAuthApplication implements CommandLineRunner {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(EnaAuthApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

	// ******************* ++++++ *****************

	@Autowired
	private UserService usersService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UsersRolesService usersRolesService;

	@Override
	public void run(String... args) throws Exception {
		// System.out.println("***************" + usersService.findAllUsers());
		// System.out.println("***************" +
		// usersService.findUserByUsername("admin"));
		if (usersService.findAllUsers().isEmpty() && usersService.findUserByUsername("admin") == null) {
			// Ajout user par défaut
			User u = new User();
			u.setUsername("admin");
			u.setPassword("admin");
			u.setActivated(true);
			usersService.saveUser(u);

			// Ajout Role par défaut
			Role r0 = new Role();
			Role r1 = new Role();
			Role r2 = new Role();
			r0.setRole("ADMIN");
			r0.setDescription("Super Admin");
			roleService.saveRole(r0);
			r1.setRole("GR");
			r1.setDescription("Gerant");
			roleService.saveRole(r1);
			r2.setRole("RECEP");
			r2.setDescription("Reception");
			roleService.saveRole(r2);

			// affecter role a user par defaut
			usersRolesService.addRoleToUser("admin", "ADMIN");
		}
		// usersRolesService.addRoleToUser("Prof33", "PROF");
		// OK *************** Add Role ****************
		// Role r = new Role();
		// r.setRole("USER");
		// // r.setDescription("administrateur");
		// roleService.saveRole(r);

		// OK *************** Add User ***************
		// User u = new User();
		// u.setUsername("abc");
		// u.setPassword("abc");
		// usersService.saveUser(u);

		// OK *************** Add Role To User **************
		// usersRolesService.addRoleToUser("admin", "USER");
		// usersRolesService.addRoleToUser("admin", "PROF");

		// OK *********** test find Role By Username *********************
		// Collection<Role> roles = usersRolesService.findRoleByUsername("admin");
		// for (Role e : roles) {
		// System.out.println(e.getRole());
		// }

	}

}
