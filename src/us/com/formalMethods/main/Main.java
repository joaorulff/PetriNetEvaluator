package us.com.formalMethods.main;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.sun.javafx.scene.SceneHelper;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import us.com.formalMethods.petriNet.Marking;
import us.com.formalMethods.petriNet.PetriNet;
import us.com.formalMethods.util.ArrayUtil;
import us.com.formalMethods.util.StringParser;
import us.com.formalMethods.view.MainWindow;

public class Main{


	public static void main(String[] args) throws InterruptedException, IOException {
        int places = 0;
        int transitions = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of places:");
        places = Integer.parseInt(br.readLine());
        System.out.print("Enter number of transitions:");
        transitions = Integer.parseInt(br.readLine());
        //System.out.print(places + " " + transitions);

		PetriNet pt = new PetriNet(transitions, places);
		Marking initialMarking = new Marking(places);

		initialMarking.initializeMarking();
		
		/*ArrayList<Integer> otherArray = new ArrayList<>();
		otherArray.add(2);
		otherArray.add(0);
		otherArray.add(0);
		otherArray.add(0);
		
		ArrayList<Marking> test = new ArrayList<>();
		
		
		Marking otherMarking = new Marking(4);
		otherMarking.setMarking(otherArray);
		
		test.add(otherMarking);
		
		System.out.println(ArrayUtil.contains(test, initialMarking));*/
		
		
		pt.reachabilityTree(initialMarking);
		/*System.out.println("--------------------------------");
		ArrayList<Marking> printArray = pt.markingsForReachability;
		for (Marking marking : printArray) {
			marking.printMarking();
		}*/
			
		
	}
}
