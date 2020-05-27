package dev.codenmore.tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.creatures.Bike;
import dev.codenmore.tilegame.entities.creatures.Boat;
import dev.codenmore.tilegame.entities.creatures.Car;
import dev.codenmore.tilegame.entities.creatures.Jet;
import dev.codenmore.tilegame.entities.creatures.Player;

public class Tile {
	
	//STATIC STUFF HERE
	public static Tile t;
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile StoneTile = new stoneTile(1);
	public static Tile FlowerTile = new flowerTile(2);
	public static Tile rockTile = new RockTile(3);
	public static Tile BoundTile = new boundTile(4);
	public static Tile BoundTile2 = new boundTile2(5);
	public static Tile SepTile = new sepTile(6);
	public static Tile dirtTile = new DirtTile(7);
	public static Tile Water = new waterTile(8);
	public static Tile Waterrock = new waterrockTile(9);
	public static Tile Dirtwater = new dirtwaterTile(10);
	public static Tile Roadmiddle = new roadmidTile(11);
	public static Tile RoadFront = new roadfrTile(12);
	public static Tile HurdleTile = new hurdleTile(13);
	public static Tile FinishTile = new finishTile(14);
	//CLASS
	
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int id;
	protected static Handler handler;
	protected static Bike bike;
	protected static Car car;
	protected static Boat boat;
	protected static Jet jet;
	protected static Player player;
	
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		tiles[id] = this;
	}
	

	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public int getId(){
		return id;
	}
	public int getTileid(Tile tile)
	{
		return tile.id;
	}
	
}
