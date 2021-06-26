package sapient.monitnow.fne1;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import sapient.monitnow.fne1.entities.Repere;

public class RepereTest {

	@Test
	public void test1(){
		Repere c1 = new Repere(15, 9);
		Repere c2 = new Repere(15, 9);
		assertThat(c1.equals(c2)).isTrue();
		c2 = new Repere(12, 3);
		assertThat(c1.equals(c2)).isFalse();
	}
	
	@Test
	public void test2(){
		Repere r = new Repere(7,8);
		Repere c0 = new Repere(-1,1);
		Repere c1 = new Repere(1,1);
		assertThat(r.isOutMaxRepere(c0)).isFalse();
		assertThat(r.isOutMaxRepere(c1)).isTrue();
	}
}
