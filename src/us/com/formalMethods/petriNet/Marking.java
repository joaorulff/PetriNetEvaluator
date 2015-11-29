package us.com.formalMethods.petriNet;

import java.util.ArrayList;

public class Marking {
	
	private String tag;
	private String label;
	private ArrayList<Integer> marking;
	private int length;
	
	public Marking(int length){
		
		this.length = length;
		marking = new ArrayList<>();
		
	}
	
	public void initializeMarking(){
		
		marking.add(2);
		marking.add(0);
		marking.add(0);
		marking.add(0);
		
	}

	public void printMarking(){
		
		for (Integer token : marking) {
			System.out.print(token+"\t");
		}
		System.out.println();

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
	
	public int getLength(){
		return this.length;
	}
	
	public boolean compare(Marking m){
		ArrayList<Integer> mArray = m.getMarking();
		
		for (int i = 0; i < this.marking.size(); i++) {
			if(this.marking.get(i) != mArray.get(i)){
				return false;
			}
		}
		return true;
	}
	
	public int getElementFromMarking(int i){
		return this.marking.get(i);
	}

}
