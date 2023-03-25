package game;

import java.awt.Graphics;
import java.awt.Image;


import java.io.File;
import java.io.IOException;
//
import javax.imageio.ImageIO;

import javax.swing.JPanel;

public class Renderer extends JPanel
{

	private static final long serialVersionUID = 1L;
	
	public Image background;	
	public Image dog;
	public Image przeszkoda1;
	public Image ground;
	public Image floor;
	public Image sufit;
	public Image missle;
	public Image spike;
//	public Image missle0, missle1, missle2, missle3, missle4, missle5, missle6;
	
	int x, y;
	

	public Renderer() {
		try {
			background = ImageIO.read(new File("img/BackDrop.png"));
			dog = ImageIO.read(new File("img/icondog.png"));
			przeszkoda1 = ImageIO.read(new File("img/zapper.png"));
			ground =  ImageIO.read(new File("img/color.png"));
			floor = ImageIO.read(new File("img/floor2.png"));
			sufit = ImageIO.read(new File("img/bottom_tile.png"));
			missle = ImageIO.read(new File("img/drop-3.png"));
			spike =  ImageIO.read(new File("img/long_metal_spike.png"));
//			missle0 = ImageIO.read(new File("img/missile_0.png"));
//			missle1 = ImageIO.read(new File("img/missile_1.png"));
//			missle2 = ImageIO.read(new File("img/missile_2.png"));
//			missle3 = ImageIO.read(new File("img/missile_3.png"));
//			missle4 = ImageIO.read(new File("img/missile_4.png"));
//			missle5 = ImageIO.read(new File("img/missile_5.png"));
//			missle6 = ImageIO.read(new File("img/missile_6.png"));
			
		} catch (IOException e) {
			System.out.println("Brak pliku");
		}		
	}	
	
	public int getX(Image image) {
		
		return x;
	}		
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawImage(background, 0, 0, this);
		g.drawImage(dog, 0, 0, this);
		
		
		CrazyRun.creazyRun.repaint(g);
		
	}
	
}