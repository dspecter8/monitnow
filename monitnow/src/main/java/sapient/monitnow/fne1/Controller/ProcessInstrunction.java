package sapient.monitnow.fne1.Controller;

import sapient.monitnow.fne1.Exception.ExceptionClipper;
import sapient.monitnow.fne1.entities.Params;
import sapient.monitnow.fne1.entities.Params.ClipperPossibleInstruction;
import sapient.monitnow.fne1.entities.Params.Direction;
import sapient.monitnow.fne1.entities.PositionClipper;
import sapient.monitnow.fne1.entities.Repere;

public  class ProcessInstrunction {

	private ProcessInstrunction(){

	}
	
	public static Repere moovClipper(PositionClipper posClipper, Repere coordonnesMax) throws ExceptionClipper{
		Repere nextCoord = null;
		int x, y;
		switch (posClipper.getDirectionClipper()) {
		case NORTH:
			x = posClipper.getCoordClipper().getX();
			y = posClipper.getCoordClipper().getY() + 1;
			break;
		case EAST:
			x = posClipper.getCoordClipper().getX() + 1;
			y = posClipper.getCoordClipper().getY();
			break;
		case SOUTH:
			x = posClipper.getCoordClipper().getX();
			y = posClipper.getCoordClipper().getY() - 1;
			break;
		case WEST:
			x = posClipper.getCoordClipper().getX() - 1;
			y = posClipper.getCoordClipper().getY();
			break;
		default:
			throw new ExceptionClipper(Params.ERROR_POSITION);
		}
		nextCoord = new Repere(x, y);
		
		if (nextCoord != null
				&& coordonnesMax.isOutMaxRepere(nextCoord)) {
			return nextCoord;
		} else {
			return posClipper.getCoordClipper();
		}
	}
	
	
	public static Direction rotateRight(Direction direction) throws ExceptionClipper{
		Direction nextDirection = null ;
		switch (direction){
			case NORTH : 
				nextDirection =  direction.EAST;
				break;
			case EAST : 
				nextDirection =  Direction.SOUTH;
				break;
			case SOUTH : 
				nextDirection =  Direction.WEST;
				break;
			case WEST : 
				nextDirection =  Direction.NORTH;
				break;
			default : 
				throw new ExceptionClipper(Params.ERROR_DIRECTEION);
		}
		return nextDirection;		
	}
	
	
	public static Direction rotateLeft(Direction direction) throws ExceptionClipper{
		Direction nextDirection = null ;
		switch (direction){
			case NORTH : 
				nextDirection =  Direction.WEST; 
				break;
			case EAST : 
				nextDirection =  Direction.NORTH; 
				break;
			case SOUTH : 
				nextDirection =  Direction.EAST; 
				break;
			case WEST : 
				nextDirection =  Direction.SOUTH; 
				break;
			default : 
				throw new ExceptionClipper(Params.ERROR_DIRECTEION);
		}
		return nextDirection;		
	}

	public static void executeInstruction(PositionClipper positionTondeuse, ClipperPossibleInstruction instruction,Repere coordonnesMax) throws ExceptionClipper{
		
		switch (instruction){
			case MOOV : 
				positionTondeuse.setCoordClipper(ProcessInstrunction.moovClipper(positionTondeuse, coordonnesMax)); 
				break;
			case RIGHT : 
				positionTondeuse.setDirectionClipper(ProcessInstrunction.rotateRight(positionTondeuse.getDirectionClipper())); 
				break;
			case LEFT : 
				positionTondeuse.setDirectionClipper(ProcessInstrunction.rotateLeft(positionTondeuse.getDirectionClipper())); 
				break;
			default: throw new ExceptionClipper(Params.ERROR_INSTRUCTION);
		}
	}
}