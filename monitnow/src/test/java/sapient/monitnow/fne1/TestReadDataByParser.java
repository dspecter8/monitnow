package sapient.monitnow.fne1;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import sapient.monitnow.fne1.entities.Lawn;
import sapient.monitnow.fne1.entities.PositionMower;
import sapient.monitnow.fne1.entities.Repere;
import sapient.monitnow.fne1.parser.ParserMower;
import sapient.monitnow.fne1.parser.ParserData;
import sapient.monitnow.fne1.entities.Params.Direction;

public class TestReadDataByParser {
	
	//Test Parser Data
	private ParserData ParserData = new ParserData() ;
	
	@Test
	public void ParseData1(){
		assertThat(ParserData.parserMower("")).isFalse();
		assertThat(ParserData.parserMower("1 2 3")).isFalse();
		assertThat(ParserData.parserMower("12N")).isFalse();
		assertThat(ParserData.parserMower("1 2 N")).isTrue();
		assertThat(ParserData.parserMower("1 2 S")).isTrue();
	}
	
	@Test
	public void ParseData2(){
		assertThat(ParserData.parseListInstruction("")).isFalse();
		assertThat(ParserData.parseListInstruction(" ")).isFalse();
		assertThat(ParserData.parseListInstruction("D G")).isFalse();
		assertThat(ParserData.parseListInstruction("GGAAAGADDAN")).isFalse();
		assertThat(ParserData.parseListInstruction("GGAAAG ADDAN")).isFalse();
		assertThat(ParserData.parseListInstruction("DGA")).isTrue();
		assertThat(ParserData.parseListInstruction("GGAAAGADDA")).isTrue();
	}
	
	@Test
	public void ParseData3(){
		assertThat(ParserData.parseLawn("")).isFalse();
		assertThat(ParserData.parseLawn("1 2 3")).isFalse();
		assertThat(ParserData.parseLawn("123")).isFalse();
		assertThat(ParserData.parseLawn("1 2 ")).isFalse();
		assertThat(ParserData.parseLawn("1 2")).isTrue();
		assertThat(ParserData.parseLawn("1 N")).isFalse();
	}
	
	
	// Test parser Clipper
	
	@Test
	public void ParserMower1(){
		ParserMower mower = new ParserMower();
		mower.setInstructions("DGDGA");
		mower.setLawn("50 5");
		mower.setMower("1 2 N");
		assertThat(mower.executeParse()).isTrue();
	}
	@Test
	
	public void ParserMowerKO(){
		ParserMower mower = new ParserMower();
		mower.setInstructions("DGSDGDRTA");
		mower.setMower("1 -2");
		mower.setLawn("1 2 N");
		assertThat(mower.executeParse()).isFalse();
	}
	
	@Test
	public void ParserMowerEmpty(){
		ParserMower mower = new ParserMower();
		assertThat(mower.executeParse()).isFalse();
	}
}
