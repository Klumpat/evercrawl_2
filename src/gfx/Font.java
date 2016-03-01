package gfx;

public class Font {

	private Bitmap fontSheet;
	private Sprite[] sprites;
	private int fontSize;

	private String charSet = "ä!\"#$%&´()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz";

	public Font(Bitmap sheet, int fontSize) {
		this.fontSize = fontSize;
		this.fontSheet = sheet;
		int w = sheet.getWidth();
		int h = sheet.getHeight();
		int sh = h / fontSize;
		int sw = w / fontSize;
		sprites = new Sprite[sh * sw];
		System.out.println("Font has: " + sprites.length + " Characters");
		for (int y = 0; y < sh; y++) {
			for (int x = 0; x < sw; x++) {
				sprites[x + y * sw] = new Sprite(fontSize, fontSize, x, y, fontSheet);
			}
		}
	}
	
	public int getFontSize(){
		return fontSize;
	}

	public char getCharsetAt(int i) {
		return charSet.charAt(i);
	}
	
	public String getCharset(){
		return charSet;
	}

	public Bitmap getCharSprite(int charIndex) {
		return sprites[charIndex];
	}

}
