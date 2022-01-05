package sharedobject;

import java.util.ArrayList;
import java.util.Random;

import entity.Apple;
import entity.Obstacle;
import entity.Snake;
import exception.appleSpawnOnMeException;
import exception.obstacleSpawnOnMeException;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();

	public static ArrayList<Image> allSnakeImage;
	public static ArrayList<Image> allAppleImage;
	public static ArrayList<Image> allObstacleImage;

	private ArrayList<Snake> snakeArr;
	private ArrayList<Apple> appleArr;
	private ArrayList<Obstacle> obstacleArr;

	public static Image snake0;
	public static Image snake1;
	public static Image snake2;
	public static Image snake3;

	public static Image snakeNaruto0; // snake4
	public static Image snakeNaruto1; // snake5
	public static Image snakeNaruto2; // snake6
	public static Image snakeNaruto3; // snake7

	public static Image appleImage;
	public static Image appleImage1;
	public static Image appleImage2;
	public static Image appleImage3;
	public static Image appleImage4;

	public static Image obstacle0;
	public static Image obstacle1;
	public static Image obstacle2;
	public static Image obstacle3;

	public static Image backGround;
	public static Image dinoDie;

	public static AudioClip eating;
	public static AudioClip die;
	public static AudioClip mouseClick;

	public static MediaPlayer homeBGM;
	public static MediaPlayer gameBGM;

	private static int point = 0;
	private static int length = 1;

	private Snake snake;
	private Apple apple;
	private Obstacle obstacle;

	private static int timeLag = 0; // action when timeLag == speed
	private int friction = 15; // more friction less speed

	private static int countToSpawn = 0; // spawn obstacle when count == period
	private static int period = 100; // time to spawn obstacle (frequency of spawn obstacle)

	private static int countToDestroy = 0; // destroy obstacle when countToDestroy == lifeOfObstacle
	private static int lifeOfObstacle = 300; // time to destroy obstacle

	private boolean right = true;
	private boolean left = false;
	private boolean up = false;
	private boolean down = false;
	private static boolean playing = true;
	private static boolean obstacleOn = false;

	private static int x, xa, xo; // x = snake-x ** xa = apple-x ** xo = obstacle-x
	private static int y, ya, yo; // y = snake-y ** ya = apple-y ** yo = obstacle-y

	public RenderableHolder() {
		snakeArr = new ArrayList<Snake>();
		appleArr = new ArrayList<Apple>();
		obstacleArr = new ArrayList<Obstacle>();
	}

	static {
		loadResource();
	}

	public static void loadResource() {
		allSnakeImage = new ArrayList<Image>();
		snake0 = new Image(ClassLoader.getSystemResource("snake0.gif").toString());
		snake1 = new Image(ClassLoader.getSystemResource("snake1.gif").toString());
		snake2 = new Image(ClassLoader.getSystemResource("snake2.gif").toString());
		snake3 = new Image(ClassLoader.getSystemResource("snake3.gif").toString());

		snakeNaruto0 = new Image(ClassLoader.getSystemResource("snakeNaruto0.gif").toString()); // snake4
		snakeNaruto1 = new Image(ClassLoader.getSystemResource("snakeNaruto1.gif").toString()); // snake5
		snakeNaruto2 = new Image(ClassLoader.getSystemResource("snakeNaruto2.gif").toString()); // snake6
		snakeNaruto3 = new Image(ClassLoader.getSystemResource("snakeNaruto3.gif").toString()); // snake7

		dinoDie = new Image(ClassLoader.getSystemResource("dinoDie.gif").toString());
		allSnakeImage.add(snake0);
		allSnakeImage.add(snake1);
		allSnakeImage.add(snake2);
		allSnakeImage.add(snake3);
		allSnakeImage.add(snakeNaruto0); // snake4 (0+4)
		allSnakeImage.add(snakeNaruto1); // snake5 (1+4)
		allSnakeImage.add(snakeNaruto2); // snake6 (2+4)
		allSnakeImage.add(snakeNaruto3); // snake7 (3+4)

		allAppleImage = new ArrayList<Image>();
		appleImage = new Image(ClassLoader.getSystemResource("apple.png").toString());
		appleImage1 = new Image(ClassLoader.getSystemResource("apple1.png").toString());
		appleImage2 = new Image(ClassLoader.getSystemResource("apple2.png").toString());
		appleImage3 = new Image(ClassLoader.getSystemResource("apple3.png").toString());
		appleImage4 = new Image(ClassLoader.getSystemResource("apple4.png").toString());
		allAppleImage.add(appleImage);
		allAppleImage.add(appleImage1);
		allAppleImage.add(appleImage2);
		allAppleImage.add(appleImage3);
		allAppleImage.add(appleImage4);

		allObstacleImage = new ArrayList<Image>();
		obstacle0 = new Image(ClassLoader.getSystemResource("obstacle0.gif").toString());
		obstacle1 = new Image(ClassLoader.getSystemResource("obstacle1.gif").toString());
		obstacle2 = new Image(ClassLoader.getSystemResource("obstacle2.gif").toString());
		obstacle3 = new Image(ClassLoader.getSystemResource("obstacle3.gif").toString());
		allObstacleImage.add(obstacle0);
		allObstacleImage.add(obstacle1);
		allObstacleImage.add(obstacle2);
		allObstacleImage.add(obstacle3);

		eating = new AudioClip(ClassLoader.getSystemResource("eating.wav").toString());
		die = new AudioClip(ClassLoader.getSystemResource("die.wav").toString());
		mouseClick = new AudioClip(ClassLoader.getSystemResource("mouseClick.wav").toString());
		backGround = new Image(ClassLoader.getSystemResource("bg.png").toString());

		homeBGM = getAudio("HomeBGM.mp3");
		gameBGM = getAudio("GameBGM.mp3");
	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public ArrayList<Snake> getSnakeArr() {
		return snakeArr;
	}

	public void setSnakeArr(ArrayList<Snake> snakeArr) {
		this.snakeArr = snakeArr;
	}

	public ArrayList<Obstacle> getObstacleArr() {
		return obstacleArr;
	}

	public void setObstacleArr(ArrayList<Obstacle> obstacleArr) {
		this.obstacleArr = obstacleArr;
	}

	public ArrayList<Apple> getAppleArr() {
		return appleArr;
	}

	public void setAppleArr(ArrayList<Apple> appleArr) {
		this.appleArr = appleArr;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public void setPoint(int point) {
		RenderableHolder.point = point;
	}

	public void setFriction(int friction) {
		this.friction = friction;
	}

	public static boolean isPlaying() {
		return playing;
	}

	public static boolean isObstacleOn() {
		return obstacleOn;
	}

	public static void setObstacleOn(boolean obstacleOn) {
		RenderableHolder.obstacleOn = obstacleOn;
	}

	public static void letsPlaying() {
		playing = true;
	}

	public void stop() { // snake die
		length = 1;
		right = true;
		left = false;
		up = false;
		down = false;
		snakeArr = new ArrayList<Snake>();
		appleArr = new ArrayList<Apple>();
		obstacleArr = new ArrayList<Obstacle>();
		playing = false;
		die.play();
	}

	public void update() {
		if (snakeArr.size() == 0) { // start game
			x = 300;
			y = 340;
			snake = new Snake(x, y);
			snakeArr.add(snake);
		}
		Thread t = new Thread(() -> {
			try { // spawn apple
				if (appleArr.size() == 0) { // start game && after eating apple
					spawnApple();
				}
			} catch (appleSpawnOnMeException e) {
				spawnAppleCorrection();
			}
			if (appleArr.get(0).getX() == x && appleArr.get(0).getY() == y) { // eating apple
				snakeEating();
			}
		});
		t.start();

		if (obstacleOn) {
			countToSpawn++; // spawn obstacle
		}
		if (countToSpawn > period) {
			Thread t2 = new Thread(() -> {
				try { // spawn obstacle
					if (obstacleArr.size() <= 2) {
						spawnObstacle();
					}
				} catch (obstacleSpawnOnMeException e) {
					spawnObstacleCorrection();
				}
				countToSpawn = 0;
			});
			t2.start();
		}

		if (obstacleOn) {
			countToDestroy++; // destroy obstacle
		}
		if (countToDestroy > lifeOfObstacle) {
			if (obstacleArr.size() != 0) {
				destroyObstacle();
			}
			countToDestroy = 0;
		}
		for (int i = 0; i < obstacleArr.size(); i++) { // hitting obstacle
			if (x == obstacleArr.get(i).getX() && y == obstacleArr.get(i).getY()) {
				stop();
				break;
			}
		}
		while (true) {
			if (t.getState() == Thread.State.TERMINATED) {
				break;
			} else {
			}
		}
		for (int i = 0; i < snakeArr.size(); i++) { // eating itself
			if (x == snakeArr.get(i).getX() && y == snakeArr.get(i).getY() && i != snakeArr.size() - 1) {
				// not checking at head of snake
				stop();
				break;
			}
		}
		if (x > 600 || y > 640 || x < 0 || y < 40) { // out of bound
			stop();
		}
		timeLag++; // moving
		if (timeLag > friction) {
			if (right) {
				x += 30;
			}
			if (left) {
				x -= 30;
			}
			if (down) {
				y += 30;
			}
			if (up) {
				y -= 30;
			}
			timeLag = 0;
			snake = new Snake(x, y);
			snakeArr.add(snake);
			if (snakeArr.size() > length) { // always true
				snakeArr.remove(0); // remove tail
			}
		}

	}

	public void snakeEating() {
		length += 1;
		appleArr.remove(0);
		eating.play();
		point++;
	}

	public void spawnApple() throws appleSpawnOnMeException {
		Random rand = new Random();
		xa = rand.nextInt(20);
		ya = rand.nextInt(20);
		xa *= 30;
		ya *= 30;
		ya += 40; // + score bar
		for (Snake s : snakeArr) {
			if (xa == s.getX() && ya == s.getY()) { // apple spawn in body of snake?
				throw new appleSpawnOnMeException();
			}
		}
		for (Obstacle o : obstacleArr) {
			if (xo == o.getX() && yo == o.getY()) { // apple spawn in obstacle
				throw new appleSpawnOnMeException();
			}
		}
		apple = new Apple(xa, ya);
		appleArr.add(apple);

	}

	public void spawnAppleCorrection() {
		Random rand = new Random();
		boolean ok1 = false; // check whether spawn in snake is ok?
		boolean ok2 = false; // check whether spawn in obstacle is ok?
		xa = rand.nextInt(20);
		ya = rand.nextInt(20);
		xa *= 30;
		ya *= 30;
		ya += 40;
		while (!(ok1 && ok2)) { // not ok
			xa = rand.nextInt(20);
			ya = rand.nextInt(20);
			xa *= 30;
			ya *= 30;
			ya += 40;
			for (Snake s : snakeArr) {
				if (xa == s.getX() && ya == s.getY()) { // apple spawn in body of snake?
					// new random and check again
					ok1 = false;
					break;
				} else {
					ok1 = true;
				}
			}
			for (Obstacle s : obstacleArr) {
				if (ok1 == false) {
					break;
				}
				if (xa == s.getX() && ya == s.getY()) { // apple spawn in obstacle?
					// new random and check again
					ok2 = false;
					break;
				} else {
					ok2 = true;
				}
			}
		}
		apple = new Apple(xa, ya);
		appleArr.add(apple);
	}

	public void spawnObstacle() throws obstacleSpawnOnMeException {
		Random rand = new Random();
		xo = rand.nextInt(20);
		yo = rand.nextInt(20);
		xo *= 30;
		yo *= 30;
		yo += 40; // + score bar
		for (Snake s : snakeArr) {
			if (xo == s.getX() && yo == s.getY()) { // obstacle spawn in body of snake?
				throw new obstacleSpawnOnMeException();
			}
		}
		for (Obstacle o : obstacleArr) {
			if (xo == o.getX() && yo == o.getY()) { // obstacle spawn in body of snake?
				throw new obstacleSpawnOnMeException();
			}
		}
		for (Apple a : appleArr) {
			if (xo == a.getX() && yo == a.getY()) { // obstacle spawn in apple?
				throw new obstacleSpawnOnMeException();
			}
		}
		obstacle = new Obstacle(xo, yo);
		obstacleArr.add(obstacle);
	}

	public void spawnObstacleCorrection() {
		Random rand = new Random();
		boolean ok1 = false; // check whether spawn is ok?
		boolean ok2 = false;
		boolean ok3 = false;
		xo = rand.nextInt(20);
		yo = rand.nextInt(20);
		xo *= 30;
		yo *= 30;
		yo += 40;
		while (!(ok1 && ok2 && ok3)) { // not ok
			xo = rand.nextInt(20);
			yo = rand.nextInt(20);
			xo *= 30;
			yo *= 30;
			yo += 40;
			for (Snake s : snakeArr) {
				if (xo == s.getX() && yo == s.getY()) { // obstacle spawn in body of snake?
					// new random and check again
					ok1 = false;
					break;
				} else {
					ok1 = true;
				}
			}
			for (Obstacle s : obstacleArr) {
				if (ok1 == false) {
					break;
				}
				if (xo == s.getX() && yo == s.getY()) { // obstacle spawn in obstacle
					// new random and check again
					ok2 = false;
					break;
				} else {
					ok2 = true;
				}
			}
			for (Apple s : appleArr) {
				if (ok1 == false || ok2 == false) {
					break;
				}
				if (xo == s.getX() && yo == s.getY()) { // obstacle spawn in apple
					// new random and check again
					ok3 = false;
					break;
				} else {
					ok3 = true;
				}
			}
		}
		obstacle = new Obstacle(xo, yo);
		obstacleArr.add(obstacle);
	}

	public void destroyObstacle() {
		obstacleArr.remove(0);
	}

	public boolean isRight() {
		return right;
	}

	public boolean isLeft() {
		return left;
	}

	public boolean isUp() {
		return up;
	}

	public boolean isDown() {
		return down;
	}

	public static int getPoint() {
		return point;
	}

	private static MediaPlayer getAudio(String directory) {
		MediaPlayer player;
		Media pick;
		try {
			String audio_path = ClassLoader.getSystemResource(directory).toString();
			pick = new Media(audio_path);
			player = new MediaPlayer(pick);
		} catch (Exception e) {
			player = null;
			System.out.println("Media Error " + directory);
		}
		return player;
	}

}
