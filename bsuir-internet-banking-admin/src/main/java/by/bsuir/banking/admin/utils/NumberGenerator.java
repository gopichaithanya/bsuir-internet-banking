package by.bsuir.banking.admin.utils;

import java.util.Random;

/**
 * Helper class for generating account and card numbers
 * 
 * @author Katherine
 * 
 */
public class NumberGenerator {

	private static String characters = "0123456789";
	private static final String BANK_CODE = "739";
	private static final String BANK_ID = "54855";
	private static final String IND_NUMBER = "3012";
	private static Random rand = new Random();

	public static String generateCardNumber(String cardTypeName) {
		if(cardTypeName.equalsIgnoreCase("Visa")){
			return generateVisaNumber();
		}
		if(cardTypeName.equalsIgnoreCase("MasterCard")){
			return generateMasterCardNumber();
		}
		if(cardTypeName.equalsIgnoreCase("China Union Pay")){
			return generateCUPNumber();
		}
		if(cardTypeName.equalsIgnoreCase("JCB")){
			return generateJCBNumber();
		}
		String firstPart = "0" + BANK_ID + generateString(rand, characters, 9);
		return  firstPart + generateCardContorlKey(firstPart); //0 for now
	}

	private static String generateJCBNumber() {
		String firstPart = "3" + BANK_ID + generateString(rand, characters, 9);
		return firstPart + generateCardContorlKey(firstPart);
	}

	private static String generateCUPNumber() {
		String firstPart = "6" + BANK_ID + generateString(rand, characters, 9);
		return firstPart + generateCardContorlKey(firstPart);
	}

	private static String generateMasterCardNumber() {
		String firstPart = "5" + BANK_ID + generateString(rand, characters, 9);
		return firstPart + generateCardContorlKey(firstPart);
	}

	private static String generateVisaNumber() {
		String firstPart = "4" + BANK_ID + generateString(rand, characters, 9);
		return firstPart + generateCardContorlKey(firstPart);
	}

	
	private static String generateCardContorlKey(String firstPart) {
		int sum_odd = 0;
		int sum_even = 0;
		for(int i = 0; i < firstPart.length(); i++){
			if((i % 2) == 0){
			int mult = Character.getNumericValue(firstPart.charAt(i)) * 2;
			if(mult >= 10){
				mult -= 9;
			}
			sum_even += mult;
			}else{
				sum_odd = Character.getNumericValue(firstPart.charAt(i));
			}
		}
		return String.valueOf(10 - ((sum_even + sum_odd) % 10));
	}


	public static String generateAccountNumber() {
		String firstDigits = IND_NUMBER;
		String secondDigits = generateString(rand, characters, 8);
		String controlKey = generateAccountControlKey(secondDigits);
		return firstDigits + secondDigits + controlKey;
	}

	private static String generateString(Random rng, String characters,
			int length) {
		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = characters.charAt(rng.nextInt(characters.length()));
		}
		return new String(text);
	}

	private static String generateAccountControlKey(String secondDigits) {
		String fullNumber = BANK_CODE + IND_NUMBER + secondDigits;
		int[] weights = { 7, 1, 3, 3, 7, 1, 3, 7, 1, 3, 7, 1, 3, 7, 1 };
		int sum = 0;
		for (int i = 0; i < weights.length; i++) {
			int digit = Character.getNumericValue(fullNumber.charAt(i));
			int lastDigit = (digit * weights[i]) % 10;
			sum += lastDigit;
		}
		int mult = (sum % 10) * 3;
		return String.valueOf(mult % 10);
		

	}
	
	public static String generateCVV2(){
		return generateString(rand, characters, 3);
	}
}
