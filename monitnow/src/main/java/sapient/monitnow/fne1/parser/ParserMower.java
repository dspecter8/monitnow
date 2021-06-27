package sapient.monitnow.fne1.parser;

public class ParserMower {

	private String lawn ;
	private String mower ;
	private String instructions ;

	public ParserMower() {
		super();
	}
	

	public ParserMower(String lawn, String mower, String instructions) {
		super();
		this.lawn = lawn;
		this.mower = mower;
		this.instructions = instructions;
	}

	public boolean executeParse(){
		return ParserData.parserMower(mower)
				&& ParserData.parseLawn(lawn)
				&& ParserData.parseListInstruction(instructions);
	}
	
	
	public String getLawn() {
		return lawn;
	}


	public void setLawn(String lawn) {
		this.lawn = lawn;
	}


	public String getMower() {
		return mower;
	}


	public void setMower(String mower) {
		this.mower = mower;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}


	public String getInstructions() {
		return instructions;
	}
	
	
}