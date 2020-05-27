package dev.codenmore.tilegame.states;

import java.awt.Graphics;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Music;
import dev.codenmore.tilegame.worlds.World;

public class GameState extends State {
	
	private World world;
	private int count;
	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		count = 1;
		
	}
	



	public void tick() {
		if(count == 1)
			{
				handler.getGame().seti(0);
				count =2;
			}
		world.tick();
	}
	

	
	public void render(Graphics g) {
		
		world.render(g);
	}

}
