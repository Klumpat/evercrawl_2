package gfx;

public class Sprite extends Bitmap {

	private static int ID_COUNT = -1;
	private final int ID;
	
	public Sprite(int width, int height, int color){
		super(width, height);
		ID_COUNT++;
		ID = ID_COUNT;
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				pix[x + y * width] = color;

			}
		}
	}

	public Sprite(int width, int height, int xS, int yS, Bitmap sheet) {
		super(width, height);
		ID_COUNT++;
		ID = ID_COUNT;

		int spriteY = yS * height;
		int spriteX = xS * width;

		// System.out.println("xs:" + xS + " ys:" + yS + " spriteY:" + spriteY +
		// " spriteX:" +spriteX);

		for (int y = 0; y < height; y++) {
			int yp = y + spriteY;
			for (int x = 0; x < width; x++) {
				int xp = x + spriteX;
				pix[x + y * width] = sheet.pix[xp + yp * sheet.getWidth()];

			}
		}

	}
	
	public Sprite(Bitmap bitmap){
		super(bitmap.width, bitmap.height);
		ID_COUNT++;
		ID = ID_COUNT;
		for(int i = 0; i<pix.length;i++){
			
			this.pix[i] = bitmap.pix[i];
		}
		
	}

	public Sprite(int width, int height, int xS, int yS, Bitmap sheet, boolean meh) {
		super(width, height);
		ID_COUNT++;
		ID = ID_COUNT;

		int spriteY = yS;
		int spriteX = xS;

		// System.out.println("xs:" + xS + " ys:" + yS + " spriteY:" + spriteY +
		// " spriteX:" +spriteX);

		for (int y = 0; y < height; y++) {
			int yp = y + spriteY;
			for (int x = 0; x < width; x++) {
				int xp = x + spriteX;
				pix[x + y * width] = sheet.pix[xp + yp * sheet.getWidth()];

			}
		}

	}

	public int getID() {
		return this.ID;
	}

}
