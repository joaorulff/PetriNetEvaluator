package us.com.formalMethods.petriNet;

import us.com.formalMethods.util.StringParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Marking {
	
	private String tag;
	private String label;
	private ArrayList<Integer> marking;
	private int length;
	private Scanner in;
	public Marking(int length){
		
		this.length = length;
		marking = new ArrayList<>();
		this.in = new Scanner(System.in);
	}
	
	public void initializeMarking(){

		
		marking.add(2);
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
			//System.out.println("COMPARE: " + this.marking.get(i) + " --> " + mArray.get(i));
			if(this.marking.get(i) != mArray.get(i)){
				return false;
			}
		}
		return true;
	}
	
	public boolean equalOrGreater(Marking m){
		
		ArrayList<Integer> mArray = m.getMarking();
		
		for (int i = 0; i < this.marking.size(); i++) {
			if(this.marking.get(i) < mArray.get(i)){
				return false;
			}
		}
		
		for (int i = 0; i < this.marking.size(); i++) {
			if(this.marking.get(i) > mArray.get(i)){
				this.marking.set(i, 1000);
			}
		}
		return true;
	} 
	
	public int getElementFromMarking(int i){
		return this.marking.get(i);
	}

}
