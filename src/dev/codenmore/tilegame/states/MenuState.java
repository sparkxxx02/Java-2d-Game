package dev.codenmore.tilegame.states;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.display.Display;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.ImageLoader;
import dev.codenmore.tilegame.gfx.Music;
import dev.codenmore.tilegame.ui.ClickListener;
import dev.codenmore.tilegame.ui.UIImageButton;
import dev.codenmore.tilegame.ui.UIManager;

public class MenuState extends State {

	private UIManager uiManager;
	private Graphics g1;
	public MenuState(final Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		Music.playMusic("res/music/intro.wav");
		
		//uiManager.addObject(new UIImageButton(0, 0, 1000, 70, Assets.titlescreen));
		
		uiManager.addObject(new UIImageButton((int) 451, (int) 589, 174, 40, Assets.btn_credits, new ClickListener() {
			@Override
			public void onClick() {
				Display d=new Display(handler,"Credits",handler.getWidth(),handler.getHeight());
		
			}
		}));
		uiManager.addObject(new UIImageButton((int) 435, (int) 448, 220, 70, Assets.btn_start, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				Music.stopmusic();
				Music.playMusic("res/music/game.wav");
			}
			
		}));
		
		
		
	}

	@Override
	public void tick() {
		uiManager.tick();
		
	
	}
	
	@Override
	public void render(Graphics g) {
		g1=g;
		g.drawImage(Assets.titlescreen, (int) 0, (int) 0, 1080,720, null);
		uiManager.render(g);
	}
	public Graphics getGraphics()
	{
		return g1;
	}

}
