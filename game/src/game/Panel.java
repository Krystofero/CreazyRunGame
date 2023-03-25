//package game;
//
//import java.awt.event.KeyListener;
//import java.awt.image.BufferedImage;
//import java.util.ArrayList;
//import java.util.Random;
//
//import javax.swing.JPanel;
//
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.Rectangle;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//
//import javax.swing.Timer;
//
//public class Panel extends JPanel implements ActionListener, KeyListener {
//	
//	private Timer time;
//	
//	BufferedImage image;
//	
//	public Random rand;
//	
////	public Image character;
//	public Rectangle character;
//	
//	public ArrayList<Rectangle> columns;
//
//	public int ticks, yMotion, score;
//
//	public boolean gameOver, started , continueFly = true;
//
//	
//	public Panel() {
//		Timer timer = new Timer(20, this); //wszystko wykonuje siê w 20 milisekund 
//		rand = new Random();	
//		this.addKeyListener(this);
//		
//		
//		character = new Rectangle(WIDTH / 2 - 400, HEIGHT - 150, 20, 20); //tworzê postaæ na pocz¹tku gry
////		character = new ImageIcon("img/__jet_pack_man_now_weapon_flying.png").getImage();
//		columns = new ArrayList<Rectangle>();
//
//		addColumn(true);
//		addColumn(true);
//		addColumn(true);
//		addColumn(true);
//		
//		
//		//addMissile(true);
//		//addBluePill(true);
//		//addRedPill(true);
//		//addVioletPill(true);
//		//addTimeSlowmo(true);
//		
//		
//		timer.start();
//	}
//	
//	
//	public void addColumn(boolean start)
//	{
//		int space = 300;	//odstêp miêdzy kolumnami(przestrzeñ miêdzy górn¹ a doln¹)
//		int width = 100;	//szerokoœæ kolumn
//		int height = 50 + rand.nextInt(300); // kolumny pojawiaj¹ siê nad ziemi¹ ale o losowej wysokoœci
//
//		if (start)
//		{
//			columns.add(new Rectangle(WIDTH + width + columns.size() * 300, HEIGHT - height - 120, width, height)); // pierwsze dwa argumenty to pozycja w oknie (w jakiej szerokoœci Frame'a siê tworz¹, w jakiej wysokiœci Frame'a siê tworz¹, prostok¹ty o jakiej szerokoœci, prostok¹ty o jakiej wysokoœci)
//			columns.add(new Rectangle(WIDTH + width + (columns.size() - 1) * 300, 0, width, HEIGHT - height - space));
//		}
//		else
//		{
//			columns.add(new Rectangle(columns.get(columns.size() - 1).x + 600, HEIGHT - height - 120, width, height));
//			columns.add(new Rectangle(columns.get(columns.size() - 1).x, 0, width, HEIGHT - height - space));
//		}
//	}
//	
//	public void paintColumn(Graphics g, Rectangle column)
//	{
//		g.setColor(Color.green.darker());
//		g.fillRect(column.x, column.y, column.width, column.height); //uzupe³nia wnêtrze i rysuje prostok¹t
//	}
//
//	public void jump()
//	{
//		if (gameOver) // aby resetowaæ po³o¿enie gracza do stanu pocz¹tkowego w przypadku pora¿ki
//		{
//			character = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
//			columns.clear();
//			yMotion = 0;
//			score = 0;
//
//			addColumn(true);
//			addColumn(true);
//			addColumn(true);
//			addColumn(true);
//
//			gameOver = false;
//		}
//
//		if (!started) //aby rozpoczynaæ grê gdy wywo³amy jump() np porzez kllikniêcie
//		{
//			started = true;
//		}
//		else if (!gameOver)
//		{
//			if (yMotion < 0)		//(yMotion > 0)
//			{
//				yMotion = 0;
//			}
//
//			yMotion -= 10;	//zmiana po³o¿enia - ruch po osi y wiêc w górê lub w dó³(odejmujê wiêc w górê)
//		}
//	}
//
//	
//	@Override
//	public void actionPerformed(ActionEvent e)
//	{
//		int speed = 10; //ustalona szybkoœæ
//
//		ticks++;
//
//		if (started)
//		{
//			for (int i = 0; i < columns.size(); i++)	//pojawiaj¹ siê kolumny z okreœlon¹ szybkoœci¹
//			{
//				Rectangle column = columns.get(i);
//
//				column.x -= speed;	//zmiana po³o¿enia - ruch po osi x wiêc w lewo lub w prawo (odejmujê wiêc w lewo)
//			}
//
//			if (ticks % 2 == 0 && yMotion < 15) //postaæ bêdzie spadaæ przy sta³ej prêdkoœci
//			{
//				yMotion += 1.82; 	//z jakim tempem spada postaæ
////				if(character.y == HEIGHT) {
////					yMotion = 0;
////				}
//			}
//
//			for (int i = 0; i < columns.size(); i++)
//			{
//				Rectangle column = columns.get(i);
//
//				if (column.x + column.width < 0)
//				{
//					columns.remove(column); //usuwa kolumny jak wyjd¹ w lewo poza ramkê
//
//					if (column.y == 0)
//					{
//						addColumn(false);
//					}
//				}
//			}
//
//			character.y += yMotion; //dodajê do ruch po osi y dla postaci(spadek)
//
//			for (Rectangle column : columns)
//			{
//				if (column.y == 0 && character.x + character.width / 2 > column.x + column.width / 2 - 10 && character.x + character.width / 2 < column.x + column.width / 2 + 10)  //dzielê na dwa aby nie nabija³o podwójnie punktów tylko 1 punkt przy tym jak postaæ min¹ 2 kolumny(górn¹ i doln¹)
//				{
//					score++;
//				}
//
//				if (column.intersects(character)) //jak kolumna i charakter siê zde¿¹ koniec gry
//				{
//					gameOver = true;
//
//					if (character.x <= column.x)
//					{
//						character.x = column.x - character.width; //aby postaæ przy zderzeniu zatrzyma³a siê na kolumnie
//
//					}
//					else
//					{
//						if (column.y != 0)
//						{
//							character.y = column.y - character.height; //aby postaæ np. przy zderzeniu z kolumn¹ górn¹ - od œrodka w górê, nie przeniknê³a przez kolumnê pod wzglêdem wysokoœci
//						}
//						else if (character.y < column.height)
//						{
//							character.y = column.height; //aby postaæ np. przy zderzeniu z kolumn¹ doln¹ - od œrodka w dó³, nie przeniknê³a przez kolumnê pod wzglêdem wysokoœci
//						}
//					}
//				}
//				
//			}
//
//			if (character.y > HEIGHT - 120 || character.y < 0) //jak postaæ wyleci za wysoko koniec gry i bezw³adnie opada na ziemie
//			{
//				character.y = 0 ;	//aby nie przekraczaæ sufitu w jetpacku
//			//	gameOver = true;
//			}
//
//			if (character.y + yMotion >= HEIGHT - 130) //jak postaæ dotknie ziemi to pozostaje na jej wysokoœci , koniec gry   ,(w jetpacku biegnie)
//			{
//				character.y = HEIGHT - 120 - character.height;
//				yMotion = 5;  // moment skoku (if jak siê styka z ziemia to skacze - daje animacje ze skoku) (jak dotyka ziemi jest animacja biegu)
////				if (gameOver)	//jak zginie to siê powoli zatrzymuje w miejscu
////				{
////					yMotion = 5;
////
////				}
//				//Postaæ biegnie run()
//								//jak postaæ zginie natrafiaj¹c na przeszkodê:
////				if (gameOver)	//jak zginie to siê powoli zatrzymuje w miejscu
////				{
////					character.x -= speed;
////				}
//			//	character.x -= speed; //aby postaæ pozosta³a w miejscu œmierci (mogê to jeszcze podzieliæ np. prze 1.2 albo coœ dodaæ aby lekko naturalnie siê przesunê³a do przodu - z si³¹ rozpêdu) 
//			//	gameOver = true;
//			}
//		}
//
//		renderer.repaint();
//	}
//
//	public void repaint(Graphics g)
//	{	//t³o
//		g.setColor(Color.cyan);			
//		g.fillRect(0, 0, WIDTH, HEIGHT);
//		//ziemia
//		g.setColor(Color.orange);
//		g.fillRect(0, HEIGHT - 120, WIDTH, 120);
//		//pod³oga
//		g.setColor(Color.green);
//		g.fillRect(0, HEIGHT - 120, WIDTH, 20);
//		//postaæ
//		g.setColor(Color.red);
//		g.fillRect(character.x, character.y, character.width, character.height);
//		//kolumny
//		for (Rectangle column : columns)
//		{
//			paintColumn(g, column);
//		}
//		//napisy
//		g.setColor(Color.white);
//		g.setFont(new Font("Arial", 1, 100)); 
//
//		if (!started)
//		{
//			g.drawString("Click to start!", 75, HEIGHT / 2 - 50);
//		}
//
//		if (gameOver)
//		{
//			g.drawString("Game Over!", 100, HEIGHT / 2 - 50);
//		}
//
//		if (!gameOver && started)
//		{
//			g.drawString(String.valueOf(score), WIDTH / 2 - 25, 100);
//		}
//	}
//
//	
//	
//	
//	
//	
//	
//	@Override
//	public void keyPressed(KeyEvent e)
//	{
//		if(continueFly) {
//			if (e.getKeyCode() == KeyEvent.VK_SPACE)
//			{	//yMotion = 0;  // moment skoku (if jak siê styka z ziemia to skacze - daje animacje ze skoku) (jak dotyka ziemi jest animacja biegu)
//				jump();
//			}
//		}
//	}
//
//	@Override
//	public void keyReleased(KeyEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void keyTyped(KeyEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	
//	
//	
//}
