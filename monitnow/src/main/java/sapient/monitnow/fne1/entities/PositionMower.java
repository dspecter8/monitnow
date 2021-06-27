package sapient.monitnow.fne1.entities;

import sapient.monitnow.fne1.entities.Params.Direction;

/*
 * Position de la tondeuse
 */
public class PositionMower {
	
	private Repere coordMower;
	private Params.Direction directionMower;

	
	
	public PositionMower(Repere coordMower, Direction directionMower) {
		super();
		this.coordMower = coordMower;
		this.directionMower = directionMower;
	}


	public Repere getCoordMower() {
		return coordMower;
	}


	public void setCoordMower(Repere coordClipper) {
		this.coordMower = coordClipper;
	}


	public Params.Direction getDirectionMower() {
		return directionMower;
	}


	public void setDirectionMower(Params.Direction directionClipper) {
		this.directionMower = directionClipper;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordMower == null) ? 0 : coordMower.hashCode());
		result = prime * result + ((directionMower == null) ? 0 : directionMower.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PositionMower other = (PositionMower) obj;
		if (coordMower == null) {
			if (other.coordMower != null)
				return false;
		} else if (!coordMower.equals(other.coordMower))
			return false;
		if (directionMower != other.directionMower)
			return false;
		return true;
	}
}