package utilityClasses;

import gameFolder.GameInfo;

import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/*
 *  this seems like an odd way to go about this.
 *  I'd expect something more like GuiUtil.centerText(String text, Graphics2D g).
 *  Or just use a JLabel and set its horizontal alignment.
 */
public class CenteredText {

	public static void draw(String text, int yVal, Graphics2D g) {

		int width = Window.WIDTH;
		int height = Window.HEIGHT;
		
		FontMetrics fontInfo = g.getFontMetrics();
		int textWidth = fontInfo.stringWidth(text);
		int textHeight = fontInfo.getHeight();

		int x = (width - textWidth) / 2;
		int y = (height - textHeight) / 2;
		
		g.drawString(text, x, yVal);

	}
	
	public static void draw(String text, Rectangle r, Graphics2D g) {

		FontMetrics fontInfo = g.getFontMetrics();
		int textWidth = fontInfo.stringWidth(text);
		int textHeight = fontInfo.getHeight();

		int x = r.x + (r.width - textWidth) / 2;
		int y = r.y + (r.height - textHeight) / 2;
		
		g.drawString(text, x, y);

	}
	
	public static void draw(String text, int yVal, Graphics2D g, int fontSize) {

		int width = Window.WIDTH;
		int height = Window.HEIGHT;
		
		g.setFont(CustomFont.makeCustomFont(GameInfo.FONT_FILE, fontSize));
		
		FontMetrics fontInfo = g.getFontMetrics();
		int textWidth = fontInfo.stringWidth(text);
		int textHeight = fontInfo.getHeight();

		int x = (width - textWidth) / 2;
		int y = (height - textHeight) / 2;
		
		g.drawString(text, x, yVal);

	}
	
	public static void draw(String text, Rectangle r, Graphics2D g, int fontSize) {

		g.setFont(CustomFont.makeCustomFont(GameInfo.FONT_FILE, fontSize));
		
		FontMetrics fontInfo = g.getFontMetrics();
		int textWidth = fontInfo.stringWidth(text);
		int textHeight = fontInfo.getHeight();

		int x = r.x + (r.width - textWidth) / 2;
		int y = r.y + (r.height - textHeight) / 2;
		
		g.drawString(text, x, y);

	}
	
	

}
