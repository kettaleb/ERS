/*
 * package com.revature.security;
 * 
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestMapping;
 * 
 * import com.revature.dao.UserRepository; import com.revature.models.ErsUser;
 * 
 * @Controller
 * 
 * @RequestMapping("/") public class SecurityController {
 * 
 * @Autowired UserRepository useRepo;
 * 
 * @Autowired BCryptPasswordEncoder bCryptEncoder;
 * 
 * 
 * @GetMapping("/register") public String register(Model model) { ErsUser
 * ersUser = new ErsUser(); model.addAttribute("ersUser", ersUser);
 * 
 * return "/register"; }
 * 
 * @PostMapping("/register/save") public String saveUser(Model model, ErsUser
 * ersUser) { ersUser.setPassword(bCryptEncoder.encode(ersUser.getPassword()));
 * useRepo.save(ersUser); return "redirect:/login"; }
 * 
 * 
 * }
 */