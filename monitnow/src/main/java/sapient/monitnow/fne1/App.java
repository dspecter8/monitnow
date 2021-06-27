package sapient.monitnow.fne1;

import java.io.File;
import java.io.IOException;
import java.util.List;


import sapient.monitnow.fne1.Exception.ExceptionMower;
import sapient.monitnow.fne1.Utils.Utils;

/**
 * Hello world!
 *
 */
public class App {

	protected static List<String> listResultats;

	
	public static void main(String... args) throws ExceptionMower, IOException {
		if (args.length == 1) {
			File file = new File(args[0]);
			Utils utils = new Utils();
			listResultats = utils.runProcessMower(file);
		} else {
			throw new IllegalArgumentException();
		}
	}
}
