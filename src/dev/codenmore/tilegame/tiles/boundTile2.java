package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class boundTile2 extends Tile {

	public boundTile2(int id) {
		super(Assets.bound2,id);
	}
	public boolean isSolid(){
		return true;
	}
}
