package sapient.monitnow.fne1;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import sapient.monitnow.fne1.entities.Lawn;
import sapient.monitnow.fne1.entities.Repere;

public class LawnTest {

	@Test
	public void test1() {
		Lawn lawn1 = new Lawn(new Repere(5, 2));
		Lawn lawn2 = new Lawn(new Repere(5, 2));
		assertThat(lawn1.equals(lawn2)).isTrue();
		lawn2 = new Lawn(new Repere(1, 3));
		assertThat(lawn1.equals(lawn2)).isFalse();
	}
}
