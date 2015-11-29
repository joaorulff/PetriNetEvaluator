package us.com.formalMethods.petriNet;

import java.util.ArrayList;

public class Marking {
	
	private String tag;
	private ArrayList<Integer> marking;
	
	public Marking(){
		
		marking = new ArrayList<>();
		
		marking.add(1);
		marking.add(0);
		marking.add(1);
	}
	
	public void initializeMarking(){
		
	}
	
	public void printMarking(){
		
		for (Integer token : marking) {
			System.out.print(token+"\t");
		}

	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public ArrayList<Integer> getMarking() {
		return marking;
	}

	public void setMarking(ArrayList<Integer> marking) {
		this.marking = marking;
	}

}
