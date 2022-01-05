package drawing;

import application.PlayGame_Main;
import entity.Apple;
import entity.Obstacle;
import entity.Snake;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import sharedobject.RenderableHolder;

public class GameScreen extends Canvas {

	public GameScreen(double width, double height) {
		super(width, height);
		this.setVisible(true);
		addListener();
	}

	public void addListener() {
		setOnKeyPressed((KeyEvent ke) -> {
			if (ke.getCode() == KeyCode.RIGHT && RenderableHolder.isPlaying() == true) {
				RenderableHolder.getInstance().setDown(false);
				RenderableHolder.getInstance().setUp(false);
				RenderableHolder.getInstance().setRight(true);
				RenderableHolder.getInstance().setLeft(false);
			}
			if (ke.getCode() == KeyCode.LEFT && RenderableHolder.isPlaying() == true) {
				RenderableHolder.getInstance().setDown(false);
				RenderableHolder.getInstance().setUp(false);
				RenderableHolder.getInstance().setRight(false);
				RenderableHolder.getInstance().setLeft(true);
			}
			if (ke.getCode() == KeyCode.DOWN && RenderableHolder.isPlaying() == true) {
				RenderableHolder.getInstance().setDown(true);
				RenderableHolder.getInstance().setUp(false);
				RenderableHolder.getInstance().setRight(false);
				RenderableHolder.getInstance().setLeft(false);
			}
			if (ke.getCode() == KeyCode.UP && RenderableHolder.isPlaying() == true) {
				RenderableHolder.getInstance().setDown(false);
				RenderableHolder.getInstance().setUp(true);
				RenderableHolder.getInstance().setRight(false);
				RenderableHolder.getInstance().setLeft(false);
			}
			if (ke.getCode() == KeyCode.R && RenderableHolder.isPlaying() == false) {
				RenderableHolder.letsPlaying();
				RenderableHolder.getInstance().setPoint(0);
			}
			if (ke.getCode() == KeyCode.H && RenderableHolder.isPlaying() == false) {
				PlayGame_Main.setScene(PlayGame_Main.getSceneHome());
				PlayGame_Main.setHomeScreen(true);
				PlayGame_Main.setGameScreen(false);

			}
		});
	}

	public void gameOver() {
		GraphicsContext gc = this.getGraphicsContext2D();
		gc.clearRect(0, 0, 600, 640);
		gc.drawImage(RenderableHolder.dinoDie, 0, 0, 600, 640);
		Font diefont = Font.font("Arial", FontWeight.BOLD, 78);
		gc.setFont(diefont);
		gc.setFill(Color.WHITE);
		gc.fillText("Game Over", 89, 167);
		diefont = Font.font("Arial", FontWeight.BOLD, 36);
		gc.setFont(diefont);
		gc.fillText("Your Scores " + Integer.toString(RenderableHolder.getPoint()), 168, 253);
		diefont = Font.font("Arial", FontWeight.BOLD, 49);
		gc.setFont(diefont);
		gc.fillText("Press R to Retry", 100, 352);
		gc.fillText("Press H to Home", 100, 420);
	}

	public void paintComponent() {
		GraphicsContext gc = this.getGraphicsContext2D();
		gc.drawImage(RenderableHolder.backGround, 0, 40, 600, 600);
		gc.setFill(Color.TOMATO);
		gc.fillRect(0, 0, 600, 40);
		Font scoreFont = Font.font("Arial", FontWeight.MEDIUM, 30);
		gc.setFont(scoreFont);
		gc.setFill(Color.WHITE);
		gc.fillText("Score : " + RenderableHolder.getPoint(), 450, 30);
		for (Snake s : RenderableHolder.getInstance().getSnakeArr()) {
			s.draw(gc);
		}
		for (Apple a : RenderableHolder.getInstance().getAppleArr()) {
			a.draw(gc);
		}
		for (Obstacle o : RenderableHolder.getInstance().getObstacleArr()) {
			o.draw(gc);
		}
	}

}
