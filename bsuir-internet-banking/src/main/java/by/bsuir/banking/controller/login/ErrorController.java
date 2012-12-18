package by.bsuir.banking.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController extends EntityController {
	
	@RequestMapping()
	public String error(){
		return "error";
	}
}
