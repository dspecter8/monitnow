package sapient.monitnow.fne1.parser;

import sapient.monitnow.fne1.entities.Params.ClipperPossibleInstruction;
import sapient.monitnow.fne1.entities.Params.Direction;

public class ParserData {

	public ParserData(){

	}

	public static boolean parseClipper(String clipper){
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append(Direction.NORTH.getCodeDirection())
			.append("|").append(Direction.SOUTH.getCodeDirection())
			.append("|").append(Direction.EAST.getCodeDirection())
			.append("|").append(Direction.WEST.getCodeDirection());
		return clipper.matches("(\\d+) (\\d+) (" + stringBuilder.toString()+")");
	}
	
	public static boolean parseListInstruction(String instructions){
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append("(").append(ClipperPossibleInstruction.MOOV.getCodeInstruction())
		.append("|").append(ClipperPossibleInstruction.RIGHT.getCodeInstruction())
		.append("|").append(ClipperPossibleInstruction.LEFT.getCodeInstruction())
		.append(")+");

		return instructions.matches(stringBuilder.toString());
	}


	public static boolean parseLawn(String lawn){
		return lawn.matches("(\\d+) (\\d+)");
	}
}