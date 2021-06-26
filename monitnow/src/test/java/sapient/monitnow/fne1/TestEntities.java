package sapient.monitnow.fne1;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import sapient.monitnow.fne1.entities.Lawn;
import sapient.monitnow.fne1.entities.PositionClipper;
import sapient.monitnow.fne1.entities.Repere;
import sapient.monitnow.fne1.entities.Params.Direction;

public class TestEntities {

	/*Test Entité Lawn*/
	/*
	 * Test Equals de Lawn -->Entité Lawn
	 */
	@Test
	public void LawnTest1() {
		Lawn lawn1 = new Lawn(new Repere(5, 2));
		Lawn lawn2 = new Lawn(new Repere(5, 2));
		assertThat(lawn1.equals(lawn2)).isTrue();
		lawn2 = new Lawn(new Repere(1, 3));
		assertThat(lawn1.equals(lawn2)).isFalse();
	}
	
	/*Test Entité Repere*/
	/**
	 * Test method Equals
	 */
	@Test
	public void RepereTest1(){
		Repere c1 = new Repere(15, 9);
		Repere c2 = new Repere(15, 9);
		assertThat(c1.equals(c2)).isTrue();
		c2 = new Repere(12, 3);
		assertThat(c1.equals(c2)).isFalse();
	}
	
	/*
	 * Test isOutMaxRepere
	 */
	@Test
	public void repereTest2(){
		Repere r = new Repere(7,8);
		Repere c0 = new Repere(-1,1);
		Repere c1 = new Repere(1,1);
		assertThat(r.isOutMaxRepere(c0)).isFalse();
		assertThat(r.isOutMaxRepere(c1)).isTrue();
	}
	
	/*Test Entité PositionTondeuse*/
	/*
	 * Test position de la tondeuse dans le repère
	 */
	@Test
	public void ClipperTest1() {
		
		PositionClipper clipper1 = new PositionClipper(new Repere(5, 5), Direction.NORTH);
		PositionClipper clipperOK = new PositionClipper(new Repere(5, 5), Direction.NORTH);
		PositionClipper clipperKO = new PositionClipper(new Repere(5, 5), Direction.SOUTH);
		
		assertThat(clipper1.equals(clipperOK)).isTrue();
		assertThat(clipper1.equals(clipperKO)).isFalse();
	}
}
