package dev.codenmore.tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Animation;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.inventory.Inventory;

public class Player extends Creature {

	//Animations
	private Animation animDown, animUp, animLeft, animRight,animjumpr,animjumpl;
	public static int count=0;
	private Creature creature;
	private Inventory inventory;



	public Player(Handler handler, float x, float y,Creature creature) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT,creature);

		bounds.x = 22;
		bounds.y = 44;
		bounds.width = 19;
		bounds.height = 19;
		
		//Animatons
		animDown = new Animation(100, Assets.player_down);
		animUp = new Animation(100, Assets.player_up);
		animLeft = new Animation(100, Assets.player_left);
		animRight = new Animation(100, Assets.player_right);
		animjumpr = new Animation(100, Assets.player_jumpr);
		animjumpl = new Animation(100, Assets.player_jumpl);
		inventory = new Inventory(handler);
		setCreature(creature);

	}


	public void tick() {
		//Animations
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		animjumpr.tick();
		animjumpl.tick();
		//Movement				
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);

		// Inventory
		inventory.tick();
	}

	private void getInput(){
		xMove = 0;
		yMove = 0;
		if(inventory.isActive())
			return;

		if(count==-1 || count ==1)
		{
			yMove+=20*speed;
			count=0;
		}
		if(handler.getKeyManager().left)
		{
			xMove = -speed;
		}
		if(handler.getKeyManager().right)
		{
			xMove = speed;
		}
		if(handler.getKeyManager().up)
		{
			yMove = -speed-speed/2;
		}
		if(handler.getKeyManager().down)
		{
			yMove = speed+speed/2;
		}
		if((handler.getKeyManager().jump) && handler.getKeyManager().left )
		{
			xMove = -speed;
			yMove-=20*speed;
			count=-1;

		}
		if((handler.getKeyManager().jump) && handler.getKeyManager().right )
		{
			xMove = speed;
			yMove-=20*speed;
			count=1;

		}



	}


	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
												(int) (y - handler.getGameCamera().getyOffset()),
												width, height, null);

		//		g.setColor(Color.red);
		//		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
		//				(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
		//				bounds.width, bounds.height);
	}

	private BufferedImage getCurrentAnimationFrame(){
		if(count==1){
			return animjumpr.getCurrentFrame();
		}
		else if( count==-1){
			return animjumpl.getCurrentFrame();
		}
		else if(xMove < 0){
			return animLeft.getCurrentFrame();
		}else if(xMove > 0){
			return animRight.getCurrentFrame();
		}
		else if(yMove < 0  ){
			return animUp.getCurrentFrame();
		}
		else{
			return animDown.getCurrentFrame();
		}
	}
	public void die(){
		System.out.println("You lose");
	}
	public void postRender(Graphics g){
		inventory.render(g);
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	public Creature getCreature() {
		return creature;
	}


	public void setCreature(Creature creature) {
		this.creature = creature;
	}


}
