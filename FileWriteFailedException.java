package logWriter;

public class FileWriteFailedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FileWriteFailedException(){
		super("Failed to Write to File.");
	}

}
