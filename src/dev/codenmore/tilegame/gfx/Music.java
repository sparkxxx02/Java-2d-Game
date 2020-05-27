package dev.codenmore.tilegame.gfx;

import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {
	static Clip clip;
		public static void stopmusic()
		{
			clip.stop();
		}
		public static void playMusic(String filepath)
		{
			
			File musicpath= new File(filepath);
			try
			{
				if(musicpath.exists())
					{
						AudioInputStream audio= AudioSystem.getAudioInputStream(musicpath);
					
						clip=AudioSystem.getClip();
						clip.open(audio);
						clip.start();
						clip.loop(Clip.LOOP_CONTINUOUSLY);
					}
				else
				{
					System.out.println("Cant load file");
				}
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
}
