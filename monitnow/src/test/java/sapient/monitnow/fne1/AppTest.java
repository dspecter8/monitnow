package sapient.monitnow.fne1;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import sapient.monitnow.fne1.Exception.ExceptionClipper;

/**
 * Unit test for simple App.
 */
public class AppTest {
	

	final String pathResourceFiles = "./src/test/resources/"; 
	

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}
	
	@Test
	public void main_fichier_erreur_fichier_xebia_ko() throws ExceptionClipper, IOException {
		expectedEx.expect(ExceptionClipper.class);
		expectedEx.expectMessage(sapient.monitnow.fne1.entities.Params.ERRORS_DATA);
		App.main(pathResourceFiles + "testOK.txt");
	}
}
