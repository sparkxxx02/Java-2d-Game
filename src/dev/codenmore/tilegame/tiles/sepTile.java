package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class sepTile  extends Tile {

	public sepTile(int id) {
		super(Assets.sep, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}
