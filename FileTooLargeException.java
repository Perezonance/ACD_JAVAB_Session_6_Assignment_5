package logWriter;

public class FileTooLargeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FileTooLargeException(long size){
		super("LOG FILE IS TOO LARGE TO BE WRITTEN. FILE SIZE: " + size);
	}

}
