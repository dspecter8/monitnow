package sapient.monitnow.fne1.Controller;

import java.util.ArrayList;
import java.util.List;

import sapient.monitnow.fne1.entities.Lawn;
import sapient.monitnow.fne1.entities.Params.MowerPossibleInstruction;
import sapient.monitnow.fne1.entities.Params.Direction;
import sapient.monitnow.fne1.entities.PositionMower;
import sapient.monitnow.fne1.entities.Repere;

public class FormaterLine {

	private static final String SPACE = " ";

	private FormaterLine(){

	}


	public static PositionMower FormaterLineMower(String lineMower){
		String[] elts = lineMower.split(SPACE);
		Repere coorMower = new Repere(Integer.valueOf(elts[0]), Integer.valueOf(elts[1]));
		Direction directionMower = getDirection(elts[2].charAt(0));
		return new PositionMower(coorMower, directionMower);
	}

	
	public static Lawn formaterLineLawn(String lawn){
		String[] elts = lawn.split(SPACE);
		return new Lawn(new Repere(Integer.valueOf(elts[0]), Integer.valueOf(elts[1])));
	}

	public static List<MowerPossibleInstruction> formaterLigneInstruction(String instructionElts){
		List<MowerPossibleInstruction> listInstruction = new ArrayList<MowerPossibleInstruction>();
		for(char instruction :instructionElts.toCharArray()){
			listInstruction.add(getInstruction(instruction));
		}
		return listInstruction;
	}

	public static Direction getDirection(char cDirection){
		for(Direction direction : Direction.values()) {
			if (direction.getCodeDirection() == cDirection){
				return direction;
			}
		}
		return null;
	}

	
	public static MowerPossibleInstruction getInstruction(char cInstruction){
		for(MowerPossibleInstruction instruction : MowerPossibleInstruction.values()) {
			if (instruction.getCodeInstruction() == cInstruction) {
				return instruction;
			}
		}
		return null;
	}
}