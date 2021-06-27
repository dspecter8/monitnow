package sapient.monitnow.fne1;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import sapient.monitnow.fne1.Controller.FormaterLine;
import sapient.monitnow.fne1.Controller.ProcessInstrunction;
import sapient.monitnow.fne1.Exception.ExceptionMower;
import sapient.monitnow.fne1.entities.Lawn;
import sapient.monitnow.fne1.entities.Repere;
import sapient.monitnow.fne1.entities.Params.MowerPossibleInstruction;
import sapient.monitnow.fne1.entities.Params.Direction;
import sapient.monitnow.fne1.entities.PositionMower;

public class TestControllers {

	/*Test Controller FormaterLine*/
	@Test
	public void formaterDataIn1() {
		assertThat(FormaterLine.FormaterLineMower("12 11 N").getCoordMower()).isEqualTo(new Repere(12, 11));
		assertThat(FormaterLine.FormaterLineMower("10 15 S").getDirectionMower()).isEqualTo(Direction.SOUTH);
	}

	@Test
	public void formaterDataIn2() {
		assertThat(FormaterLine.formaterLineLawn("20 20")).isEqualTo(new Lawn(new Repere(20, 20)));
	}

	@Test
	public void formaterDataIn3() {
		assertThat(FormaterLine.formaterLigneInstruction("DGAD")).hasSize(4)
				.contains(MowerPossibleInstruction.RIGHT)
				.contains(MowerPossibleInstruction.LEFT)
				.contains(MowerPossibleInstruction.GO);
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
		
		assertThat(FormaterLine.getInstruction('A')).isEqualTo(MowerPossibleInstruction.GO);
		assertThat(FormaterLine.getInstruction('D')).isEqualTo(MowerPossibleInstruction.RIGHT);
		assertThat(FormaterLine.getInstruction('G')).isEqualTo(MowerPossibleInstruction.LEFT);
		assertThat(FormaterLine.getInstruction(' ')).isNull();
	}
	
	/*Test Controller ProcessInstruction*/
	
	@Test
	public void ProcessInstructionTest1() throws ExceptionMower {
		Repere maxCoord = new Repere(5, 5);
		int x = 2;
		int y = 3;
		Repere repere = new Repere(x, y);
		PositionMower positionTondeuse  = new  PositionMower(repere,Direction.SOUTH);
		ProcessInstrunction.executeInstruction(positionTondeuse, MowerPossibleInstruction.RIGHT, maxCoord);
		assertThat(positionTondeuse.getCoordMower()).isEqualTo(new Repere(x, y));
		assertThat(positionTondeuse.getDirectionMower()).isEqualTo(Direction.WEST);
	}
	
	
	@Test
	public void ProcessInstructionTest2() throws ExceptionMower{
		
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
	public void ProcessInstructionTest3() throws ExceptionMower{
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
