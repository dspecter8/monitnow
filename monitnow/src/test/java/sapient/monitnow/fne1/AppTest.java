package sapient.monitnow.fne1;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import sapient.monitnow.fne1.Exception.ExceptionMower;

/**
 * Unit test for simple App.
 */
public class AppTest {
	

	final String pathResourceFiles = "./src/test/resources/"; 
	

	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}
	
	@Test
	public void testKO() throws ExceptionMower, IOException {
		expectedException.expect(ExceptionMower.class);
		expectedException.expectMessage(sapient.monitnow.fne1.entities.Params.ERRORS_DATA);
		App.main(pathResourceFiles + "testKO.txt");
	}
	
	@Test
	public void testOK() throws ExceptionMower, IOException {
		App.main(pathResourceFiles + "testOK.txt");
		assertThat(App.listResultats).isNotNull();
		assertThat(App.listResultats).hasSize(2).contains("1 3 N").contains("5 1 E");
		
	}
	
	@Test
	public void testFileNotFoud() throws ExceptionMower, IOException {
		expectedException.expect(ExceptionMower.class);
		expectedException.expectMessage(sapient.monitnow.fne1.entities.Params.ERRORS_FILES);
		App.main("noFile");
	}
	
	@Test
	public void fileEmpty() throws ExceptionMower, IOException {
		expectedException.expect(ExceptionMower.class);
		expectedException.expectMessage(sapient.monitnow.fne1.entities.Params.ERRORS_DATA);
		App.main(pathResourceFiles + "fileEmpty.txt");

	}
	
	@Test
	public void dataInComplet() throws ExceptionMower, IOException {
		expectedException.expect(ExceptionMower.class);
		expectedException.expectMessage(sapient.monitnow.fne1.entities.Params.ERRORS_DATA);
		App.main(pathResourceFiles + "incorrectData.txt");
	}
	@Test
	public void dataInComplet1() throws ExceptionMower, IOException {
		expectedException.expect(ExceptionMower.class);
		expectedException.expectMessage(sapient.monitnow.fne1.entities.Params.ERRORS_DATA);
		App.main(pathResourceFiles + "incorrectData1.txt");
	}
	
}
