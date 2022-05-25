package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entities.User;
import com.example.demo.services.UserServiceImpl;


@Controller
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping("/")
	public String index(Model model) {
		return findPaginated(1, model);
	}

	@RequestMapping(value = "add")
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "addUser";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editUser(@RequestParam("id") Long userId, Model model) {
		Optional<User> userEdit = userService.findById(userId);
		userEdit.ifPresent(user -> model.addAttribute("user", user));

		return "editUser";
	}

	@RequestMapping(value = "/findid", method = RequestMethod.GET)
	public String find(@Param("keyword") String keyword, Model model) {
		if (keyword == "") {
			return findPaginated(1, model);
		} else {
			List<User> user = userService.searchUser(keyword);
			model.addAttribute("users", user);
		}
		
		return "find";
	}

	/**
	 * We have a form with many inputs. If the input values do not meet the validation criteria,
	 * the application redirects to the form page and shows error messages; 
	 * these messages are sent as flash attributes (RedirectAttributes)
	 * 
	 * BindingResult holds the result of a validation and contains errors that may have occurred.
	 * The BindingResult must come right after the model object that is validated
	 * 
	 * @param user
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@Valid User user, BindingResult bindingResult, RedirectAttributes model) {
		if (bindingResult.hasErrors()) {
			return "addUser";
		} else {
			userService.saveUser(user);
			model.addFlashAttribute("success", "Thêm mới tthành công!");
			return "redirect:/";
		}
	}

	@RequestMapping(value = "saveUpdate", method = RequestMethod.POST)
	public String saveUpdate(@Valid User user, BindingResult bindingResult, RedirectAttributes model) {
		if (bindingResult.hasErrors()) {
			return "addUser";
		} else {
			userService.saveUser(user);
			model.addFlashAttribute("success", "Cập nhật tthành công!");
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteUser(@RequestParam("id") Long userId, RedirectAttributes model) {
		userService.deleteUser(userId);
		model.addFlashAttribute("success", "Xóa thành công !");
		return "redirect:/";

	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
		int pageSize = 3;

		Page<User> page = userService.findPaginated(pageNo, pageSize);
		List<User> users = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("users", users);
		return "index";
	}
	
}