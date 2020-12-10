package com.mm.com.service;

import com.mm.com.dto.ChangePasswordForm;
import com.mm.com.exceptions.UsernameOrIdNotFound;
import com.mm.com.model.User;

public interface IUsuarioService {

	public Iterable<User> getAllUsers();

	public User createUser(User user) throws Exception;

	public User getUserById(Long id) throws Exception;

	public User updateUser(User user) throws Exception;

	public void deleteUser(Long id) throws UsernameOrIdNotFound;
	
	public User changePassword(ChangePasswordForm form) throws Exception;

}
