package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sharedobject.RenderableHolder;

public class TutorialController {
	@FXML
	private Button btnBack1, btnBack2, btnNext1, btnNext2;

	public void back1() {
		PlayGame_Main.setScene(PlayGame_Main.getSceneHome());
		RenderableHolder.mouseClick.play();
	}

	public void next1() {
		PlayGame_Main.setScene(PlayGame_Main.getSceneTutorial2());
		RenderableHolder.mouseClick.play();
	}

	public void back2() {
		PlayGame_Main.setScene(PlayGame_Main.getSceneTutorial1());
		RenderableHolder.mouseClick.play();
	}

	public void next2() {
		PlayGame_Main.setScene(PlayGame_Main.getSceneHome());
		RenderableHolder.mouseClick.play();
	}

	public void MouseEnterBack1() {
		btnBack1.setStyle(" -fx-background-color: #c1c1c1");
	}

	public void MouseExitBack1() {
		btnBack1.setStyle(" -fx-background-color: #ffffff");
	}

	public void MouseEnterNext1() {
		btnNext1.setStyle(" -fx-background-color: #c1c1c1");
	}

	public void MouseExitNext1() {
		btnNext1.setStyle(" -fx-background-color: #ffffff");
	}

	public void MouseEnterBack2() {
		btnBack2.setStyle(" -fx-background-color: #c1c1c1");
	}

	public void MouseExitBack2() {
		btnBack2.setStyle(" -fx-background-color: #ffffff");
	}

	public void MouseEnterNext2() {
		btnNext2.setStyle(" -fx-background-color: #c1c1c1");
	}

	public void MouseExitNext2() {
		btnNext2.setStyle(" -fx-background-color: #ffffff");
	}
}