package sapient.monitnow.fne1;

import static org.fest.assertions.Assertions.assertThat;
import sapient.monitnow.fne1.entities.Params.Direction;
import sapient.monitnow.fne1.entities.PositionClipper;
import sapient.monitnow.fne1.entities.Repere;

import org.junit.Test;

public class PosClipperTest {

	@Test
	public void Test1() {
		
		PositionClipper clipper1 = new PositionClipper(new Repere(5, 5), Direction.NORTH);
		PositionClipper clipperOK = new PositionClipper(new Repere(5, 5), Direction.NORTH);
		PositionClipper clipperKO = new PositionClipper(new Repere(5, 5), Direction.SOUTH);
		
		assertThat(clipper1.equals(clipperOK)).isTrue();
		assertThat(clipper1.equals(clipperKO)).isFalse();
	}

}
