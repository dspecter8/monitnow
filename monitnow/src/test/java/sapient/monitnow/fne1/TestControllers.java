package sapient.monitnow.fne1;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import sapient.monitnow.fne1.Controller.FormaterLine;
import sapient.monitnow.fne1.Controller.ProcessInstrunction;
import sapient.monitnow.fne1.Exception.ExceptionClipper;
import sapient.monitnow.fne1.entities.Lawn;
import sapient.monitnow.fne1.entities.Repere;
import sapient.monitnow.fne1.entities.Params.ClipperPossibleInstruction;
import sapient.monitnow.fne1.entities.Params.Direction;
import sapient.monitnow.fne1.entities.PositionClipper;

public class TestControllers {

	/*Test Controller FormaterLine*/
	@Test
	public void formaterDataIn1() {
		assertThat(FormaterLine.FormaterLineClipper("12 11 N").getCoordClipper()).isEqualTo(new Repere(12, 11));
		assertThat(FormaterLine.FormaterLineClipper("10 15 S").getDirectionClipper()).isEqualTo(Direction.SOUTH);
	}

	@Test
	public void formaterDataIn2() {
		assertThat(FormaterLine.formaterLineLawn("20 20")).isEqualTo(new Lawn(new Repere(20, 20)));
	}

	@Test
	public void formaterDataIn3() {
		assertThat(FormaterLine.formaterLigneInstruction("DGAD")).hasSize(4)
				.contains(ClipperPossibleInstruction.RIGHT)
				.contains(ClipperPossibleInstruction.LEFT)
				.contains(ClipperPossibleInstruction.MOOV);
	}

	@Test
	public void formaterDataIn4() {
		assertThat(FormaterLine.getDirection('E')).isEqualTo(Direction.EAST);
		assertThat(FormaterLine.getDirection('N')).isEqualTo(Direction.NORTH);
		assertThat(FormaterLine.getDirection('S')).isEqualTo(Direction.SOUTH);
		assertThat(FormaterLine.getDirection('W')).isEqualTo(Direction.WEST);
		assertThat(FormaterLine.getDirection('p')).isNull();
		}

	@Test
	public void formaterDataIn5() {
		
		assertThat(FormaterLine.getInstruction('A')).isEqualTo(ClipperPossibleInstruction.MOOV);
		assertThat(FormaterLine.getInstruction('D')).isEqualTo(ClipperPossibleInstruction.RIGHT);
		assertThat(FormaterLine.getInstruction('G')).isEqualTo(ClipperPossibleInstruction.LEFT);
		assertThat(FormaterLine.getInstruction(' ')).isNull();
	}
	
	/*Test Controller ProcessInstruction*/
	
	@Test
	public void ProcessInstructionTest1() throws ExceptionClipper {
		Repere maxCoord = new Repere(5, 5);
		int x = 2;
		int y = 3;
		Repere repere = new Repere(x, y);
		PositionClipper positionTondeuse  = new  PositionClipper(repere,Direction.SOUTH);
		ProcessInstrunction.executeInstruction(positionTondeuse, ClipperPossibleInstruction.RIGHT, maxCoord);
		assertThat(positionTondeuse.getCoordClipper()).isEqualTo(new Repere(x, y));
		assertThat(positionTondeuse.getDirectionClipper()).isEqualTo(Direction.WEST);
	}
	
	
	@Test
	public void ProcessInstructionTest2() throws ExceptionClipper{
		
		Direction  nextDirection = ProcessInstrunction.rotateRight(Direction.EAST);
		assertThat(nextDirection).isEqualTo(Direction.SOUTH);
		
		nextDirection = ProcessInstrunction.rotateRight(Direction.WEST);
		assertThat(nextDirection).isEqualTo(Direction.NORTH);
		
		nextDirection = ProcessInstrunction.rotateRight(Direction.NORTH);
		assertThat(nextDirection).isEqualTo(Direction.EAST);
		
		nextDirection = ProcessInstrunction.rotateRight(Direction.SOUTH);
		assertThat(nextDirection).isEqualTo(Direction.WEST);
	}
	
	@Test
	public void ProcessInstructionTest3() throws ExceptionClipper{
		Direction nextDirection = ProcessInstrunction.rotateLeft(Direction.EAST);
		assertThat(nextDirection).isEqualTo(Direction.NORTH);
		
		nextDirection = ProcessInstrunction.rotateLeft(Direction.WEST);
		assertThat(nextDirection).isEqualTo(Direction.SOUTH);
		
		nextDirection = ProcessInstrunction.rotateLeft(Direction.NORTH);
		assertThat(nextDirection).isEqualTo(Direction.WEST);
		
		nextDirection = ProcessInstrunction.rotateLeft(Direction.SOUTH);
		assertThat(nextDirection).isEqualTo(Direction.EAST);
	}
	
	
	

}
