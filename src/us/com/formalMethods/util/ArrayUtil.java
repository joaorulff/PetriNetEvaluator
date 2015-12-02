package us.com.formalMethods.util;

import java.util.ArrayList;

import us.com.formalMethods.petriNet.Marking;

public class ArrayUtil {
	
	public static boolean contains (ArrayList<Marking> markings, Marking m){
		
		if(markings.size() == 0) return false;	
		
		for (Marking marking : markings) {
			if(marking.compare(m)){
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean equalOrGreaterThan (ArrayList<Marking> markings, Marking m){
		
		if(markings.size() == 0) return false;	
		
		for (Marking marking : markings) {
			if(m.equalOrGreater(marking)){
				return true;
			}
		}
		
		return false;
		
	}

}
