package sapient.monitnow.fne1.Controller;

import sapient.monitnow.fne1.Exception.ExceptionMower;
import sapient.monitnow.fne1.entities.Params;
import sapient.monitnow.fne1.entities.Params.MowerPossibleInstruction;
import sapient.monitnow.fne1.entities.Params.Direction;
import sapient.monitnow.fne1.entities.PositionMower;
import sapient.monitnow.fne1.entities.Repere;

public  class ProcessInstrunction {

	private ProcessInstrunction(){

	}
	
	public static Repere moovMower(PositionMower posMower, Repere coordonnesMax) throws ExceptionMower{
		Repere nextCoord = null;
		int x, y;
		switch (posMower.getDirectionMower()) {
		case NORTH:
			x = posMower.getCoordMower().getX();
			y = posMower.getCoordMower().getY() + 1;
			break;
		case EAST:
			x = posMower.getCoordMower().getX() + 1;
			y = posMower.getCoordMower().getY();
			break;
		case SOUTH:
			x = posMower.getCoordMower().getX();
			y = posMower.getCoordMower().getY() - 1;
			break;
		case WEST:
			x = posMower.getCoordMower().getX() - 1;
			y = posMower.getCoordMower().getY();
			break;
		default:
			throw new ExceptionMower(Params.ERROR_POSITION);
		}
		nextCoord = new Repere(x, y);
		
		if (nextCoord != null
				&& coordonnesMax.isOutMaxRepere(nextCoord)) {
			return nextCoord;
		} else {
			return posMower.getCoordMower();
		}
	}
	
	
	public static Direction rotateRight(Direction direction) throws ExceptionMower{
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
				throw new ExceptionMower(Params.ERROR_DIRECTION);
		}
		return nextDirection;		
	}
	
	
	public static Direction rotateLeft(Direction direction) throws ExceptionMower{
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
				throw new ExceptionMower(Params.ERROR_DIRECTION);
		}
		return nextDirection;		
	}

	public static void executeInstruction(PositionMower posMower, MowerPossibleInstruction instruction,Repere coordonnesMax) throws ExceptionMower{
		
		switch (instruction){
			case GO : 
				posMower.setCoordMower(ProcessInstrunction.moovMower(posMower, coordonnesMax)); 
				break;
			case RIGHT : 
				posMower.setDirectionMower(ProcessInstrunction.rotateRight(posMower.getDirectionMower())); 
				break;
			case LEFT : 
				posMower.setDirectionMower(ProcessInstrunction.rotateLeft(posMower.getDirectionMower())); 
				break;
			default: throw new ExceptionMower(Params.ERROR_INSTRUCTION);
		}
	}
}