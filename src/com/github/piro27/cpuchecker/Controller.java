package com.github.piro27.cpuchecker;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

/**
 * Created by st2307 on 2019/02/18.
 */
public class Controller {

	@FXML
	private Button button;

	private int i = 0;
	private boolean started;

	@FXML
	public void onAction(ActionEvent event) {
		System.out.println("Clicked.");
		if (!this.started) {
			this.started = true;
			System.out.println("3秒計測します...。");
			new Thread(() -> {
				try {
					Thread.sleep(3000);
				} catch (Exception e) {
				}

				this.runWithMainThread(() -> {
					System.out.println("終了！");

					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("CPS Checker");
					alert.setHeaderText("Ended!");
					alert.setContentText("Your CPS: " + (this.i / 3));
					alert.show();

					this.started = false;
					this.i = 0;
				});
			}).start();

			new Thread(() -> {
				try {
					Thread.sleep(5000);
				} catch (Exception e) {
				}

				System.out.println("計測を再開できます。");
			}).start();
		}

		this.i++;
	}

	public void runWithMainThread(Runnable r) {
		Platform.runLater(r);
	}

}
