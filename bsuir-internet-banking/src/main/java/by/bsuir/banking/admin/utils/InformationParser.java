package by.bsuir.banking.admin.utils;

public class InformationParser {

	public static String getInfoString(String information) {
		Integer pos = information.indexOf(":");
		String infoString = information.substring(pos + 1);
		return infoString;
	}
	
	public static Integer getEripIdFromInformation(String information){
		int pos = information.indexOf(".");
		Integer id = Integer.valueOf(information.substring(0, pos));
		return id;
	}
	
	public static String getEripInformation(String information){
		Integer pos = information.indexOf(".");
		String info = information.substring(pos+1);
		return info;
	}
	
	//pattern id.Region,City,Service,infoLabel:infoString
	/*public static String getEripInfoString(String information) {
		Integer pos = information.lastIndexOf("")
	}*/
	
	
}
