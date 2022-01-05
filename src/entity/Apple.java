package entity;

import java.util.Random;

import entity.base.Entity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sharedobject.Irenderable;
import sharedobject.RenderableHolder;

public class Apple extends Entity implements Irenderable {
	private Image eachApple;

	public Apple(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		Random rand = new Random();
		int random = rand.nextInt(5);
		eachApple = RenderableHolder.allAppleImage.get(random);
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(this.eachApple, getX() - 15, getY() + 15, 30, 30);
	}
}
