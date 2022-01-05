package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sharedobject.RenderableHolder;

public class ChooseModeController {
	@FXML
	private Button btnClassic, btnHard, btnHell, btnBack;

	public void selectClassic() { // select classic
		RenderableHolder.setObstacleOn(false);
		RenderableHolder.getInstance().setFriction(15);
		PlayGame_Main.setScene(PlayGame_Main.getSceneGame());
		PlayGame_Main.setHomeScreen(false);
		PlayGame_Main.setGameScreen(true);
		RenderableHolder.letsPlaying();
		RenderableHolder.mouseClick.play();
	}

	public void selectHard() { // select hard
		RenderableHolder.setObstacleOn(true);
		RenderableHolder.getInstance().setFriction(15);
		PlayGame_Main.setScene(PlayGame_Main.getSceneGame());
		PlayGame_Main.setHomeScreen(false);
		PlayGame_Main.setGameScreen(true);
		RenderableHolder.letsPlaying();
		RenderableHolder.mouseClick.play();
	}

	public void selectHell() { // select hell
		RenderableHolder.setObstacleOn(true);
		RenderableHolder.getInstance().setFriction(7);
		PlayGame_Main.setCharacter(PlayGame_Main.getCharacter() + 4);
		PlayGame_Main.setScene(PlayGame_Main.getSceneGame());
		PlayGame_Main.setHomeScreen(false);
		PlayGame_Main.setGameScreen(true);
		RenderableHolder.letsPlaying();
		RenderableHolder.mouseClick.play();
	}

	public void back() {
		PlayGame_Main.setScene(PlayGame_Main.getSceneChooseChar());
		RenderableHolder.mouseClick.play();
	}

	public void MouseEnterBack() {
		btnBack.setStyle(" -fx-background-color: #c1c1c1");
	}

	public void MouseExitBack() {
		btnBack.setStyle(" -fx-background-color: #ffffff");
	}

	public void MouseEnterClassic() {
		btnClassic.setStyle(" -fx-background-color: #98e3ca");
	}

	public void MouseExitClassic() {
		btnClassic.setStyle(" -fx-background-color: #66CDAA");
	}

	public void MouseEnterHard() {
		btnHard.setStyle(" -fx-background-color: #fae198");
	}

	public void MouseExitHard() {
		btnHard.setStyle(" -fx-background-color: #f7ce55");
	}

	public void MouseEnterHell() {
		btnHell.setStyle(" -fx-background-color: #f7a8a8");
	}

	public void MouseExitHell() {
		btnHell.setStyle(" -fx-background-color: #f47171");
	}
}