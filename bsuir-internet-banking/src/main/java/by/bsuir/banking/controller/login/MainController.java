package by.bsuir.banking.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main**")
public class MainController extends EntityController {

	@RequestMapping(method=RequestMethod.GET)
	public String returnView(){
		return "main";
	}
}
