package by.bsuir.banking.admin.utils;

import org.apache.log4j.Logger;

public class AdminUtils {
	
	public static void logInfo(Logger logger, String msg, String details){
		if(logger.isInfoEnabled()){
			logger.info(msg + ": " + details + ".");
		}
	}

	public static void logInfo(Logger logger, String msg){
		if(logger.isInfoEnabled()){
			logger.info(msg + ".");
		}
	}
	
	public static void logDebug(Logger logger, String msg, String details){
		if(logger.isDebugEnabled()){
			logger.debug(msg + ": " + details + ".");
		}
	}
	
	public static void logDebug(Logger logger, String msg){
		if(logger.isDebugEnabled()){
			logger.debug(msg + ".");
		}
	}
}
