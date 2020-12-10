package com.mm.com.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mm.com.dto.ChangePasswordForm;
import com.mm.com.exceptions.CustomeFieldValidationException;
import com.mm.com.exceptions.UsernameOrIdNotFound;
import com.mm.com.model.Role;
import com.mm.com.model.User;
import com.mm.com.repository.RolRepository;
import com.mm.com.service.IUsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	IUsuarioService usuarioService;

	@Autowired
	RolRepository roleRepository;

	@GetMapping( "/login" )
	public String index() {
		return "indexX";
	}


	@PostMapping("/signup")
	public String createCuenta(@Valid @ModelAttribute("userForm")User user, BindingResult result, ModelMap model) {
		Role userRole = roleRepository.findByName("USER");
		List<Role> roles = Arrays.asList(userRole);
		model.addAttribute("userForm", user);
		model.addAttribute("roles",roles);
		model.addAttribute("signup",true);
		
		if(result.hasErrors()) {
			return "user-form/user-signup";
		}else {
			try {
				usuarioService.createUser(user);
			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
			}catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
			}
		}
		return index();
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		Role userRole = roleRepository.findByName("USER");
		List<Role> roles = Arrays.asList(userRole);

		model.addAttribute("signup", true);
		model.addAttribute("userForm", new User());
		model.addAttribute("roles", roles);
		return "user-form/user-signup";
	}

	@GetMapping("/userForm")
	public String userForm(Model model) {
		model.addAttribute("userForm", new User());
		model.addAttribute("userList", usuarioService.getAllUsers());
		model.addAttribute("roles", roleRepository.findAll());
		model.addAttribute("listTab", "active");
		return "user-form/user-view";

	}

	@PostMapping("/userForm")
	public String createUser(@Valid @ModelAttribute("userForm") User user, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("userForm", user);
			model.addAttribute("formTab", "active");
		} else {
			try {
				usuarioService.createUser(user);
				model.addAttribute("userForm", new User());
				model.addAttribute("listTab", "active");

			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
				model.addAttribute("userForm", user);
				model.addAttribute("formTab", "active");
				model.addAttribute("userList", usuarioService.getAllUsers());
				model.addAttribute("roles", roleRepository.findAll());
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("userForm", user);
				model.addAttribute("formTab", "active");
				model.addAttribute("userList", usuarioService.getAllUsers());
				model.addAttribute("roles", roleRepository.findAll());
			}
		}

		model.addAttribute("userList", usuarioService.getAllUsers());
		model.addAttribute("roles", roleRepository.findAll());
		return "user-form/user-view";
	}

	@GetMapping("/editUser/{id}")
	public String getEditUserForm(Model model, @PathVariable(name = "id") Long id) throws Exception {
		User user = usuarioService.getUserById(id);

		model.addAttribute("userList", usuarioService.getAllUsers());
		model.addAttribute("roles", roleRepository.findAll());
		model.addAttribute("userForm", user);
		model.addAttribute("formTab", "active");
		model.addAttribute("passwordForm", new ChangePasswordForm(id));

		model.addAttribute("editMode", true);

		return "user-form/user-view";
	}

	@PostMapping("/editUser")
	public String postEditUserForm(@Valid @ModelAttribute("userForm") User user, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("userForm", user);
			model.addAttribute("formTab", "active");
			model.addAttribute("editMode", "true");
			model.addAttribute("passwordForm", new ChangePasswordForm(user.getId()));

		} else {
			try {
				usuarioService.updateUser(user);
				model.addAttribute("userForm", new User());
				model.addAttribute("listTab", "active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("userForm", user);
				model.addAttribute("formTab", "active");
				model.addAttribute("userList", usuarioService.getAllUsers());
				model.addAttribute("roles", roleRepository.findAll());
				model.addAttribute("editMode", "true");
			}
		}

		model.addAttribute("userList", usuarioService.getAllUsers());
		model.addAttribute("roles", roleRepository.findAll());
		return "user-form/user-view";

	}

	@GetMapping("/userForm/cancel")
	public String cancelEditUser(ModelMap model) {
		return "redirect:/userForm";
	}

	@GetMapping("/deleteUser/{id}")
	public String deleteUser(Model model, @PathVariable(name = "id") Long id) {
		try {
			usuarioService.deleteUser(id);

		} catch (UsernameOrIdNotFound uoin) {
			model.addAttribute("listErrorMessage", uoin.getMessage());
		}
		return userForm(model);
	}

	@PostMapping("/editUser/changePassword")
	public ResponseEntity postEditUseChangePassword(@Valid @RequestBody ChangePasswordForm form, Errors errors) {
		try {
			if (errors.hasErrors()) {
				String result = errors.getAllErrors().stream().map(x -> x.getDefaultMessage())
						.collect(Collectors.joining(""));

				throw new Exception(result);
			}
			usuarioService.changePassword(form);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok("Success");
	}

}
