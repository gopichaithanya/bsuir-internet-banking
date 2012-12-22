package by.bsuir.banking.admin.utils;

public class InformationParser {

	public static String getInfoString(String information) {
		Integer pos = information.indexOf(":");
		String infoString = information.substring(pos + 1);
		return infoString;
	}
	
	//pattern id.Region,City,Service,infoLabel:infoString
	/*public static String getEripInfoString(String information) {
		Integer pos = information.lastIndexOf("")
	}*/
	
	
}
