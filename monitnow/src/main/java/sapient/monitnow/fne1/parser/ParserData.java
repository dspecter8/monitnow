package sapient.monitnow.fne1.parser;

import sapient.monitnow.fne1.entities.Params.MowerPossibleInstruction;
import sapient.monitnow.fne1.entities.Params.Direction;

public class ParserData {

	public ParserData(){
		super();
	}

	public static boolean parserMower(String mover){
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append(Direction.NORTH.getCodeDirection())
			.append("|").append(Direction.SOUTH.getCodeDirection())
			.append("|").append(Direction.EAST.getCodeDirection())
			.append("|").append(Direction.WEST.getCodeDirection());
		return mover.matches("(\\d+) (\\d+) (" + stringBuilder.toString()+")");
	}
	
	public static boolean parseListInstruction(String instructions){
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append("(").append(MowerPossibleInstruction.GO.getCodeInstruction())
		.append("|").append(MowerPossibleInstruction.RIGHT.getCodeInstruction())
		.append("|").append(MowerPossibleInstruction.LEFT.getCodeInstruction())
		.append(")+");

		return instructions.matches(stringBuilder.toString());
	}


	public static boolean parseLawn(String lawn){
		return lawn.matches("(\\d+) (\\d+)");
	}
}