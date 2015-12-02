package us.com.formalMethods.main;


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
	
	
	public static void main(String[] args) throws InterruptedException {
		
		PetriNet pt = new PetriNet(3, 3);
		Marking initialMarking = new Marking(3);
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
