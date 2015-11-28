package us.com.formalMethods.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindow extends Application{
	
	public MainWindow(String [] args) {
		this.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Petri Nets");
		primaryStage.show();
		
	}

}
