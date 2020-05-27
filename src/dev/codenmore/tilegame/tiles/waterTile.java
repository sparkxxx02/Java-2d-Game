package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class waterTile extends Tile {

	public waterTile(int id) {
		super(Assets.water, id);
	}
	public boolean isSolid()
	{
		return true;
			
	}

}
