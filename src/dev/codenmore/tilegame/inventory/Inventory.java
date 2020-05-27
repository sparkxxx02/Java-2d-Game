package dev.codenmore.tilegame.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.EntityManager;
import dev.codenmore.tilegame.entities.creatures.*;
import dev.codenmore.tilegame.entities.statics.Tree;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.Text;
import dev.codenmore.tilegame.items.Item;

public class Inventory {

	private Handler handler;
	private boolean active = false;
	private ArrayList<Item> inventoryItems;
	private Player player;
	private Jet jet;
	private Car car;
	private Boat boat;
	private Bike bike;

	private int i,invX = 64, invY = 48,
			invWidth = 512, invHeight = 384,
			invListCenterX = invX + 171,
			invListCenterY = invY + invHeight / 2 + 5,
			invListSpacing = 30;
	//private EntityManager entitymanager;
	private int invImageX = 452, invImageY = 82,
			invImageWidth = 64, invImageHeight = 64;

	private int invCountX = 484, invCountY = 172;

	private int selectedItem = 0;
	private String entity_name;
	public Inventory(Handler handler){
		this.handler = handler;
		inventoryItems = new ArrayList<Item>();
		addItem(Item.bikeItem.createNew(1));
		addItem(Item.jetItem.createNew(1));
		addItem(Item.carItem.createNew(1));
		addItem(Item.boatItem.createNew(1));
		addItem(Item.player.createNew(1));
	}

	public void tick(){

		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))

			active = !active;

		if(!active)
			return;

		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_W))
			selectedItem--;
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_S))
			selectedItem++;
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER))
		{

			entity_name=inventoryItems.get(selectedItem).getName();
			getNewEntity(entity_name);
			active = !active;


		}
		if(selectedItem < 0)
			selectedItem = inventoryItems.size() - 1;
		else if(selectedItem >= inventoryItems.size())
			selectedItem = 0;
	}

	public void render(Graphics g){

		if(!active)
			return;

		g.drawImage(Assets.inventoryScreen, invX, invY, invWidth, invHeight, null);


		int len = inventoryItems.size();
		if(len == 0)
			return;

		for( i = -5;i < 6;i++){
			if(selectedItem + i < 0 || selectedItem + i >= len)
				continue;
			if(i == 0){
				Text.drawString(g, "> " + inventoryItems.get(selectedItem + i).getName() + " <", invListCenterX, 
						invListCenterY + i * invListSpacing, true, Color.YELLOW, Assets.font28);
			}else{
				Text.drawString(g, inventoryItems.get(selectedItem + i).getName(), invListCenterX, 
						invListCenterY + i * invListSpacing, true, Color.WHITE, Assets.font28);
			}
		}

		Item item = inventoryItems.get(selectedItem);
		g.drawImage(item.getTexture(), invImageX, invImageY, invImageWidth, invImageHeight, null);
		Text.drawString(g, Integer.toString(item.getCount()), invCountX, invCountY, true, Color.WHITE, Assets.font28);

	}

	// Inventory methods

	public void addItem(Item item){
		/*for(Item i : inventoryItems){
			if(i.getId() == item.getId()){
				i.setCount(i.getCount() + item.getCount());
				return;
			}
		}
		 */
		inventoryItems.add(item);
	}
	private void getNewEntity(String entityName) {
		int spawnX=(int)(handler.getGame().getCurrentCreature().getX());
		int spawnY=(int)(handler.getGame().getCurrentCreature().getY());
		if(entityName.equals("Player"))
		{
			handler.getWorld().setEntityManger(new EntityManager(handler, new Player(handler,100,100,player)));
			handler.getWorld().getEntityManager().getPlayer().setX(spawnX);
			handler.getWorld().getEntityManager().getPlayer().setY(spawnY);
		}
		else if(entityName.equals("Jet-Steamer"))
		{
			handler.getWorld().setEntityManger(new EntityManager(handler, new Jet(handler,100,100,jet)));
			handler.getWorld().getEntityManager().getJet().setX(spawnX);
			handler.getWorld().getEntityManager().getJet().setY(spawnY);
			

		}
		else if(entityName.equals("Racing-Car"))
		{
			handler.getWorld().setEntityManger(new EntityManager(handler, new Car(handler,100,100,car)));
			handler.getWorld().getEntityManager().getCar().setX(spawnX);
			handler.getWorld().getEntityManager().getCar().setY(spawnY);
			
		}
		else if(entityName.equals("Rafting-Boat"))
		{
			handler.getWorld().setEntityManger(new EntityManager(handler, new Boat(handler,100,100,boat)));
			handler.getWorld().getEntityManager().getBoat().setX(spawnX);
			handler.getWorld().getEntityManager().getBoat().setY(spawnY);
			
		}
		else if(entityName.equals("Racing-Bike"))
		{
			handler.getWorld().setEntityManger(new EntityManager(handler, new Bike(handler,100,100,bike)));
			handler.getWorld().getEntityManager().getBike().setX(spawnX);
			handler.getWorld().getEntityManager().getBike().setY(spawnY);
			
			//System.exit(1);
		}
		handler.getWorld().getEntityManager().addEntity(new Tree(handler, 100, 250));
	}

	// GETTERS SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public boolean isActive() {
		return active;
	}

}
