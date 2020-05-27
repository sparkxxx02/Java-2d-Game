package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class waterrockTile extends Tile {

	public waterrockTile(int id) {
		super(Assets.water_rock, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}
