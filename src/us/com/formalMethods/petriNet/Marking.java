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


        boolean validInput = true;
        String currentInput;

        do{
            if(!validInput){
                    System.out.println("Wrong input! Insert it again");
            }

            System.out.print("Initial Marking: ");
            currentInput = in.nextLine();
            validInput = StringParser.parseInputStringFormat(currentInput, length);

        }while(!validInput);

        ArrayList<Integer> inputs = StringParser.parseInputString(currentInput, length);

        for(int i = 0; i<inputs.size(); i++) {
            marking.add(inputs.get(0));
        }

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
