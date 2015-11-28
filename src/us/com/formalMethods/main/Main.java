package us.com.formalMethods.main;


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
import us.com.formalMethods.petriNet.PetriNet;
import us.com.formalMethods.util.StringParser;
import us.com.formalMethods.view.MainWindow;

public class Main{
	
	
	public static void main(String[] args) {
		
		//launch(args);
		
		
		//PetriNet pt = new PetriNet(2, 3);
		
		int test [] = {1, 2, 3};
		int [][] matrix = new int [3][3];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++){
				matrix[i][j] = 0;
			}
		}
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++){
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("----------------");
		System.out.println(test.toString());
		System.out.println("----------------");
		
		
		matrix[0] = test;
		
		
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++){
				System.out.print(matrix[i][j] + '\t');
			}
			System.out.println();
		}
		
		
	}
}
