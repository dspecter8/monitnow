package sapient.monitnow.fne1.entities;

public class Params {

	public static final String ERRORS_DATA = "données incorrectes";
	public static final String ERRORS_FILES = "fichier inexistant";
	public static final String ERROR_DIRECTEION = "orientation incorrecte";
	public static final String ERROR_INSTRUCTION = "instruction incorrecte";
	public static final String ERROR_POSITION = "position incorrecte";

	private Params() {

	}

	public static enum Direction {
		NORTH('N', "Nord"), EAST('E', "Est"), WEST('W', "Ouest"), SOUTH('S', "Sud");

		private char codeDirection;
		private String descriptionDirection;

		private Direction(char codeDirection, String descriptionDirection) {
			this.codeDirection = codeDirection;
			this.descriptionDirection = descriptionDirection;
		}

		public char getCodeDirection() {
			return codeDirection;
		}

		public void setCodeDirection(char codeDirection) {
			this.codeDirection = codeDirection;
		}

		public String getDescriptionDirection() {
			return descriptionDirection;
		}

		public void setDescriptionDirection(String descriptionDirection) {
			this.descriptionDirection = descriptionDirection;
		}

	}

	/**
	 * instructions possibles
	 * 
	 * @author sgmira
	 *
	 */
	public static enum ClipperPossibleInstruction {
		RIGHT('D', "Pivoter droite"), LEFT('G', "Pivoter gauche"), MOOV('A', "Avancer");

		private String descriptionInstruction;
		private char codeInstruction;

		private ClipperPossibleInstruction(char codeInstruction, String descriptionInstruction) {
			this.descriptionInstruction = descriptionInstruction;
			this.codeInstruction = codeInstruction;
		}

		public String getDescriptionInstruction() {
			return descriptionInstruction;
		}

		public void setDescriptionInstruction(String descriptionInstruction) {
			this.descriptionInstruction = descriptionInstruction;
		}

		public char getCodeInstruction() {
			return codeInstruction;
		}

		public void setCodeInstruction(char codeInstruction) {
			this.codeInstruction = codeInstruction;
		}

	}

}