package by.bsuir.banking.controller.history;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;


@Controller
@RequestMapping("/history/transfer")
@SessionAttributes("cardSelect")
public class ViewTransferHistoryController extends EntityController {
	private static final String VIEW_NAME = "history-transfer";
	private IInternetBankingService service;
	
	public ViewTransferHistoryController(){
		service = ServiceProvider.getInternetBankingService();
	}
	
	
	
}
