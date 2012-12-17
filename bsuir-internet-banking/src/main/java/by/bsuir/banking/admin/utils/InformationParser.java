package by.bsuir.banking.admin.utils;

public class InformationParser {

	public static String getInfoString(String information) {
		Integer pos = information.indexOf(":");
		String infoString = information.substring(pos + 1);
		return infoString;
	}
	
	
}
