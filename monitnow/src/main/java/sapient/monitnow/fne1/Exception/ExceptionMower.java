package sapient.monitnow.fne1.Exception;

/*
 * Class Exception permettant d'afficher les comportement non prevu.
 */
public class ExceptionMower extends Exception {

	
	private static final long serialVersionUID = -7187105553991729739L;

		public ExceptionMower(String message) {
	           super(message);
	     }
}
