package sapient.monitnow.fne1;

import static org.fest.assertions.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import sapient.monitnow.fne1.Controller.FormaterLine;
import sapient.monitnow.fne1.Controller.ProcessInstrunction;
import sapient.monitnow.fne1.Controller.ProcessMower;
import sapient.monitnow.fne1.Exception.ExceptionMower;
import sapient.monitnow.fne1.entities.Lawn;
import sapient.monitnow.fne1.entities.Params;
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
		assertThat(FormaterLine.formaterLigneInstruction("DGAAD")).hasSize(5)
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
		int x = 8;
		int y = 9;
		Repere repere = new Repere(x, y);
		PositionMower positionTondeuse  = new  PositionMower(repere,Direction.EAST);
		ProcessInstrunction.executeInstruction(positionTondeuse, MowerPossibleInstruction.RIGHT, maxCoord);
		assertThat(positionTondeuse.getCoordMower()).isEqualTo(new Repere(x, y));
		assertThat(positionTondeuse.getDirectionMower()).isEqualTo(Direction.SOUTH);
	}
	
	
	@Test
	public void ProcessInstructionTest2() throws ExceptionMower{
		
		Direction  nextDirection = ProcessInstrunction.rotateRight(Direction.SOUTH);
		
		assertThat(nextDirection).isEqualTo(Direction.WEST);
		
		nextDirection = ProcessInstrunction.rotateRight(Direction.NORTH);
		assertThat(nextDirection).isEqualTo(Direction.EAST);
		
		nextDirection = ProcessInstrunction.rotateRight(Direction.WEST);
		assertThat(nextDirection).isEqualTo(Direction.NORTH);
		
		nextDirection = ProcessInstrunction.rotateRight(Direction.EAST);
		assertThat(nextDirection).isEqualTo(Direction.SOUTH);
	}
	
	@Test
	public void ProcessInstructionTest3() throws ExceptionMower{
		Direction nextDirection = ProcessInstrunction.rotateLeft(Direction.NORTH);
		assertThat(nextDirection).isEqualTo(Direction.WEST);
		
		nextDirection = ProcessInstrunction.rotateLeft(Direction.EAST);
		assertThat(nextDirection).isEqualTo(Direction.NORTH);
		
		nextDirection = ProcessInstrunction.rotateLeft(Direction.NORTH);
		assertThat(nextDirection).isEqualTo(Direction.WEST);
	}
	
	Repere coordonneesMax = new Repere(20, 20);
	
	@Test
	public void notINstruction() throws ExceptionMower{
		int x = 0;
		int y = 0;
		Repere repere = new Repere(x, y);
		PositionMower positionMower  = new PositionMower(repere, Direction.WEST);
		ProcessMower processMower = new ProcessMower();
		
		processMower.setLawn(new Lawn(coordonneesMax));
		
		processMower.setPosMower(positionMower);
		processMower.setListInstruction(new ArrayList<sapient.monitnow.fne1.entities.Params.MowerPossibleInstruction>());
		processMower.executeInstruction();
		
		assertThat(processMower.toString()).isEqualTo("0 0 W");
		
	}
	
	@Test
	public void unitInstruction() throws ExceptionMower{
		List<MowerPossibleInstruction> listInstruction = new ArrayList<Params.MowerPossibleInstruction>();
		listInstruction.add(MowerPossibleInstruction.GO);
		int x = 6;
		int y = 9;
		Repere repere = new Repere(x, y);
		
		PositionMower positionMower = new PositionMower(repere, Direction.EAST);
		ProcessMower processMower = new ProcessMower();
		processMower.setLawn(new Lawn(coordonneesMax));
		processMower.setPosMower(positionMower);
		processMower.setListInstruction(listInstruction);
		processMower.executeInstruction();
		assertThat(processMower.toString()).isEqualTo("7 9 E");
	
	}
	
	
	@Test
	public void testlistInstruction() throws ExceptionMower{
		List<MowerPossibleInstruction> listInstruction = new ArrayList<sapient.monitnow.fne1.entities.Params.MowerPossibleInstruction>();
		listInstruction.add(MowerPossibleInstruction.RIGHT);
		listInstruction.add(MowerPossibleInstruction.GO);
		listInstruction.add(MowerPossibleInstruction.LEFT);
		listInstruction.add(MowerPossibleInstruction.GO);
		int x = 5;
		int y = 4;
		
		Repere repere = new Repere(x, y);
		
		PositionMower positionMower = new PositionMower(repere, Direction.SOUTH);
		ProcessMower  processMower = new ProcessMower();
		processMower.setLawn(new Lawn(coordonneesMax));
		processMower.setPosMower(positionMower);
		processMower.setListInstruction(listInstruction);
		processMower.executeInstruction();
		assertThat(processMower.toString()).isEqualTo("4 3 S");
	}
	

}
