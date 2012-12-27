package by.bsuir.banking.domain;

import org.hibernate.validator.constraints.NotEmpty;

import by.bsuir.banking.admin.utils.PaymentUtil;

public class AutoPaymentInfo {
	//private AutoPayment payment;
	//private ObjectFactory factory = new ObjectFactory();
	private LegalPersonWrapper legalPerson = null;
	private EripWrapper erip = null;
	private ClientWrapper client;
	private String displayCard;
	private String infoString;
	private String cardNumber;
	private Integer dayOfMonth;
	private MoneyWrapper amount;
	private boolean saved = false;
	private Integer savedId;

	

	public AutoPaymentInfo(ClientWrapper client, LegalPersonWrapper legal) {
		//this.payment = payment;
		this.client = client;
		this.legalPerson = legal;
		//setLegalAccountId(legal.getAccount().getId());
	}

	public AutoPaymentInfo(ClientWrapper client, EripWrapper legal) {
		//this.payment = payment;
		this.client = client;
		this.erip = legal;
		//setLegalAccountId(legal.getAccountId());
	}

	public String getClientName() {
		if (client == null) {
			return null;
		}

		return client.getFirstName() + " " + client.getMiddleName() + " "
				+ client.getLastName();
	}

	public String getInfoLabel() {
		if (legalPerson != null) {
			return PaymentUtil.getLabelForCategory(legalPerson.getCategoryId());
		}
		if (erip != null) {
			return PaymentUtil.getLabelForErip(erip.getId());
		}
		return null;
	}

	
	/*public Integer getAccountId() {
		//return payment.getAccountId();
	}

	public void setAccountId(Integer id) {
		//payment.setAccountId(id);
	}*/

	/*public String getInformation() {
		return (payment.getInformation() == null) ? null : payment
				.getInformation().getValue();
	}

	public void setInformation(String info) {
		payment.setInformation(factory.createAutoPaymentInformation(info));
	}*/

	public Integer getDayOfMonth() {
		//return payment.getDayOfMonth();
		return dayOfMonth;
	}

	public void setDayOfMonth(Integer day) {
		//payment.setDayOfMonth(day);
		dayOfMonth = day;
	}

	public MoneyWrapper getAmount() {
		
		//return (payment.getMoney() == null) ? new MoneyWrapper() : new MoneyWrapper(payment
			//	.getMoney().getValue());
		return amount;
	}

	public void setAmount(MoneyWrapper amount) {
		//payment.setMoney(factory.createAutoPaymentMoney(amount.getMoney()));
		this.amount = amount;
	}

	/*public Integer getLegalAccountId() {
		return payment.getLegalAccountId();
	}

	public void setLegalAccountId(Integer id) {
		payment.setLegalAccountId(id);
	}*/

	public String getInfoString() {
		return infoString;
	}

	public void setInfoString(String infoString) {
		this.infoString = infoString;
	}

	public String getDisplayCard() {
		return displayCard;
	}

	public void setDisplayCard(String displayCard) {
		this.displayCard = displayCard;
	}

	public ClientWrapper getClient() {
		return client;
	}

	public void setClient(ClientWrapper client) {
		this.client = client;
	}

	public EripWrapper getErip() {
		return erip;
	}

	public void setErip(EripWrapper erip) {
		this.erip = erip;
	}

	public LegalPersonWrapper getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(LegalPersonWrapper legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	
	public Integer getSavedId() {
		return savedId;
	}

	public void setSavedId(Integer savedId) {
		this.savedId = savedId;
	}

	public boolean isSaved() {
		return saved;
	}

	public void setSaved(boolean saved) {
		this.saved = saved;
	}

}
