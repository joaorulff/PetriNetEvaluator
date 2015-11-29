package us.com.formalMethods.util;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
	
	public static ArrayList<Integer> parseInputString(String input, int numberOfPlaces){
		
		
		Pattern regexPatternInputs = Pattern.compile("[0-9]");
		Matcher regexMatcherInputs = regexPatternInputs.matcher(input);
		
		ArrayList<Integer> arrayOfInputs = new ArrayList<>();
		
		while (regexMatcherInputs.find()) {
			arrayOfInputs.add(Integer.parseInt(regexMatcherInputs.group()));
		}
		
		return arrayOfInputs;
		
	}
	
	//This method checks if the user's input is in the right format. Ex: (1,2,3,4,5)
	public static boolean parseInputStringFormat(String input, int numberOfPlaces){
		
		Pattern regexPatternFormatedInput = Pattern.compile("\\(([0-9]\\,)*[0-9]\\)");
		Matcher regexMatcherFormatedInput = regexPatternFormatedInput.matcher(input);
		
		ArrayList<Integer> arrayOfInputs = parseInputString(input, numberOfPlaces);
		
		
		if(regexMatcherFormatedInput.find() && (arrayOfInputs.size() == numberOfPlaces) ) return true;  return false;
		
	}

}
