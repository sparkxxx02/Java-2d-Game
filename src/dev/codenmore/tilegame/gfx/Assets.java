package dev.codenmore.tilegame.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32, starting_index =77;
	public static Font font28;

	public static BufferedImage dirt, grass, stone, tree, rock,flowers,sep,water,water_rock
	,dirt_water, road_middle, road_front,boundaries,bound2,hurdle;
	public static BufferedImage[] btn_start;
	public static BufferedImage[] btn_credits;
	public static BufferedImage wood,finish,victory,lose;
	public static BufferedImage titlescreen=ImageLoader.loadImage("/textures/TITLE.jpg");
	public static BufferedImage creditsscreen=ImageLoader.loadImage("/textures/CREDITS.jpg");
	public static BufferedImage inventoryScreen;
	public static BufferedImage[] player_down, player_up, player_left, player_right,player_jumpr,player_jumpl;
	public static BufferedImage boat_l[],bike_l[],car_l[],jet_l[],boat_r[],bike_r[],car_r[],jet_r[],nitro_l[],nitro_r[];

	public static void init(){
		font28 = FontLoader.loadFont("res/fonts/slkscr.ttf", 28);
		
		SpriteSheet sheet20 = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		inventoryScreen = ImageLoader.loadImage("/textures/inventoryScreen.png");
		SpriteSheet BikeL=new SpriteSheet(ImageLoader.loadImage("/textures/bike_left.png"));
		SpriteSheet BikeR=new SpriteSheet(ImageLoader.loadImage("/textures/bike_right.png"));
		SpriteSheet NitroL=new SpriteSheet(ImageLoader.loadImage("/textures/left_nitro.png"));
		SpriteSheet NitroR=new SpriteSheet(ImageLoader.loadImage("/textures/right_nitro.png"));

		wood = sheet20.crop(width, height, width, height);
		
		btn_start = new BufferedImage[2];
		btn_credits=new BufferedImage[2];
		boat_l = new BufferedImage[1];
		boat_r = new BufferedImage[1];
		jet_l = new BufferedImage[1];
		jet_r = new BufferedImage[1];
		car_l = new BufferedImage[1];
		car_r = new BufferedImage[1];
		bike_l = new BufferedImage[1];
		bike_r = new BufferedImage[1];
		nitro_l=new BufferedImage[3];
		nitro_r=new BufferedImage[3];
		finish= ImageLoader.loadImage("/textures/finish.png");
		victory= ImageLoader.loadImage("/textures/victory.png");
		lose= ImageLoader.loadImage("/textures/lose.png");
		btn_start[0] = ImageLoader.loadImage("/textures/start.jpg");
		btn_start[1] = ImageLoader.loadImage("/textures/start_h.jpg");
	  btn_credits[0] = ImageLoader.loadImage("/textures/des.jpg");
	  btn_credits[1] = ImageLoader.loadImage("/textures/des_h.jpg");
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/background.png"));
		SpriteSheet stand = new SpriteSheet(ImageLoader.loadImage("/textures/standing.png"));
		SpriteSheet left_runn1 = new SpriteSheet(ImageLoader.loadImage("/textures/leftrun.png"));
		SpriteSheet left_runn2 = new SpriteSheet(ImageLoader.loadImage("/textures/leftrun2.png"));
		SpriteSheet right_running = new SpriteSheet(ImageLoader.loadImage("/textures/cpu player.png"));
		SpriteSheet jumpright = new SpriteSheet(ImageLoader.loadImage("/textures/cpu jump.png"));
		SpriteSheet jumpleft = new SpriteSheet(ImageLoader.loadImage("/textures/jumpleft.png"));
		SpriteSheet road = new SpriteSheet(ImageLoader.loadImage("/textures/road.jpg"));
		SpriteSheet carL= new SpriteSheet(ImageLoader.loadImage("/textures/car_left.png"));
		SpriteSheet carR= new SpriteSheet(ImageLoader.loadImage("/textures/car_right.png"));
		
		bike_l[0]=BikeL.crop(94, 0, 179-94, 42);
		bike_r[0]=BikeR.crop(71, 0, 158-71,44);
		jet_l[0]=ImageLoader.loadImage("/textures/jet_left.png");
		jet_r[0]=ImageLoader.loadImage("/textures/jet_right.png");
		car_l[0]=carL.crop(83,80,316-83,174-80);
		car_r[0]=carR.crop(0,120,600,340-120);
		boat_l[0]=ImageLoader.loadImage("/textures/boat_left.png");
		boat_r[0]=ImageLoader.loadImage("/textures/boat_right.png");
		
		player_down = new BufferedImage[1];
		player_up = new BufferedImage[1];
		player_left = new BufferedImage[2];
		player_right = new BufferedImage[2];
		player_jumpr= new BufferedImage[4];
		player_jumpl= new BufferedImage[4];
		
		player_left[0] = left_runn1.crop(0, 233,677, 792);
		player_left[1] = left_runn2.crop(940, 750,685,740);
		
		
		player_right[0] = right_running.crop(0, 34, 180, 220-34);
		player_right[1] = right_running.crop(360, 60, 520-360, 230-60);
		
		
		player_down[0] = stand.crop(760, 761, 752, 1255);
		player_up[0] = stand.crop(760, 761, 752, 1255);
		
		player_jumpr[0] = jumpright.crop(250, 0, 230, 250);
		player_jumpr[1] = jumpright.crop(0, 250, 230,250);
		player_jumpr[2] = jumpright.crop(525, 250, 230, 250);
		player_jumpr[3] = jumpright.crop(750, 250, 230, 250);
		
		player_jumpl[0] = jumpleft.crop(260, 0, 230, 240);
		player_jumpl[1] = jumpleft.crop(760, 260, 230,240);
		player_jumpl[2] = jumpleft.crop(500, 260, 230, 240);
		player_jumpl[3] = jumpleft.crop(0, 260, 230, 240);
		
		nitro_l[0]= NitroL.crop(143, 62, 301-143, 97-62);
		nitro_l[1]= NitroL.crop(143, 102, 301-143, 137-102);
		nitro_l[2]= NitroL.crop(143, 142, 301-143, 177-142);

		nitro_r[0]= NitroR.crop(135, 500, 289-135, 542-500);
		nitro_r[1]= NitroR.crop(135, 452, 289-135, 500-452);		
		nitro_r[2]= NitroR.crop(135, 409, 289-135, 450-409);

		dirt = sheet.crop(372, 34, 399-372, 62-34);
		water = sheet.crop(372, 232, 400-372, 260-232);
		dirt_water = sheet.crop(306,133, 334-306, 161-133);
		water_rock = sheet.crop(339,265, 367-339, 293-265);
		road_middle = road.crop(258,36, 485-258, 120-36);
		road_front = road.crop(75,100, 162-75, 324-100);
		grass = sheet.crop(starting_index+width-1, width+3, 136-108, 62-32);
		flowers = sheet.crop(75,232,103-75,260-232);
		stone = sheet.crop(141,199,169-141,226-199);
		tree = sheet.crop(0, 103, 68, 187-103);
		sep = sheet.crop(75,300,103-75,327-300);
		rock = sheet.crop(starting_index+(width*3), 0, width, height);
		boundaries = sheet.crop(438,232,466-438,260-232);
		bound2 = sheet.crop(471,232,500-471,260-232);
		hurdle = sheet.crop(273,265,301-273,293-265);
	}
	
}
