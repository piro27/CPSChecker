package com.github.piro27.cpuchecker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by st2307 on 2019/02/18.
 */
public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent parent = null;
		try {
			parent = FXMLLoader.load(this.getClass().getResource("/CPS.fxml"));
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		stage.setTitle("CPS Checker");
		stage.setScene(new Scene(parent, 485, 212));
		stage.show();
	}

}
