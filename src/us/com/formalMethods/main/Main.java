package us.com.formalMethods.main;

import us.com.formalMethods.petriNet.Marking;
import us.com.formalMethods.petriNet.PetriNet;


public class Main{	
	
	public static void main(String[] args) throws InterruptedException {
		
		PetriNet pt = new PetriNet(3, 3);
		Marking initialMarking = new Marking(3);

		initialMarking.initializeMarking();

		pt.reachabilityTree(initialMarking);
	
			
		
	}
}
