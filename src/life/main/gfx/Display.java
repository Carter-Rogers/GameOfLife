package life.main.gfx;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

public class Display extends Canvas{

	public static final long serialVersionUID = 1L;
	
	protected int width, height;
	
	private BufferedImage image;
	private int[] pixels;
	
	public Display(int width, int height) {
		this.width = width;
		this.height = height;
		this.setFocusable(true);
		this.setPreferredSize(new Dimension(width, height));
		
		this.image = new BufferedImage(width/4, height/4, BufferedImage.TYPE_INT_RGB);
		this.pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
		
		JFrame window = new JFrame();
		window.add(this, BorderLayout.CENTER);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(3);
		window.setVisible(true);
	}
	
	Bitmap2D map = new Bitmap2D(160, 120);
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(2);
			return;
		}
		
		map.render();
		map.copyToDest(pixels);
		
		Graphics g = bs.getDrawGraphics();
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		g.dispose();
		bs.show();
	}
	
}
