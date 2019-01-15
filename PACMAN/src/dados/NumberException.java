package dados;

public class NumberException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NumberException() {
		super();
	}

	public boolean EhNumero(String nome) {
		for (int i = 0; i < nome.length(); i++) {
			if (Character.isDigit(nome.charAt(i))) {
				return true;
			}
		}
		return false;
	}

}
