package logWriter;

import java.io.IOException;

public class LogMain {
	public static void main(String[] args) {
		LogWriter l1 = new LogWriter();
		try {
			l1.writeToFile("This text should show up in log.txt");
			l1.writeToFile("This will show up on Line 2!");
			l1.writeToFile("Error", "This is an Error on line 3.");
			
		} catch (IOException | FileTooLargeException  | FileWriteFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			int i = 0;
			while(i < 1000){
				l1.writeToFile("Text #" + i);
				i++;
			}
		} catch (FileWriteFailedException | FileTooLargeException | IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
