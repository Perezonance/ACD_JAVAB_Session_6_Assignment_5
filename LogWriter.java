package logWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogWriter {
	
	private File f = new File("logFiles/log.txt");
	private String timestamp;

	public LogWriter(){
		if(f.exists()){
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
			this.timestamp = myDateObj.format(formatter);
			System.out.println("File was found!");
			
			File newF = new File("logFiles/log-" + timestamp + ".txt");
			f.renameTo(newF);
		}else{
			try {
				if(f.createNewFile()){
					System.out.println("File Object is created " + f.getName());
				}else{
					System.out.println("File was not created");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void writeToFile(String text) throws IOException, FileTooLargeException, FileWriteFailedException{
		if(checkSize()){
		BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
		bw.write("[" + timestamp + "]:[Log]:" + text + "\n");
		bw.flush();
		bw.close();
		}else{
			throw new FileTooLargeException(f.length());
		}
		
	}
	public void writeToFile(String textType, String text) throws IOException, FileTooLargeException, FileWriteFailedException{
		if(checkSize()){
			BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
			PrintWriter out = new PrintWriter(bw);
			
			out.print("[" + timestamp + "]:["+ textType+"]:" + text + "\n");
			
			
			out.close();
		}else{
			throw new FileTooLargeException(f.length());
		}
	}
	public boolean checkSize(){
		if(f.length() <= 5000000)
			return true;
		else
			return false;
		}
	public long getSize(){
		return f.length();
	}
	}

