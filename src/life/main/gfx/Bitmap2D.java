package life.main.gfx;

import java.util.Random;

public class Bitmap2D extends Bitmap {
	private Bitmap map;
	
	public Bitmap2D(int width, int height) {
		super(width, height);
		map = new Bitmap(width, height);
		Random r = new Random();
		for(int i = 0; i < map.pixels.length; i++)
			map.pixels[i] = r.nextInt();
	}
	
	public void render() {
		for(int i = 0; i < pixels.length; i++)
			pixels[i] = 0x0;
		
		drawMap(map, 0, 0);
	}
	
}