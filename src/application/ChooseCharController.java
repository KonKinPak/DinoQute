package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sharedobject.RenderableHolder;

public class ChooseCharController {
	@FXML
	private Button btnVita, btnMort, btnTard, btnDoux, btnBack;

	public void setCharacter0() { // select Vita
		PlayGame_Main.setCharacter(0);
		PlayGame_Main.setScene(PlayGame_Main.getSceneChooseMode());
		RenderableHolder.mouseClick.play();
	}

	public void setCharacter1() { // select Mort
		PlayGame_Main.setCharacter(1);
		PlayGame_Main.setScene(PlayGame_Main.getSceneChooseMode());
		RenderableHolder.mouseClick.play();
	}

	public void setCharacter2() { // select Tard
		PlayGame_Main.setCharacter(2);
		PlayGame_Main.setScene(PlayGame_Main.getSceneChooseMode());
		RenderableHolder.mouseClick.play();
	}

	public void setCharacter3() { // select Doux
		PlayGame_Main.setCharacter(3);
		PlayGame_Main.setScene(PlayGame_Main.getSceneChooseMode());
		RenderableHolder.mouseClick.play();
	}

	public void back() {
		PlayGame_Main.setScene(PlayGame_Main.getSceneHome());
		RenderableHolder.mouseClick.play();
	}

	public void MouseEnterBack() {
		btnBack.setStyle(" -fx-background-color: #c1c1c1");
	}

	public void MouseExitBack() {
		btnBack.setStyle(" -fx-background-color: #ffffff");
	}

	public void MouseEnterVita() {
		btnVita.setStyle(" -fx-background-color: #9bdb91");
	}

	public void MouseExitVita() {
		btnVita.setStyle(" -fx-background-color: #64c155");
	}

	public void MouseEnterMort() {
		btnMort.setStyle(" -fx-background-color: #f27474");
	}

	public void MouseExitMort() {
		btnMort.setStyle(" -fx-background-color: #cc5a5a");
	}

	public void MouseEnterTard() {
		btnTard.setStyle(" -fx-background-color: #ffe18a");
	}

	public void MouseExitTard() {
		btnTard.setStyle(" -fx-background-color: #eec038");
	}

	public void MouseEnterDoux() {
		btnDoux.setStyle(" -fx-background-color: #8eafed");
	}

	public void MouseExitDoux() {
		btnDoux.setStyle(" -fx-background-color: #5671a4");
	}
}