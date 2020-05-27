package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class boundTile extends Tile {

	public boundTile(int id) {
		super(Assets.boundaries, id);
	}
	public boolean isSolid(){
		return true;
	}
}
