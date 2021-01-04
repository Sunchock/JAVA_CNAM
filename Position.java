/** Définir une position.  */
public class Position {
	public int x;
	public int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override public String toString() {
		return super.toString() + "(" + x + "," + y + ")";
	}
 
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Position)
			return (this.x == ((Position) obj).x && this.y == ((Position) obj).y);
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
