package sapient.monitnow.fne1;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import sapient.monitnow.fne1.entities.Lawn;
import sapient.monitnow.fne1.entities.PositionClipper;
import sapient.monitnow.fne1.entities.Repere;
import sapient.monitnow.fne1.parser.ParserClipper;
import sapient.monitnow.fne1.parser.ParserData;
import sapient.monitnow.fne1.entities.Params.Direction;

public class TestReadDataByParser {
	
	//Test Parser Data
	private ParserData ParserData = new ParserData() ;
	
	@Test
	public void ParseData1(){
		assertThat(ParserData.parseClipper("")).isFalse();
		assertThat(ParserData.parseClipper("1 2 3")).isFalse();
		assertThat(ParserData.parseClipper("12N")).isFalse();
		assertThat(ParserData.parseClipper("1 2 N")).isTrue();
		assertThat(ParserData.parseClipper("1 2 S")).isTrue();
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
	ParserClipper clipper = new ParserClipper();
	@Test
	public void ParserClipper1(){
		
		clipper.setInstructions("DGDGA");
		clipper.setLawn("50 5");
		clipper.setClipper("1 2 N");
		assertThat(clipper.executeParse()).isTrue();
	}
	@Test
	
	public void ParserClipperKO(){
		clipper.setInstructions("DGDGA");
		clipper.setClipper("0 -1");
		clipper.setLawn("1 2 N");
		assertThat(clipper.executeParse()).isFalse();
	}
	
	@Test
	public void ParserClipperEmpty(){
		assertThat(clipper.executeParse()).isFalse();
	}
}
