package sapient.monitnow.fne1.entities;

public class Params {

	public static final String ERRORS_DATA = "incorrect data";
	public static final String ERRORS_FILES = "file not found";
	public static final String ERROR_DIRECTEION = "incorrect direction";
	public static final String ERROR_INSTRUCTION = "incorrect instruction";
	public static final String ERROR_POSITION = "incorrect position";

	private Params() {

	}

	/*
	 * Les direction Cardinales
	 */
	public static enum Direction {
		NORTH('N', "North"), EAST('E', "East"), WEST('W', "West"), SOUTH('S', "South");

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

	/*
	 * Listes de mouvement possible
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