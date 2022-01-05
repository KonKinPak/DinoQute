package entity;

import application.PlayGame_Main;
import entity.base.Entity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sharedobject.Irenderable;
import sharedobject.RenderableHolder;

public class Snake extends Entity implements Irenderable {

	public Snake(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub

		double width = 30;
		double height = 30;
		if (RenderableHolder.getInstance().isLeft() == true) {
			width *= -1;
		}
		if (RenderableHolder.getInstance().isDown() == true) {
			width *= -1;
		}
		double offX = width * 0.5 * -1;
		double offY = height * 0.5;
		Image image = RenderableHolder.allSnakeImage.get(PlayGame_Main.getCharacter());
		gc.drawImage(image, getX() + offX, getY() + offY, width, height);
	}
}