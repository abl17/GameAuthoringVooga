package DESIGN.datafiles;

public class GameFileException extends Exception {
	/**
	 *  General file exception
	 */
	private static final long serialVersionUID = 1L;
	public GameFileException(){
		super();
	}
	public GameFileException(String format) {
		super(format);
	}
}
