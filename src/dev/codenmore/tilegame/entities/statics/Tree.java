package dev.codenmore.tilegame.entities.statics;

import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.tiles.Tile;

public class Tree extends StaticEntity {

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH*2, Tile.TILEHEIGHT*2);
		
		bounds.x = 10;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width ;
		bounds.height = (int) (height);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height + 50, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

}
