package himedia.myportal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping({"/","/main"})
	public String home() {
		return "/WEB-INF/views/home.jsp";
	}
}
