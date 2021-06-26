package sapient.monitnow.fne1.parser;

public class ParserClipper {

	private String lawn ;
	private String clipper ;
	private String instructions ;

	public ParserClipper() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public ParserClipper(String lawn, String clipper, String instructions) {
		super();
		this.lawn = lawn;
		this.clipper = clipper;
		this.instructions = instructions;
	}

	public boolean executeParse(){
		return ParserData.parseClipper(clipper)
				&& ParserData.parseLawn(lawn)
				&& ParserData.parseListInstruction(instructions);
	}
	
	
	public String getLawn() {
		return lawn;
	}


	public void setLawn(String lawn) {
		this.lawn = lawn;
	}


	public String getClipper() {
		return clipper;
	}


	public void setClipper(String clipper) {
		this.clipper = clipper;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
}