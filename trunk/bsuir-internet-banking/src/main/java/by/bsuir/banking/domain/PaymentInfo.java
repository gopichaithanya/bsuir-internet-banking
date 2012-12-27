package by.bsuir.banking.domain;

import by.bsuir.banking.admin.utils.PaymentUtil;

/**
 * Wrapper for payment, contains information about additional field that we need
 * for particular payment
 * 
 * @author E.Krasnotschek
 * 
 */
public class PaymentInfo {

	private LegalPersonWrapper legalPerson = null;
	private EripWrapper erip = null;
	private ClientWrapper client;
	private String cardNumber;
	private String displayCard;
	private boolean saved = false;
	private boolean toSave;
	private Integer savedId;

	private String infoString;
	private MoneyWrapper amount;

	public PaymentInfo(LegalPersonWrapper person) {
		legalPerson = person;
	}

	public PaymentInfo(LegalPersonWrapper person, ClientWrapper client,
			boolean isSaved) {
		legalPerson = person;
		this.client = client;
		saved = isSaved;
	}

	public PaymentInfo(EripWrapper erip, ClientWrapper client, boolean isSaved) {
		this.setErip(erip);
		this.client = client;
		saved = isSaved;
	}

	public LegalPersonWrapper getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(LegalPersonWrapper legalPerson) {
		this.legalPerson = legalPerson;
	}

	public ClientWrapper getClient() {
		return client;
	}

	public void setClient(ClientWrapper client) {
		this.client = client;
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
		if(erip != null){
			return PaymentUtil.getLabelForErip(erip.getId());
		}
		return null;
	}

	public String getInfoString() {
		return infoString;
	}

	public void setInfoString(String value) {
		infoString = value.trim();
	}

	public MoneyWrapper getAmount() {
		return amount;
	}

	public void setAmount(MoneyWrapper value) {
		amount = value;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public boolean isSaved() {
		return saved; 
	}

	public void setSaved(boolean saved) {
		this.saved = saved;
	}

	public boolean isToSave() {
		return toSave;
	}

	public void setToSave(boolean toSave) {
		this.toSave = toSave;
	}

	public EripWrapper getErip() {
		return erip;
	}

	public void setErip(EripWrapper erip) {
		this.erip = erip;
	}

	public String getDisplayCard() {
		return displayCard;
	}

	public void setDisplayCard(String displayCard) {
		this.displayCard = displayCard;
	}

	public Integer getSavedId() {
		return savedId;
	}

	public void setSavedId(Integer savedId) {
		this.savedId = savedId;
	}

	public String getHelpLabel() {
		if (legalPerson != null) {
			return PaymentUtil.getHelpLabelForCategory(legalPerson.getCategoryId());
		}
		if(erip != null){
			return PaymentUtil.getHelpLabelForErip(erip.getId());
		}
		return null;
	}


}
