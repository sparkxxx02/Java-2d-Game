package dev.codenmore.tilegame.display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.Music;

public class Display {

	public static JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width, height;
	private Handler handler;
	public Display(Handler handler,String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
		this.handler=handler;
		createDisplay();
	}
	
	private void createDisplay(){
		
		frame = new JFrame(title);
		frame.setSize(width, height);
		if(title == "Credits")
		{
			BufferedImage img=Assets.creditsscreen;
			JLabel bckgrnd= new JLabel(new ImageIcon(img));
			frame.getContentPane().add(bckgrnd);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		}
		else if(title == "Victory")
		{
			Music.stopmusic();
			Music.playMusic("res/music/win.wav");
			BufferedImage img= Assets.victory;
			int Result= Game.geti();
			JLabel label=new JLabel(new ImageIcon(img));
			//label.setAlignmentX(534);
			//label.setAlignmentY(453);
			
			frame.getContentPane().add(label);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		else if(title == "Lose")
		{
			Music.stopmusic();
			Music.playMusic("res/music/lose.wav");
			BufferedImage img= Assets.lose;
			int Result= Game.geti();
			JLabel label=new JLabel(new ImageIcon(img));
			//label.setAlignmentX(534);
			//label.setAlignmentY(453);
			frame.getContentPane().add(label);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		else
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(1366, 768));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		frame.add(canvas);
		
		
		frame.pack();
	}

	public Canvas getCanvas(){
		return canvas;
	}
	
	public  JFrame getFrame(){
		return frame;
	}
	
}
