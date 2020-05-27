package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class hurdleTile extends Tile {

	public hurdleTile(int id) {
		super(Assets.hurdle, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}
