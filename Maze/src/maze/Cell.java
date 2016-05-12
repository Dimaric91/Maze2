package maze;

public class Cell {
	private static int maskLEFT = 8;
	private static int maskUP = 4;
	private static int maskRIGHT = 2;
	private static int maskDOWN = 1;
	
	int contentMask;
	int x;
	int y;
	
	public Cell(int x, int y) {
		this(x, y, maskLEFT + maskUP + maskRIGHT + maskDOWN);
	}
	
	Cell(int x, int y,int contentMask) {
		this.x = x;
		this.y = y;
		this.contentMask = contentMask;
	}
	
	public boolean isLeft() {
		return (contentMask & maskLEFT) != 0;
	}
	
	public boolean isRight() {
		return (contentMask & maskRIGHT) != 0;
	}
	
	public boolean isUp() {
		return (contentMask & maskUP) != 0;
	}
	
	public boolean isDown() {
		return (contentMask & maskDOWN) != 0;
	}
	
	public void removeLeft() {
		contentMask ^= maskLEFT;
	}
	
	public void removeUp() {
		contentMask ^= maskUP;
	}
	
	public void removeRight() {
		contentMask ^= maskRIGHT;
	}
	
	public void removeDown() {
		contentMask ^= maskDOWN;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}
	
	
	@Override
	public String toString() {
		return getX() + " , " + getY();
	}
}
