package life.main.gfx;

public class Bitmap {

	private int width, height;
	protected int[] pixels;

	public Bitmap(int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = new int[width * height];
	}
	
	public void drawMap(Bitmap map, int xOff, int yOff) {
		for(int y = 0; y < map.height; y++) {
			for(int x = 0; x < map.width; x++) {
				int color = map.pixels[x + y * map.width];
				pixels[(x + xOff) + (y + yOff) * width] = color;
			}
		}
	}
	
	public int copyToDest(int[] target) {
		if(target.length <= pixels.length) {
			
			for(int y = 0; y < height; y++) {
				for(int x = 0; x < width; x++) {
					int indexLen = x + y * width;
					if(indexLen >= target.length)
						break;
					else
						target[indexLen] = pixels[indexLen];
				}
			}
		
			return 1;
		}else {
			for(int y = 0; y < height; y++) {
				for(int x = 0; x < width; x++) {
					target[x + y * width] = pixels[x + y * width];
				}
			}
			
			return 1;
		}
	}
	
}
