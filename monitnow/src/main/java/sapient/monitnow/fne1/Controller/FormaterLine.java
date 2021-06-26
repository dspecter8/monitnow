package sapient.monitnow.fne1.Controller;

import java.util.ArrayList;
import java.util.List;

import sapient.monitnow.fne1.entities.Lawn;
import sapient.monitnow.fne1.entities.Params.ClipperPossibleInstruction;
import sapient.monitnow.fne1.entities.Params.Direction;
import sapient.monitnow.fne1.entities.PositionClipper;
import sapient.monitnow.fne1.entities.Repere;

public class FormaterLine {

	private static final String SPACE = " ";

	private FormaterLine(){

	}


	public static PositionClipper FormaterLineClipper(String lineClippser){
		String[] elts = lineClippser.split(SPACE);
		Repere coorClipper = new Repere(Integer.valueOf(elts[0]), Integer.valueOf(elts[1]));
		Direction directionClipper = getDirection(elts[2].charAt(0));
		return new PositionClipper(coorClipper, directionClipper);
	}

	
	public static Lawn formaterLineLawn(String lawn){
		String[] elts = lawn.split(SPACE);
		return new Lawn(new Repere(Integer.valueOf(elts[0]), Integer.valueOf(elts[1])));
	}

	public static List<ClipperPossibleInstruction> formaterLigneInstruction(String instructionElts){
		List<ClipperPossibleInstruction> listInstruction = new ArrayList<ClipperPossibleInstruction>();
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

	
	public static ClipperPossibleInstruction getInstruction(char cInstruction){
		for(ClipperPossibleInstruction instruction : ClipperPossibleInstruction.values()) {
			if (instruction.getCodeInstruction() == cInstruction) {
				return instruction;
			}
		}
		return null;
	}
}