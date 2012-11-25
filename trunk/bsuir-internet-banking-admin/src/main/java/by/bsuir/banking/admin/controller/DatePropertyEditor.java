package by.bsuir.banking.admin.controller;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

import by.bsuir.banking.admin.utils.AdminUtils;

public class DatePropertyEditor extends PropertyEditorSupport {
	private static Logger logger = Logger.getLogger(DatePropertyEditor.class);
	private String format = "MM/dd/yyyy";
	private SimpleDateFormat dateFormat = new SimpleDateFormat(format);

	private Date defaultDate = new Date(0L);

	@Override
	public void setAsText(String textValue) throws IllegalArgumentException {
		if (textValue == null) {
			setValue(defaultDate);
			return;
		}
		Date retDate = defaultDate;
		GregorianCalendar calendar = new GregorianCalendar();
		try {
			retDate = dateFormat.parse(textValue);
			calendar.setTime(retDate);
		} catch (ParseException e) {
			AdminUtils.logError(logger, "Could not parse " + textValue + " as date");
		}

		setValue(retDate);
	}
	
	
	
	
}
