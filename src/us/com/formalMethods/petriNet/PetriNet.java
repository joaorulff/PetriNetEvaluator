package us.com.formalMethods.petriNet;

import java.util.ArrayList;
import java.util.Scanner;

import us.com.formalMethods.util.StringParser;

public class PetriNet {
	
	private Scanner in;
	
	int inputTable [][];
	int outputTable [][];
	
	public PetriNet(int numberOfTransitions, int numberOfPlaces){
		
		this.in = new Scanner(System.in);
		
		this.inputTable = new int [numberOfTransitions][numberOfPlaces]; 
		this.outputTable = new int [numberOfTransitions][numberOfPlaces];
		
		this.initializeInputPetriNetMatrix();
		this.initializeOutputPetriNetMatrix();
	}
	
	public void initializeInputPetriNetMatrix(){
		
		for (int i = 0; i < inputTable.length; i++) {
			
			boolean validInput = true;
			String currentInput;
			
			do{
				
				if(!validInput){
					System.out.println("Wrong input! Insert it again");
				}
				
				System.out.print("I(t" + i + "): ");
				currentInput = in.nextLine();
				validInput = StringParser.parseInputStringFormat(currentInput, inputTable[i].length);
				
			}while(!validInput);
			
			ArrayList<Integer> inputs = StringParser.parseInputString(currentInput, inputTable[i].length);
			
			for (int j = 0; j < inputTable[i].length; j++) {
				inputTable[i][j] = inputs.get(j);
			}
		}
	}
	
	public void printOutputMatrix(){
		for (int i = 0; i < outputTable.length; i++) {
			for (int j = 0; j < outputTable[i].length; j++) {
				System.out.print(outputTable[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	public void initializeOutputPetriNetMatrix(){

		
		for (int i = 0; i < outputTable.length; i++) {
			
			boolean validInput = true;
			String currentInput;
			
			do{
				
				if(!validInput){
					System.out.println("Wrong input! Insert it again");
				}
				
				System.out.print("O(t" + i + "): ");
				currentInput = in.nextLine();
				validInput = StringParser.parseInputStringFormat(currentInput, outputTable[i].length);
				
			}while(!validInput);
			
			ArrayList<Integer> inputs = StringParser.parseInputString(currentInput, inputTable[i].length);
			
			for (int j = 0; j < outputTable[i].length; j++) {
				outputTable[i][j] = inputs.get(j);
			}
		}
		
	}
	
	public ArrayList<Integer> avaiableTransitions(Marking m){
		
		ArrayList<Integer> tokens = m.getMarking();
		ArrayList<Integer> avaiableTransitions = new ArrayList<>();
		
		for (int i = 0; i < inputTable.length; i++) {
			
			boolean fireable = true;
			for (int j = 0; j < inputTable[i].length; j++) {
				if(tokens.get(j) < inputTable[i][j]){
					fireable = false; 
					break;
				}	
			}
			
			if(fireable) avaiableTransitions.add(i);
		}
		return avaiableTransitions;
	}
}

	
