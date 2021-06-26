package sapient.monitnow.fne1.entities;

public class Repere {
	
	private int x;
	private int y;
	
	public Repere(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	public boolean isOutMaxRepere(Repere coord){
		return coord.getX() >= 0 
				&& coord.getY() >= 0
				&& coord.getX() <= this.x
				&& coord.getY() <= this.y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}


	@Override
	public int hashCode() {
		final int bonus = 31;
		int res = 1;
		res = bonus * res + x;
		res = bonus * res + y;
		return res;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Repere other = (Repere) obj;
		if (x != other.x || y != other.y)
			return false;
		
		return true;
	}
}