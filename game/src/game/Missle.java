package game;

import java.awt.Image;
import java.awt.Rectangle;

public class Missle { //extends MainCharacter{
	
	private int X, Y, width, height;
	private Image image;
	public Rectangle character;
	
	public Missle(int x, int y, int width, int height, Image image) {
		super();
		this.X = x;
		this.Y = y;
		this.width = width;
		this.height = height;
		this.image = image;
		this.character = new Rectangle(x, y+5, width-45, height-20);
	}
	public int getX() {
		return X;
	}
	public void setX(int x) {
		X = x;
		this.character.x = x;
	}
	public int getY() {
		return Y;
	}
	public void setY(int y) {
		Y = y;
		this.character.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
		character.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
		character.height = height;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
}
