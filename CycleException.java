/**
 * Exception levée lorsqu'un cycle est détecté parmi les traitements
 */
public class CycleException extends Exception {
	private static final long serialVersionUID = 1L;

	public CycleException(String message) {
		super(message);
	}
}
