package dev.codenmore.tilegame.tiles;

import java.awt.image.BufferedImage;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.display.Display;
import dev.codenmore.tilegame.gfx.Assets;

public class finishTile extends Tile {

	public finishTile(int id) {
		super(Assets.finish, id);
		
	}
	public boolean isSolid(){
		end();
		return false;
		
	}
	private void end() {
		Display.frame.dispose();
		if(Game.geti() < 40)
			new Display(handler,"Victory",1080,720);
		else
			new Display(handler,"Lose", 1080,720);
		Game.stop();
	}
}
