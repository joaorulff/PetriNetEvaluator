package us.com.formalMethods.petriNet;

import java.util.Scanner;

public class PetriNet {
	
	private Scanner in;
	
	int inputTable [][];
	int outputTable [][];
	
	public PetriNet(int numberOfPlaces, int numberOfTransitions){
		
		this.in = new Scanner(System.in);
		
		
		this.inputTable = new int [numberOfTransitions][numberOfPlaces]; 
		this.outputTable = new int [numberOfTransitions][numberOfPlaces];
		
		//System.out.println(outputTable[0].length);
		
		this.initializeInputPetriNetMatrix();
	}
	
	public void initializeInputPetriNetMatrix(){
		for (int i = 0; i < inputTable.length; i++) {
			for (int j = 0; j < inputTable[i].length; j++) {
				System.out.println("I(t" + i + "):");
				inputTable[i][j] = this.in.nextInt();
			}
			System.out.print("");
		}
	}
	
	public void setTransitionInput(int transition, int inputPlaces){
		
	}
}
