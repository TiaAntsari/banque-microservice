package ma.adria.ensa.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ma.adria.ensa.entities.Permission;
import ma.adria.ensa.repositories.PermissionRepository;
import ma.adria.ensa.services.PermissionService;

public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionRepository permissionRepository;

	@Override
	public Permission savePermission(Permission permission) {
		return permissionRepository.save(permission);
	}

	@Override
	public List<Permission> findAllPermissions() {
		return permissionRepository.findAll();
	}

	@Override
	public Permission findPermissionByOperation(String operation) {
		return permissionRepository.findByOperation(operation);
	}

	@Override
	public void deletePermissionByOperation(String operation) {
		Permission permission = permissionRepository.findByOperation(operation);
		permissionRepository.delete(permission);
	}

	@Override
	public void deletePermissionByIdPermission(int idPermission) {
		Permission permission = permissionRepository.findByIdPermission(idPermission);
		permissionRepository.delete(permission);
	}

	@Override
	public Permission findPermissionByIdPermission(int idPermission) {
		return permissionRepository.findByIdPermission(idPermission);
	}

}
