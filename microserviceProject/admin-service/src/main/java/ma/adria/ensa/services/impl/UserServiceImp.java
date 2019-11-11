package ma.adria.ensa.services.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.adria.ensa.entities.User;
import ma.adria.ensa.repositories.UserRepository;
import ma.adria.ensa.services.UserService;
import ma.adria.ensa.services.UsersRolesService;

@Service
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UsersRolesService usersRolesService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User saveUser(User user) {
		// System.out
		// .println("111111111*********************************************************************************");
		String hashPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hashPassword);
		// usersRolesService.addRoleToUser(user.getUsername(), "PROF");
		// System.out
		// .println("2222222222*********************************************************************************");
		return userRepository.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public void deleteUserByUsername(String username) {
		User user = userRepository.findByUsername(username);

		userRepository.delete(user);
	}

	@Override
	public Page<User> findPageUser(Pageable pageable) {
		List<User> users = userRepository.findAll();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		List<User> list;
		if (users.size() < startItem) {
			list = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, users.size());
			list = users.subList(startItem, toIndex);
		}
		Page<User> userPage = new PageImpl<User>(list, PageRequest.of(currentPage, pageSize), users.size());
		return userPage;
	}

	@Override
	public void deleteUserById(Long idUser) {
		userRepository.deleteById(idUser);

	}

	@Override
	public User findUserById(Long idUser) {
		return userRepository.findByIdUser(idUser);
	}

}
