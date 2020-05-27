package dev.codenmore.tilegame.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.creatures.Bike;
import dev.codenmore.tilegame.entities.creatures.Boat;
import dev.codenmore.tilegame.entities.creatures.Car;
import dev.codenmore.tilegame.entities.creatures.Jet;
import dev.codenmore.tilegame.entities.creatures.Player;

public class EntityManager {
	
	private Handler handler;
	public Player player;
	private Jet jet;
	private Car car;
	private Bike bike;
	private Boat boat;
	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>(){
		public int compare(Entity a, Entity b) {
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
				return -1;
			return 1;
		}
	};
	
	public EntityManager(Handler handler, Car car){
		this.handler = handler;
		this.car = car;
		entities = new ArrayList<Entity>();
		addEntity(car);
		handler.getGame().setCurrentCreature(car);

	}
	public EntityManager(Handler handler, Bike bike){
		this.handler = handler;
		this.bike = bike;
		entities = new ArrayList<Entity>();
		addEntity(bike);
		handler.getGame().setCurrentCreature(bike);

	}
	public EntityManager(Handler handler, Boat boat){
		this.handler = handler;
		this.boat = boat;
		entities = new ArrayList<Entity>();
		addEntity(boat);
		handler.getGame().setCurrentCreature(boat);

	}
	public EntityManager(Handler handler, Jet jet){
		this.handler = handler;
		this.jet = jet;
		entities = new ArrayList<Entity>();
		addEntity(jet);
		handler.getGame().setCurrentCreature(jet);

	}
	public EntityManager(Handler handler, Player player){
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		addEntity(player);
		handler.getGame().setCurrentCreature(player);
	}
	
	
	public void tick(){
		Iterator<Entity> it = entities.iterator();
		while(it.hasNext()){
			Entity e = it.next();
			e.tick();
			if(!e.isActive())
				it.remove();
		}
		entities.sort(renderSorter);
	}
	
	public void render(Graphics g){
		for(Entity e : entities){
			e.render(g);
		}
		 handler.getGame().getCurrentCreature().postRender(g);
		//jet.postRender(g);
	}
	
	public void addEntity(Entity e){
		entities.add(e);
	}
	

	//GETTERS SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}
	
	/*public void setPlayer(Player player) {
		this.player = player;
	}
	*/
	public ArrayList<Entity> getEntities() {
		return entities;
	}
	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	public Entity getJet() {
		return jet;
	}
	public Entity getCar() {
		return car;
	}
	public Entity getBike() {
		return bike;
	}
	public Entity getBoat() {
		return boat;
	}
	
	
	
}
