package sapient.monitnow.fne1.entities;

import sapient.monitnow.fne1.entities.Params.Direction;

/*
 * Position de la tondeuse
 */
public class PositionClipper {
	
	private Repere coordClipper;
	private Params.Direction directionClipper;

	
	
	public PositionClipper(Repere coordClipper, Direction directionClipper) {
		super();
		this.coordClipper = coordClipper;
		this.directionClipper = directionClipper;
	}


	public Repere getCoordClipper() {
		return coordClipper;
	}


	public void setCoordClipper(Repere coordClipper) {
		this.coordClipper = coordClipper;
	}


	public Params.Direction getDirectionClipper() {
		return directionClipper;
	}


	public void setDirectionClipper(Params.Direction directionClipper) {
		this.directionClipper = directionClipper;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordClipper == null) ? 0 : coordClipper.hashCode());
		result = prime * result + ((directionClipper == null) ? 0 : directionClipper.hashCode());
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
		PositionClipper other = (PositionClipper) obj;
		if (coordClipper == null) {
			if (other.coordClipper != null)
				return false;
		} else if (!coordClipper.equals(other.coordClipper))
			return false;
		if (directionClipper != other.directionClipper)
			return false;
		return true;
	}
}