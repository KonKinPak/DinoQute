package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import sharedobject.RenderableHolder;

public class HomePageController {

	@FXML
	private Button start, tutorial;

	public void MouseEnterStart() {
		start.setStyle(" -fx-background-color: #ffd864");
	}

	public void MouseExitStart() {
		start.setStyle(" -fx-background-color: #d34f47");
	}

	public void MouseEnterTutorial(MouseEvent event) {
		tutorial.setStyle(" -fx-background-color: #ffd864");
	}

	public void MouseExitTutorial(MouseEvent event) {
		tutorial.setStyle(" -fx-background-color: #85d6c0");
	}

	public void chooseChar() { // go to choose charactorScreen
		PlayGame_Main.setScene(PlayGame_Main.getSceneChooseChar());
		RenderableHolder.mouseClick.play();
	}

	public void tutorial() {
		PlayGame_Main.setScene(PlayGame_Main.getSceneTutorial1());
		RenderableHolder.mouseClick.play();
	}

}