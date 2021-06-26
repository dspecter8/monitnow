package sapient.monitnow.fne1.Utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sapient.monitnow.fne1.Controller.FormaterLine;
import sapient.monitnow.fne1.Controller.ProcessClipper;
import sapient.monitnow.fne1.Exception.ExceptionClipper;
import sapient.monitnow.fne1.entities.Params;
import sapient.monitnow.fne1.parser.ParserClipper;
public class Utils {

	public List<String> runProcessClipper(File fichier)
			throws ExceptionClipper, IOException {
		if (!fichier.isFile()) {
			throw new ExceptionClipper(Params.ERRORS_FILES);
		} else {
			ParserClipper parser = new ParserClipper();
			Scanner scanner = new Scanner(fichier);
			try {
				readFirstLine(parser, scanner);
				return processNextLines(parser, scanner);
			} finally {
				if (scanner != null) {
					scanner.close();
				}
			}
		}
	}

	protected void readFirstLine(ParserClipper parser, Scanner scanner)
			throws ExceptionClipper {
		if (scanner.hasNext()) {
			parser.setLawn(scanner.nextLine());
		}
		if (!scanner.hasNext()) {
			throw new ExceptionClipper(
					Params.ERRORS_DATA);
		}
	}


	private List<String> processNextLines(ParserClipper parser,
			Scanner scanner) throws ExceptionClipper {
		List<String> listePositions = new ArrayList<String>();
		while (scanner.hasNext()) {
			// lecture de la positon initiale de la tondeuse
			parser.setClipper(scanner.nextLine());

			if (scanner.hasNext()) {
				parser.setInstructions(scanner.nextLine());
				listePositions.add(parserEtLancerTraitement(parser));
			} else {
				throw new ExceptionClipper(Params.ERRORS_DATA);
			}
		}
		return listePositions;
	}


	private String parserEtLancerTraitement(ParserClipper parser)
			throws ExceptionClipper {
		if (!parser.executeParse()) {
			throw new ExceptionClipper(Params.ERRORS_DATA);
		} else {
			ProcessClipper processClipper = new ProcessClipper();
			processClipper.setLawn(FormaterLine.formaterLineLawn(parser.getLawn()));
			processClipper.setPosClipper(FormaterLine.FormaterLineClipper(parser.getClipper()));
	
			processClipper.setListInstruction(FormaterLine.formaterLigneInstruction(parser.getInstructions()));
			processClipper.executeInstruction();
			System.out.println(processClipper);
			return processClipper.toString();
		}
	}
}
