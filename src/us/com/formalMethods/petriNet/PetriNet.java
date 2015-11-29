package us.com.formalMethods.petriNet;

import java.util.ArrayList;
import java.util.Scanner;

import us.com.formalMethods.util.ArrayUtil;
import us.com.formalMethods.util.StringParser;

public class PetriNet {
	
	private Scanner in;
	
	int inputTable [][];
	int outputTable [][];
	
	public ArrayList<Marking> markingsForReachability;
	
	public PetriNet(int numberOfTransitions, int numberOfPlaces){
		
		this.markingsForReachability = new ArrayList<>();
		
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
	
	public Marking fireTransition(int transitionNumber, Marking m){
		
		if(m.getLength() != inputTable[0].length) {
			System.out.println("Invalid Marking");
			return null;
		}
		
		ArrayList<Integer> oldMarking = m.getMarking();
		ArrayList<Integer> newMarking = new ArrayList<>();
		
		for (int j = 0; j < inputTable[transitionNumber].length; j++) {
			newMarking.add(oldMarking.get(j) - inputTable[transitionNumber][j] + outputTable[transitionNumber][j]);
		}
		
		Marking newMarkingObject = new Marking(m.getLength());
		newMarkingObject.setMarking(newMarking);
		
		return newMarkingObject;
	}
	
	public void reachabilityTree (Marking root) throws InterruptedException{
		
		if(ArrayUtil.contains(markingsForReachability, root)){
			System.out.println("Old");
			return;
		}else{
			markingsForReachability.add(root);
		}
		
		ArrayList<Integer> avaiableTransitions = this.avaiableTransitions(root);
		root.printMarking();
		
		if(avaiableTransitions.size() == 0){
			System.out.println("Dead end");
			return;
		}else{
			for (Integer transition : avaiableTransitions) {
				
				System.out.println("Transition " + (transition+1)+ " fires");
				Marking newMarking = fireTransition(transition, root);
				Thread.sleep(100);
				reachabilityTree(newMarking);
			}
		}
		
	}
}

	
