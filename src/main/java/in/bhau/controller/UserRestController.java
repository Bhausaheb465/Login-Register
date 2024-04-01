package in.bhau.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import in.bhau.entity.User;
import in.bhau.service.UserService;

@RestController
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public ModelAndView getRegistrationForm(@ModelAttribute("user") User user) {
		ModelAndView mvn = new ModelAndView();
		mvn.setViewName("index");
		return mvn;		
	}
	
	@PostMapping("/register")
	public ModelAndView register(@ModelAttribute("user") User user) {
		ModelAndView mvn = new ModelAndView();
		User registerUser = userService.registerUser(user);
		if(registerUser != null) {
			mvn.addObject("regmsg", registerUser.getName()+" You register successfully..!");
		} else {
			mvn.addObject("regmsg", "Invalid Details..!");
		}		
		mvn.setViewName("index");
		return mvn;
	}
	
	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute("user") User user) {
		ModelAndView mvn = new ModelAndView();
		User loginUser = userService.loginUser(user.getEmail());
		if(loginUser!=null) {
			if(user.getPwd().equals(loginUser.getPwd())) {
				mvn.addObject("logmsg", loginUser.getName()+" You are log-In Successfully..!");
				mvn.setViewName("home");
			} else {
				mvn.addObject("logmsg", loginUser.getName()+" You entered Invalid Password..!");
				mvn.setViewName("index");
			}
		} else {
			mvn.addObject("logmsg", "User Not Found..!");
			mvn.setViewName("index");
		}
		return mvn;
	}

}
