package application;

import java.io.IOException;

import drawing.GameScreen;
import javafx.animation.AnimationTimer;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import sharedobject.RenderableHolder;

public class PlayGame_Main extends Application {
	private static boolean isHomeScreen = true;
	private static boolean isGameScreen = false;

	private static Scene sceneHome;
	private static Scene sceneChooseChar;
	private static Scene sceneChooseMode;
	private static Scene sceneGame;

	private static Scene sceneTutorial1;
	private static Scene sceneTutorial2;

	private static GameScreen gameScreen;
	private static Stage primarystage;

	private static int character = 0;
	private static int gameMode = 0;

	@Override
	public void start(Stage primarystage) {
		// TODO Auto-generated method stub
		// new RenderableHolder();

		PlayGame_Main.primarystage = primarystage;
		try {
			Parent rootHome = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
			sceneHome = new Scene(rootHome);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Can't load HomePage");
		}
		try {
			Parent rootChooseChar = FXMLLoader.load(getClass().getResource("ChooseChar.fxml"));
			sceneChooseChar = new Scene(rootChooseChar);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Can't load ChooseCharScene");
		}
		try {
			Parent rootChooseMode = FXMLLoader.load(getClass().getResource("ChooseMode.fxml"));
			sceneChooseMode = new Scene(rootChooseMode);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Can't load ChooseModeScene");
		}
		try {
			Parent rootTutorial1 = FXMLLoader.load(getClass().getResource("Tutorial1.fxml"));
			sceneTutorial1 = new Scene(rootTutorial1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Can't load tutorial 1 !!");
		}
		try {
			Parent rootTutorial2 = FXMLLoader.load(getClass().getResource("Tutorial2.fxml"));
			sceneTutorial2 = new Scene(rootTutorial2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Can't load tutorial 2 !!");
		}
		PlayGame_Main.primarystage.setResizable(false);
		PlayGame_Main.primarystage.setTitle("DinoQute");

		// Game

		StackPane rootGame = new StackPane();
		sceneGame = new Scene(rootGame);
		gameScreen = new GameScreen(600, 640);
		rootGame.getChildren().add(gameScreen);
		gameScreen.requestFocus();
		gameScreen.addListener();

		if (isHomeScreen) {
			PlayGame_Main.primarystage.setScene(sceneHome);
		}

		PlayGame_Main.primarystage.show();

		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				if (isHomeScreen) {
					RenderableHolder.homeBGM.setOnEndOfMedia(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							RenderableHolder.homeBGM.seek(Duration.ZERO);
						}

					});
					RenderableHolder.homeBGM.play();
					RenderableHolder.gameBGM.stop();
				} else if (isGameScreen) {
					RenderableHolder.homeBGM.stop();
					RenderableHolder.gameBGM.setOnEndOfMedia(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							RenderableHolder.gameBGM.seek(Duration.ZERO);

						}
					});
					RenderableHolder.gameBGM.play();
					if (RenderableHolder.isPlaying() == true) {
						gameScreen.paintComponent();
						RenderableHolder.getInstance().update();
					} else {
						gameScreen.gameOver();
					}
				}
			}
		};
		animation.start();
	}

	public static void setScene(Scene sc) {
		primarystage.setScene(sc);
	}

	public static void setHomeScreen(boolean isHomeScreen) {
		PlayGame_Main.isHomeScreen = isHomeScreen;
	}

	public static void setGameScreen(boolean isGameScreen) {
		PlayGame_Main.isGameScreen = isGameScreen;
	}

	public static Scene getSceneHome() {
		return sceneHome;
	}

	public static Scene getSceneChooseMode() {
		return sceneChooseMode;
	}

	public static Scene getSceneChooseChar() {
		return sceneChooseChar;
	}

	public static Scene getSceneGame() {
		return sceneGame;
	}

	public static Scene getSceneTutorial1() {
		return sceneTutorial1;
	}

	public static Scene getSceneTutorial2() {
		return sceneTutorial2;
	}

	public static int getCharacter() {
		return character;
	}

	public static void setCharacter(int character) {
		PlayGame_Main.character = character;
	}

	public static int getGameMode() {
		return gameMode;
	}

	public static void setGameMode(int gameMode) {
		PlayGame_Main.gameMode = gameMode;
	}

	public static void main(String[] args) {
		launch(args);
	}

}