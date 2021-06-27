package sapient.monitnow.fne1.Utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sapient.monitnow.fne1.Controller.FormaterLine;
import sapient.monitnow.fne1.Controller.ProcessMower;
import sapient.monitnow.fne1.Exception.ExceptionMower;
import sapient.monitnow.fne1.entities.Params;
import sapient.monitnow.fne1.parser.ParserMower;
public class Utils {

	public List<String> runProcessMower(File fichier)
			throws ExceptionMower, IOException {
		if (!fichier.isFile()) {
			throw new ExceptionMower(Params.ERRORS_FILES);
		} else {
			ParserMower parser = new ParserMower();
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

	protected void readFirstLine(ParserMower parser, Scanner scanner)
			throws ExceptionMower {
		if (scanner.hasNext()) {
			parser.setLawn(scanner.nextLine());
		}
		if (!scanner.hasNext()) {
			throw new ExceptionMower(
					Params.ERRORS_DATA);
		}
	}


	private List<String> processNextLines(ParserMower parser,
			Scanner scanner) throws ExceptionMower {
		List<String> listePositions = new ArrayList<String>();
		while (scanner.hasNext()) {
			// lecture de la positon initiale de la tondeuse
			parser.setMower(scanner.nextLine());

			if (scanner.hasNext()) {
				parser.setInstructions(scanner.nextLine());
				listePositions.add(runProcessParser(parser));
			} else {
				throw new ExceptionMower(Params.ERRORS_DATA);
			}
		}
		return listePositions;
	}


	private String runProcessParser(ParserMower parser)
			throws ExceptionMower {
		if (!parser.executeParse()) {
			throw new ExceptionMower(Params.ERRORS_DATA);
		} else {
			ProcessMower processMower = new ProcessMower();
			processMower.setLawn(FormaterLine.formaterLineLawn(parser.getLawn()));
			processMower.setPosMower(FormaterLine.FormaterLineMower(parser.getMower()));
	
			processMower.setListInstruction(FormaterLine.formaterLigneInstruction(parser.getInstructions()));
			processMower.executeInstruction();
			System.out.println(processMower);
			return processMower.toString();
		}
	}
}
