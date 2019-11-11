package ma.adria.ensa.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ma.adria.ensa.entities.User;

public interface UserService {
	public User saveUser(User u);

	public void deleteUserByUsername(String username);

	public void deleteUserById(Long idUser);

	public List<User> findAllUsers();

	public User findUserById(Long idUser);

	public User findUserByUsername(String username);

	public Page<User> findPageUser(Pageable pageable);

}
